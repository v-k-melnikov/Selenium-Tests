import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SectionsTestEx7 extends TestBase {

    @Test
    public void test()   {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        int numOfSections = driver.findElements(By.cssSelector("li[id='app-']")).size();
        for (int i = 1; i <= numOfSections; i++) {
            driver.findElement(By.cssSelector("li[id='app-']:nth-of-type(" + i + ")")).click();
            int numOfItems = driver.findElements(By.cssSelector("li[id^='doc'")).size();
            for (int j = 1; j <= numOfItems; j++) {
                driver.findElement(By.cssSelector(".docs li:nth-of-type(" + j + ")")).click();
                driver.findElement(By.tagName("h1"));
            }
        }
    }
}
