package pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GoogleHomePage {

    private static final By GOOGLE_MENU_LINK = By.xpath("//*[@id='gbwa']//a[@class='gb_b gb_5b']");
    private static final By GMAIL_LINK = By.id("gb23");

    public final GmailPage openGmailPage() {

        $(GOOGLE_MENU_LINK).click();
        $(GMAIL_LINK).click();

        return new GmailPage();
    }
}
