package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class TakeScreenshots {
    public static void takeScreens() {
        try {
            File scrFile = ((TakesScreenshot) WebDriverSingleton.getInstance()).getScreenshotAs(OutputType.FILE);
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            FileUtils.copyFile(scrFile, new File("screens\\" + dateFormat.format(date) + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

