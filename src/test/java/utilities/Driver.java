package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static AndroidDriver appiumDriver;
    private static IOSDriver iosDriver;

    public static AndroidDriver getAndroidDriver() {

        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (appiumDriver == null) {

            UiAutomator2Options options = new UiAutomator2Options();

            options.setDeviceName("Pixel 7")
                    .setPlatformName("Android")
                    .setPlatformVersion("15.0")
                    .setAutomationName("UiAutomator2")
                 // .setApp("C:\\Users\\zeyne\\IdeaProjects\\AppiumNewVersion\\apps\\Teknosa – Alisveris, Teknoloji_7.3.6_APKPure.apk")
                    .setAppPackage("com.tmob.teknosa")
                    .setAppActivity("com.tmob.teknosa.MainActivity")
                    .setNoReset(false);

            if (ConfigReader.getProperty("platformName").equals("Android")) {

                assert appiumServerURL != null;
                appiumDriver = new AndroidDriver(appiumServerURL, options);
                appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            } else {

                assert appiumServerURL != null;
                iosDriver = new IOSDriver(appiumServerURL, options);
                iosDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

                throw new UnsupportedOperationException("Cihaz IOS");
            }

        }

        return appiumDriver;
    }

    public static void quitAppiumDriver() {

        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }

    }

}