package com.LegacyTests.ProductTestEx10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductTestEx10 extends ParalelTestBase {

    private WebElement regularPriceElement;
    private WebElement salePriceElement;

    private class Product {
        private String name;
        private boolean haveSale;
        private Price price;
        private String link;

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", haveSale=" + haveSale +
                    ", price=" + price +
                    ", link='" + link + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Product)) return false;
            Product product = (Product) o;
            return haveSale == product.haveSale &&
                    Objects.equals(name, product.name) &&
                    Objects.equals(price, product.price);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, haveSale, price, link);
        }
    }

    private class Price {
        private String regularValue;
        private String regularFontSize;
        private String regularFontDecoration;
        private String regularFontWeight;
        private String saleValue;
        private String saleFontSize;
        private String saleFontDecoration;
        private String saleFontWeight;


        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (!(o instanceof Price)) return false;
            Price price = (Price) o;
            return Objects.equals(regularValue, price.regularValue) &&
                    Objects.equals(saleValue, price.saleValue);
        }

        @Override
        public int hashCode() {
            return Objects.hash(regularValue, regularFontWeight, regularFontSize, regularFontDecoration, saleValue, saleFontWeight, saleFontSize, saleFontDecoration);
        }

        @Override
        public String toString() {
            return "Price{" +
                    "regValue='" + regularValue + '\'' +
                    ", regFSize='" + regularFontSize + '\'' +
                    ", regFDec='" + regularFontDecoration + '\'' +
                    ", regFWeight='" + regularFontWeight + '\'' +
                    ", saleValue='" + saleValue + '\'' +
                    ", saleFSize='" + saleFontSize + '\'' +
                    ", saleFDec='" + saleFontDecoration + '\'' +
                    ", saleFWeight='" + saleFontWeight + '\'' +
                    '}';
        }
    }

    private void getRegularPriceProperties(WebElement productElement, Product product) {
        regularPriceElement = productElement.findElement(By.cssSelector("span.price"));
        product.price.regularValue = regularPriceElement.getText();
        product.price.regularFontSize = regularPriceElement.getCssValue("font-size");
        product.price.regularFontDecoration = regularPriceElement.getCssValue("text-decoration");
        product.price.regularFontWeight = regularPriceElement.getCssValue("font-weight");
    }

    private void getSaleAndRegularPriceProperties(WebElement productElement, Product product) {
        product.haveSale = true;
        regularPriceElement = productElement.findElement(By.cssSelector("s.regular-price"));
        product.price.regularValue = regularPriceElement.getText();
        product.price.regularFontSize = regularPriceElement.getCssValue("font-size");
        product.price.regularFontDecoration = regularPriceElement.getCssValue("text-decoration");
        product.price.regularFontWeight = regularPriceElement.getCssValue("font-weight");
        salePriceElement = productElement.findElement(By.cssSelector("strong.campaign-price"));
        product.price.saleValue = salePriceElement.getText();
        product.price.saleFontSize = salePriceElement.getCssValue("font-size");
        product.price.saleFontDecoration = salePriceElement.getCssValue("text-decoration");
        product.price.saleFontWeight = salePriceElement.getCssValue("font-weight");
    }

    private class RGBColor {
        private int red;
        private int green;
        private int blue;
    }

    private RGBColor getRGB(String cssValue) {
        RGBColor rgbColor = new RGBColor();
        Pattern p = Pattern.compile("([\\d]+),\\s([\\d]+),\\s([\\d]+)");
        Matcher m = p.matcher(cssValue);
        while (m.find()) {
            rgbColor.red = Integer.parseInt(m.group(1));
            rgbColor.green = Integer.parseInt(m.group(2));
            rgbColor.blue = Integer.parseInt(m.group(3));
        }
        return rgbColor;
    }

    @Test
    public void test() {
        driver.get("http://localhost/litecart");
        List<WebElement> productElements = driver.findElements(By.cssSelector("[class^='product']"));
        Set<Product> products = new HashSet<>();
        for (WebElement element : productElements) {
            Product product = new Product();
            product.name = element.findElement(By.cssSelector("a.link div.name")).getText();
            product.link = element.findElement(By.cssSelector("a.link")).getAttribute("href");
            product.price = new Price();
            try {
                getRegularPriceProperties(element, product);
            } catch (org.openqa.selenium.NoSuchElementException e) {
                getSaleAndRegularPriceProperties(element, product);
            }
            products.add(product);
        }
        for (Product product : products) {
            driver.get(product.link);
            Product product2 = new Product();
            WebElement productElement = driver.findElement(By.id("box-product"));
            product2.name = driver.findElement(By.cssSelector("h1.title")).getText();
            product2.price = new Price();
            if (!product.haveSale) {
                getRegularPriceProperties(productElement, product2);
            } else {
                getSaleAndRegularPriceProperties(productElement, product2);
            }
//            System.out.println(product);
//            System.out.println(product2);
            Assert.assertEquals(product, product2);
            RGBColor rgbColor = getRGB(product.price.regularFontDecoration);
            Assert.assertEquals(rgbColor.blue, rgbColor.red, rgbColor.green);
            rgbColor = getRGB(product2.price.regularFontDecoration);
            Assert.assertEquals(rgbColor.blue, rgbColor.red, rgbColor.green);
            if (product.haveSale) {
                rgbColor = getRGB(product.price.saleFontDecoration);
                Assert.assertEquals(rgbColor.blue, rgbColor.green, 0);
                rgbColor = getRGB(product2.price.saleFontDecoration);
                Assert.assertEquals(rgbColor.blue, rgbColor.green, 0);
                Assert.assertTrue(product.price.regularFontDecoration.startsWith("line-through"));
                Assert.assertTrue(product2.price.regularFontDecoration.startsWith("line-through"));
                Assert.assertTrue(Double.parseDouble(product.price.saleFontWeight) >= 600);
                Assert.assertTrue(Double.parseDouble(product2.price.saleFontWeight) >= 600);
                Assert.assertTrue(Double.parseDouble(product.price.regularFontSize.replace("px", "")) <
                        Double.parseDouble(product.price.saleFontSize.replace("px", "")));
                Assert.assertTrue(Double.parseDouble(product2.price.regularFontSize.replace("px", "")) <
                        Double.parseDouble(product2.price.saleFontSize.replace("px", "")));
            }
        }
    }
}
