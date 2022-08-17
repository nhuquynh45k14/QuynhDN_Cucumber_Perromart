package Step;

import Page.*;
import Setup.SetupBase;
import Setup.SetupDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class StepTaken extends SetupDriver {


    @Before
    public void openDriver() {
        String url = "https://perromart.com.sg/";
        openDriver("chrome");
        SetupBase.findUrl(url);
    }

    @Given("I close popup")
    public void homePage() {
        PerromartHomePage homePage = new PerromartHomePage();
        homePage.clickclosePoster();
    }

    @When("I enter product name {string} to search box and click icon search")
    public void searchProduct(String productName) {
        CollectionFoodOfDogPage collectionPage = new CollectionFoodOfDogPage();
        collectionPage.searchProduct(productName);
    }

    @When("I click choose product {string}")
    public void clickProduct(String choosedProduct) {
        BuyFood buyFoodPage = new BuyFood();
        buyFoodPage.clickProduct(choosedProduct);
    }

    @When("I click Add to cart button and click icon cart")
    public void addToCart() {
        BuyFood buyFoodPage = new BuyFood();
        buyFoodPage.clickAddToCart();
        buyFoodPage.clickIconViewCart();

    }

    @When("I click Add to cart button,close GiftDeals and click icon cart")
    public void addToCart2() {
        BuyFood buyFoodPage = new BuyFood();
        buyFoodPage.clickAddToCart();
        buyFoodPage.clickbtnCancelGiftDeals();
        buyFoodPage.clickIconViewCart();
    }

    @Then("I verify that product {string} added to the cart is correct")
    public void verifyproduct(String productName) {
        CartPage cartPage = new CartPage();
        String product = cartPage.Productnametext(productName);
        Assert.assertEquals(product, productName);
    }

    //Case 2
    @When("I click check out button")
    public void clickCheckoutButton() {
        CartPage cartPage = new CartPage();
        cartPage.clickBtnCheckOut();
    }

    @When("I enter {string}, {string}, {string}, {string}, {string}, {string}, {string} and click Continue to shipping")
    public void inputInformation(String email, String firstName, String lastName, String address, String apartment, String postalCode, String phone) {
        ShippingAddressPage addressPage = new ShippingAddressPage();
        addressPage.inputAddress(email, firstName, lastName, address, apartment, postalCode, phone);
        addressPage.clickContinue();
    }

    @Then("I verify shipping address {string}, {string} is correct")
    public void verifyShippingAddress(String email, String address) {
        CheckOutShippingAddress checkOutAdd = new CheckOutShippingAddress();
        String contact = checkOutAdd.checkOutEmail();
        Assert.assertEquals(contact, email);
        String ship= checkOutAdd.checkOutAddress();
        Assert.assertEquals(ship, address);
    }

    @After
    public void close() {
        SetupBase.closeDriver();
    }
}
