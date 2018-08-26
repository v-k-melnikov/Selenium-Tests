import org.testng.annotations.Test;

public class FirstTest extends TestBase {


    @Test
    public void test() {
        driver.get("https://yandex.ru");
    }


}
