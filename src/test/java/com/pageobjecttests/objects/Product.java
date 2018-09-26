package com.pageobjecttests.objects;


import java.util.Objects;

public class Product {
    private String name;
    private boolean haveDiscount;
    private String price;
    private String discountPrice;
    private String link;
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public boolean isHaveDiscount() {
        return haveDiscount;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public String getLink() {
        return link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHaveDiscount(boolean haveDiscount) {
        this.haveDiscount = haveDiscount;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", haveDiscount=" + haveDiscount +
                ", price=" + price +
                ", discountPrice=" + discountPrice +
                ", imagePath=" + imagePath +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return haveDiscount == product.haveDiscount &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(discountPrice, product.discountPrice) &&
                Objects.equals(imagePath, product.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, haveDiscount, price, discountPrice, link, imagePath);
    }
}