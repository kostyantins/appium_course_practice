package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static util.TestRunner.getDriver;

public class AppiumUtils {

    private static boolean waitAndClickIfExists(By byElement) throws InterruptedException {

        int defaultTimeout = 20;

        getDriver()
                .manage()
                .timeouts()
                .implicitlyWait(1, TimeUnit.SECONDS);

        for (int i = 0; i < 3; i++) {
            List<WebElement> listElements = getDriver().findElements(byElement);
            if (listElements.isEmpty() == false) {
                listElements.get(0).click();

                getDriver()
                        .manage()
                        .timeouts()
                        .implicitlyWait(defaultTimeout, TimeUnit.SECONDS);

                return true;
            }
            Thread.sleep(1000);
        }

        getDriver()
                .manage()
                .timeouts()
                .implicitlyWait(defaultTimeout, TimeUnit.SECONDS);

        return false;
    }

    public static void closePopups() throws InterruptedException {

        By okButton = By.xpath("//android.widget.Button[@text='OK']");
        By allowButton = By.xpath("//android.widget.Button[@text='Allow']");

        $(okButton).click();
        $(allowButton).click();

//        AppiumUtils.waitAndClickIfExists(okButton);
//        AppiumUtils.waitAndClickIfExists(allowButton);
    }

    public static void swipeLeft(int count) throws InterruptedException {

        int height = getDriver().manage().window().getSize().getHeight();
        int width = getDriver().manage().window().getSize().getWidth();

        Thread.sleep(1000);

        for (int i = 0; i < count; i++) {
            getDriver().swipe(width - 50, height / 2, 10, height / 2, 2000);

        }
    }

    public static void swipeRight(int count) throws InterruptedException {

        int height = getDriver().manage().window().getSize().getHeight();
        int width = getDriver().manage().window().getSize().getWidth();

        Thread.sleep(1000);

        for (int i = 0; i < count; i++) {
            getDriver().swipe(50, height / 2, width - 50, height / 2, 2000);
        }
    }
}
