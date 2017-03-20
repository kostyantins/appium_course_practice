package util;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestRunner {

    private static final ThreadLocal<AndroidDriver> DRIVER = new ThreadLocal<AndroidDriver>();

    public static AndroidDriver getDriver() {
        return DRIVER.get();
    }

    @BeforeMethod
    public void setUp() {
        if (DRIVER.get() == null) {
            try {
                final String localAppiumServerURL = "http://127.0.0.1:4723/wd/hub";
                DRIVER.set(new AndroidDriver(new URL(localAppiumServerURL), CapabilitiesEmulator.CHROME_CAPABILITIES()));
            } catch (MalformedURLException e) {
                System.out.println("Mailformed URL address");
                e.printStackTrace();
            }

            getDriver()
                    .get("https://www.google.com");

            getDriver()
                    .manage()
                    .timeouts()
                    .implicitlyWait(20, TimeUnit.SECONDS);
        }
    }

    @AfterMethod
    public void afterTest() {

        if (DRIVER.get() != null) {
            DRIVER.get().close();
            DRIVER.remove();
        }
    }
}

