package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.TestRunner;

import static com.codeborne.selenide.Selenide.$;

public class GoogleLogoExistTest extends TestRunner {

    @Test
    public final void testGoogleLogoExist(){

        Assert.assertTrue($(By.id("hplogo")).isDisplayed());
    }
}