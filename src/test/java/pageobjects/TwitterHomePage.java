package pageobjects;

import org.openqa.selenium.By;
import util.AppiumUtils;

import static com.codeborne.selenide.Selenide.$;
import static util.TestRunner.getDriver;

public class TwitterHomePage {

    public static By byHomeLbl = By.id("home");
    public static By byMenuBtn = By.id("drawer_icon");
    public static By byMessageTabSel = By.xpath("//android.view.View[@content-desc='Selected. Messages Tab']");

    public TwitterHomePage(boolean closePopups) throws InterruptedException {

        if (closePopups) {
            AppiumUtils.closePopups();
        }

        $(byHomeLbl);

    }

    public TwitterHomePage openMenu() throws InterruptedException {

        $(byMenuBtn).click();

        return new TwitterHomePage(true);
    }

    public boolean isMessageTabSelected() {

        if (getDriver().findElements(byMessageTabSel).size() == 1) {
            System.out.println("Found tab selected element");
            return true;
        } else {
            System.out.println("Could not find tab selected element");
            return false;
        }
    }
}
