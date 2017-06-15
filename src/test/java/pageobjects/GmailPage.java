package pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GmailPage {

    private static final By EMAIL_INPUT = By.id("Email");
    private static final By NEXT_BUTTON = By.id("next");
    private static final By PASS_INPUT = By.id("Passwd");
    private static final By LOGIN_BUTTON = By.id("signIn");

    public final GmailMessagePage doLogin() {

        $(EMAIL_INPUT).sendKeys("kostyantins@gmail.com");
        $(NEXT_BUTTON).click();
        $(PASS_INPUT).sendKeys("KOS664482");
        $(LOGIN_BUTTON).click();

        return new GmailMessagePage();
    }
}
