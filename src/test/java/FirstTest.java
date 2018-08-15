import org.junit.Test;

public class FirstTest extends TestBase {


    @Test
    public void firstTest() {
        driver.get("https://yandex.ru");
    }

    public static void main(String[] args) {
        FirstTest test = new FirstTest();
        test.setUp();
        test.firstTest();
        test.tearDown();
    }
}
