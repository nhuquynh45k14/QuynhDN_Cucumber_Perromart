package Page;

import Setup.SetupDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BuyFood {

    private WebDriver driver = SetupDriver.getDriver();
    private WebDriverWait wait;

    public BuyFood() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    private WebElement btnaddToCart;
    @FindBy(xpath = "//a[@href='/cart']/div[contains(@class, 'align-items-center position-relative')]")
    private WebElement iconViewCart;
    @FindBy(xpath = "//span[@class='ps-3 my-auto']")
    private WebElement status;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement btnCancelGiftDeals;

    //Thêm vào giỏ hàng
    public void clickProduct(String nameProduct) {
//        By productName = By.xpath("//div[text()='" + nameProduct + "']");
//        driver.findElement(productName).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + nameProduct + "']")));

        driver.findElement(By.xpath("//div[text()='" + nameProduct + "']")).click();
    }

    public void clickIconViewCart() {
        iconViewCart.click();
    }

    public void clickAddToCart() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add to cart')]")));
        btnaddToCart.click();
    }

    public void clickbtnCancelGiftDeals() {
        btnCancelGiftDeals.click();
    }

}


