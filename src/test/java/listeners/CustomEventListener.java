package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class CustomEventListener extends AbstractWebDriverEventListener {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CustomEventListener.class);

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        try
        {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("./target/screenshots/" + screenshot.getName()));
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
