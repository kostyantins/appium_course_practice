package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.By;

import static util.TestRunner.getDriver;

public class TwitterMenuPage {

    public static By byHomeLbl = By.className("android.widget.Switch");

    public TwitterHomePage switchNightMode(String status) throws InterruptedException {

        MobileElement nModeSwitch = (MobileElement) getDriver().findElement(byHomeLbl);

        String actualValue = nModeSwitch.getText();
        System.out.println("Switching to: " + status + "Actual value = " + actualValue);

        if (status.toLowerCase().equals("on") && actualValue.toLowerCase().equals("off")) {
            nModeSwitch.swipe(SwipeElementDirection.RIGHT, 1000);
        } else if (status.toLowerCase().equals("off") && actualValue.toLowerCase().equals("on")) {
            nModeSwitch.click();
        }
        getDriver().navigate().back();

        Thread.sleep(1000);

        return new TwitterHomePage(false);
    }
}
