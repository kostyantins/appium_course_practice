package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.GmailMessagePage;
import pageobjects.GmailPage;
import pageobjects.GoogleHomePage;
import util.TestRunner;

import static com.codeborne.selenide.Selenide.$;

public class SendGmailMessageTest extends TestRunner {

    @BeforeMethod
    public final void initializationPageObject(){

//         googleHomePage = new GoogleHomePage();
//         gmailPage = new GmailPage();
//         gmailMessagePage = new GmailMessagePage();
    }

    @Test
    public final void testGoogleLogoExist() {

//        googleHomePage
//                .openGmailPage()
//                .doLogin();

        $(By.xpath("//*[@id='tltbt']/div[4]/div")).click();
        $(By.id("composeto")).sendKeys("kostyantins@gmail.com");
        $(By.id("cmcsubj")).sendKeys("AppiumTest");
        $(By.xpath("//*[@id='cvtbt']/div[4]/div")).click(); //sentButton
        $(By.xpath("//*[@id='tltbt']/div[2]/div[2]")).click();
        $(By.xpath("//*[@id='mn_']/div[2]/div/div/div[9]")).click(); //sent link

        Assert.assertEquals($(By.xpath("((//*[@class='fm']/div)[1]//span)[3]")).text(), "AppiumTest");
    }
}
