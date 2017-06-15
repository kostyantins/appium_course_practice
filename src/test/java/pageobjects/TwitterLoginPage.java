package pageobjects;

import org.openqa.selenium.By;
import util.AppiumUtils;

import static com.codeborne.selenide.Selenide.$;
import static util.TestRunner.getDriver;


public class TwitterLoginPage {

    public final By BY_LOGIN_FIRST = By.id("log_in");
    public final By BY_EMAIL = By.id("login_identifier");
    public final By BY_PASS = By.id("login_password");
    public final By BY_LOGIN_SECOND = By.id("login_login");

//    public TwitterLoginPage() throws InterruptedException {
//        AppiumUtils.closePopups();
//    }

    public TwitterHomePage login(String user, String pass) throws InterruptedException {

        $(BY_LOGIN_FIRST).click();
        $(BY_EMAIL).sendKeys(user);
        $(BY_PASS).sendKeys(pass);
        $(BY_LOGIN_SECOND).click();

        return new TwitterHomePage(true);
    }
}
