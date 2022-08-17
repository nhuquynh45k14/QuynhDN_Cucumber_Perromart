package Setup;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class SetupBase {

    public static void findUrl(String url) {
        SetupDriver.getDriver().get(url);
        SetupDriver.getDriver().manage().window().maximize();
    }


    public static void closeDriver() {
        try {
            Thread.sleep(3000);
            SetupDriver.getDriver().quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

