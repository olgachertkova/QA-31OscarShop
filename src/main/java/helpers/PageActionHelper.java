package helpers;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PageActionHelper {
    Logger logger = LoggerFactory.getLogger(PageActionHelper.class);

    public static String takeScreenShot(WebDriver webdriver) throws IOException {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Create new file name
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String curDate = formatter.format(date);
        String filePath = "screenshots/screenshot_" + curDate +".png";

        //Move image file to new destination
        File DestFile=new File(filePath);

        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
        return filePath;

    }

    public static String onException(WebDriver driver) {
     //   logger.error("ERROR!!! TEST FAILED!!!\n", throwable);

        long number = System.currentTimeMillis() / 1000;
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String pathName = "ScreenShots/screen-" + number + ".png";
        File screenshot = new File(pathName);
        try {
            Files.copy(file, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }return pathName;
    }
}
