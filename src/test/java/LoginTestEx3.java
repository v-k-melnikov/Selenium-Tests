import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTestEx3 extends TestBase {

    @Test
    public void test() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

}
