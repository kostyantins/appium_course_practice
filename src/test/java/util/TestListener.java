package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult arg0) {

        String destDir = "target/screenshots";
        File scrFile = ((TakesScreenshot) TestRunner.getDriver()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_hh_mm_ssaa");
        new File(destDir).mkdirs();
        String destFile = arg0.getName() + "_" + dateFormat.format(new Date()) + ".png";
        System.out.println("Taking screenshot:" + destFile);

        try {
            File destF = new File(destDir + "/" + destFile);
            FileUtils.copyFile(scrFile, destF);
            Reporter.log("<a href='..\\screenshots\\'"+ destFile + "'> <img src='..\\screenshots\\"+ destFile +
                    "' height='100' width='100'/>Screenshot</a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSuccess(ITestResult arg0) {

        String destDir = "target/screenshots";
        File scrFile = ((TakesScreenshot) TestRunner.getDriver()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_hh_mm_ssaa");
        new File(destDir).mkdirs();
        String destFile = arg0.getName() + "_" + dateFormat.format(new Date()) + ".png";
        System.out.println("Taking screenshot:" + destFile);

        try {
            File destF = new File(destDir + "/" + destFile);
            FileUtils.copyFile(scrFile, destF);
            Reporter.log("<a href='..\\screenshots\\'"+ destFile + "'> <img src='..\\screenshots\\"+ destFile +
                    "' height='100' width='100'/>Screenshot</a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

    public void onTestStart(ITestResult iTestResult) {

    }
}
