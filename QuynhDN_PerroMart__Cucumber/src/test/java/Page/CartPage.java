package Page;

import Setup.SetupDriver;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

    private WebDriver driver = SetupDriver.getDriver();

    public CartPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='CartItems_CartBoxRight__MIMD5']//button[text()='Checkout']")
    private WebElement btnCheckOut;

    public String Productnametext(String nameProduct) {
        By verify = By.xpath("//div[@class='CartItems_Title__x96Gd' and text()='" + nameProduct + "']");
        String value = driver.findElement((By) verify).getText();
        return value;
    }

    public void clickBtnCheckOut() {

        btnCheckOut.click();
    }
}

