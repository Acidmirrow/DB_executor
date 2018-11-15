package tests;

import com.codeborne.selenide.Condition;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AutotestForAPI {

    @BeforeClass
    public static void startAPI () {
        System.setProperty("webdriver.chrome.driver", "data/webdriver/chromedriver.exe");
        open ("http://127.0.0.1:8081/SQL/request");
    }

    @Test
    public void checkSelectWithOneParameter (){
        $(By.xpath("//input[@type='text']")).setValue("Select Region from sales limit 10");
        $(By.xpath("//input[@type='submit']")).click();
        $(By.xpath("//pre[contains(.,'region')]")).shouldBe(Condition.visible);
        sleep(10000);
    }

    @Test
    public void checkSelectWithAllParameters () {
        $(By.xpath("//input[@type='text']")).setValue("Select * from sales limit 10");
        $(By.xpath("//input[@type='submit']")).click();
        $(By.xpath("//pre[contains(.,'region')]")).shouldBe(Condition.visible);
        sleep(10000);
    }


}

