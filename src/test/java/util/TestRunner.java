package util;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.GmailMessagePage;
import pageobjects.GmailPage;
import pageobjects.GoogleHomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class TestRunner {

    private static final ThreadLocal<AndroidDriver> DRIVER = new ThreadLocal<AndroidDriver>();

    public static AndroidDriver getDriver() {
        return DRIVER.get();
    }

//    protected GoogleHomePage googleHomePage;
//    protected GmailPage gmailPage;
//    protected GmailMessagePage gmailMessagePage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        if (DRIVER.get() == null) {
            final String localAppiumServerURL = "http://127.0.0.1:4723/wd/hub";

            DRIVER.set(new AndroidDriver(new URL(localAppiumServerURL), CapabilitiesEmulator.TWITTER_CAPABILITIES()));

            WebDriverRunner.setWebDriver(getDriver());
        }

        //For google tests "https://www.google.com"
        // For twitter tests U should commit 'open' section

//        open("https://www.google.com");

//        getDriver()
//                .get("https://www.google.com");

//        getDriver()
//                .manage()
//                .timeouts()
//                .implicitlyWait(20, TimeUnit.SECONDS);
    }

    //don't need when U use Selenide framework
//    @AfterMethod
//    public void afterTest() {
//
//        if (DRIVER.get() != null) {
//            DRIVER.get().close();
//            DRIVER.remove();
//        }
//    }
}

