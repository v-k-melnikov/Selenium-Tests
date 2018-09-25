package com.legacytests;

import org.testng.annotations.Test;

public class FirstTestEx1 extends TestBase {


    @Test
    public void test() {
        driver.get("https://yandex.ru");
    }


}
