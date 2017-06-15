package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import util.TestRunner;

import static com.codeborne.selenide.Selenide.$;
import static util.AppiumUtils.swipeLeft;
import static util.AppiumUtils.swipeRight;

public class TwitterTest extends TestRunner {

    public static final By BY_LOGIN_FIRST = By.id("com.twitter.android:id/log_in");
    public static final By BY_EMAIL = By.id("com.twitter.android:id/login_identifier");
    public static final By BY_PASS = By.id("com.twitter.android:id/login_password");
    public static final By LOGIN_BUTTON = By.id("com.twitter.android:id/login_login");

    public static final By PHOTO_ICON = By.id("drawer_icon");
    public static final By NIGHT_MODE_BUTTON = By.className("android.widget.Switch");
    public static final By TITLE = By.id("com.twitter.android:id/empty_title");
    public static final By SETTINGS = By.xpath("//android.widget.TextView[@text='Settings and privacy']");
    public static final By LOGOUT_LINK = By.xpath("//android.widget.TextView[@text='Log out']");
    public static final By EXCEPT_ALERT = By.id("android:id/button1");

    public static final By byHomeLbl = By.id("home");
    public static final By byMenuBtn = By.id("drawer_icon");
    public static final By byMessageTabSel = By.xpath("//android.view.View[@content-desc='Selected. Messages Tab']");

    public static final By byHomeLbl1 = By.className("android.widget.Switch");

    @Test
    public static void testEnableNightMode() throws InterruptedException {

        $(BY_LOGIN_FIRST).click();
        $(BY_EMAIL).sendKeys("kostyantins@mail.ru");
        $(BY_PASS).sendKeys("100784664482");
        $(LOGIN_BUTTON).click();

        $(PHOTO_ICON).click();
        $(NIGHT_MODE_BUTTON).click();

        swipeLeft(1);
        swipeRight(2);

        $(NIGHT_MODE_BUTTON).click();

        Assert.assertEquals($(TITLE).getText(), "What? No Tweets yet?");
    }

    @AfterMethod
    public final void tearDown() throws InterruptedException {

        swipeRight(1);
        $(SETTINGS).click();
        $(LOGOUT_LINK).click();
        $(EXCEPT_ALERT).click();
    }
}
