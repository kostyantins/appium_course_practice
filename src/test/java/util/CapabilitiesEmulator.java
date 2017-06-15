package util;

import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class CapabilitiesEmulator {

    public static DesiredCapabilities CHROME_CAPABILITIES(){

        final DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");

        return capabilities;
    }

    public static DesiredCapabilities SAFARI_CAPABILITIES(){

        final DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.SAFARI);
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");

        return capabilities;
    }

    public static DesiredCapabilities TWITTER_CAPABILITIES(){

//        File app = new File("../../app/twitter.apk"); // need if 'apk' didn't install with adb

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(CapabilityType.VERSION, "6.0");
        capabilities.setCapability("autoDismissAlerts", true);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability("appPackage", "com.twitter.android");
//        capabilities.setCapability("app", app.getAbsolutePath()); // need if 'apk' didn't install with adb and when U got 'app' variable
        capabilities.setCapability("appActivity", "com.twitter.app.main.MainActivity");

        return capabilities;
    }
}

