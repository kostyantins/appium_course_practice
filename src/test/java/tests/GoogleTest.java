package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.TestRunner;

public class GoogleTest extends TestRunner {

    @Test
    public final void testGoogleOpen(){

        Assert.assertTrue(getDriver().findElement(By.id("hplogo")).isDisplayed());
    }
}

