package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static org.openqa.selenium.By.xpath;

public class ReusableMethods {

    public static void koordinatTiklamaMethodu(int xKoordinati, int yKoordinati, int beklemeSuresi) {

        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());

        action.press(PointOption.point(xKoordinati, yKoordinati))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(beklemeSuresi)))
                .release()
                .perform();
    }

    public static void scrollWithUiScrollableAndClick(String elementText) {

        AndroidDriver driver = (AndroidDriver) Driver.getAndroidDriver();

        driver.findElement(androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));
        driver.findElement(xpath("//*[@text='" + elementText + "']")).click();
    }

    public static void scrollWithUiScrollable(String elementText){

        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElement(androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));
    }

    public static String getScreenshot(String name) throws IOException {

        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getAndroidDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);

        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";

        File finalDestination = new File(target);

        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);

        return target;
    }

    public static void ekranKaydirmaMethodu(int xBaslangic, int yBaslangic, int beklemeSuresi, int xBitis, int yBitis) {

        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());

        action.press(PointOption.point(xBaslangic, yBaslangic))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(beklemeSuresi)))
                .moveTo(PointOption.point(xBitis, yBitis))
                .release()
                .perform();
    }

}
