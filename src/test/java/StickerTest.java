import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StickerTest extends TestBase {
    private int numOfStickers;

    @Test
    public void test()  {
        driver.get("http://localhost/litecart");
        List<WebElement> products = driver.findElements(By.cssSelector("li[class='product column shadow hover-light']"));
        for (WebElement product : products) {
            numOfStickers = product.findElements(By.cssSelector("a.link div.image-wrapper div[class^='sticker']")).size();
            Assert.assertEquals(1, numOfStickers);
        }
    }
}
