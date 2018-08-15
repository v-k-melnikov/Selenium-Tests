import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends TestBase {

    @Test
    public void loginTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public static void main(String[] args) {
        LoginTest test = new LoginTest();
        test.setUp();
        test.loginTest();
//        test.tearDown();
    }
}
