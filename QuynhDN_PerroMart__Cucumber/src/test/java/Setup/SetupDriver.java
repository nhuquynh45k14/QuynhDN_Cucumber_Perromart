package Setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SetupDriver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void openDriver(String type) {
        switch (type) {
            case "edge" -> driver = edgeDriver();
            case "chrome" -> driver = chromeDriver();
            case "firefox" -> driver = fireFoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private static WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    private static WebDriver edgeDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }

    private static WebDriver fireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

}
