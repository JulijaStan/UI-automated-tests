package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GiftCardPage;
import pages.ShoppingCartPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static stepDefinitions.Hooks.driver;

public class ShoppingCartSteps {

    ShoppingCartPage cartPage = new ShoppingCartPage(driver);
    GiftCardPage giftCardPage = new GiftCardPage(driver);

//------------------ Shopping cart is visible on the home page ------------------//
    @When("^I click on \"([^\"]*)\" link$")
    public void iClickOnCart(String linkName) throws Throwable{
        Thread.sleep(2000);
        cartPage.clickCartLink();
    }

    @Then("^The shopping cart should be visible on the page$")
    public void theShoppingCartShouldBeVisibleOnThePage() throws Throwable{
        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains("cart"));
    }
//------------------ Add item from the shopping cart ------------------//
    @And("^I click \"([^\"]*)\" for the first item in the search results$")
    public void iClickForTheFirstItemInTheSearchResults(String item) throws Throwable{
        Thread.sleep(2000);
        cartPage.addToCart();
    }

    @Then("^I should see \"([^\"]*)\" in the shopping cart$")
    public void iShouldSeeInTheShoppingCart(String item) throws Throwable {
        Thread.sleep(2000);
        String actualItemName = cartPage.getItemName();
        assertTrue(cartPage.getItemName().toLowerCase().contains(item.toLowerCase()));
    }

    @And("^The total price in the shopping cart should appear correctly$")
    public void theTotalPriceInTheShoppingCartShouldAppearCorrectly() throws Throwable {
        Thread.sleep(2000);
        String totalPrice = cartPage.getTotalPrice();
        assertTrue(totalPrice.length() > 0);
    }
//------------------ Remove item from the shopping cart ------------------//
    @When("^I click on check box to choose \"([^\"]*)\" in the shopping cart$")
    public void iClickOnCheckBoxToChooseInTheShoppingCart(String item) throws Throwable {
        Thread.sleep(2000);
        cartPage.clickUpdateCart();
    }

    @And("^I click on \"([^\"]*)\" button in the shopping cart$")
    public void iClickOnButtonInTheShoppingCart(String buttonName) throws Throwable {
        Thread.sleep(2000);
        cartPage.selectRemoveItem();
    }

    @Then("^I should not see \"([^\"]*)\" in the shopping cart$")
    public void iShouldNotSeeInTheShoppingCart(String item) throws Throwable {
        Thread.sleep(2000);
        String infoText = cartPage.getInformationText();
        assertTrue(infoText.contains("Your Shopping Cart is empty!"));

    }

    //------------------ Add Gift Card with provided information ------------------//
    @Then("^I should be redirected to the card customization page$")
    public void iShouldBeRedirectedToTheCardCustomizationPage() throws Throwable {
        Thread.sleep(2000);
        assertTrue(giftCardPage.isOnGiftCardPage());

    }

    @When("^I enter recipient \"([^\"]*)\"$")
    public void iEnterRecipient(String name) throws Throwable {
        Thread.sleep(2000);
        giftCardPage.enterRecipientName(name);
    }

    @And("^I enter \"([^\"]*)\"$")
    public void iEnter(String name) throws Throwable {
        Thread.sleep(2000);
        giftCardPage.enterSenderName(name);
    }

    @And("^I enter \"([^\"]*)\" for the gift card$")
    public void iEnterForTheGiftCard(String message) throws Throwable {
        Thread.sleep(2000);
        giftCardPage.enterMessage(message);
    }

    @When("^I click on \"([^\"]*)\" button on the customization page$")
    public void iClickOnButtonOnTheCustomizationPage(String button) throws Throwable {
        Thread.sleep(2000);
        giftCardPage.clickAddToCart();
    }

//------------------ Add Gift Card with empty fields to check error messages ------------------//
    @When("^I leave the name field empty$")
    public void iLeaveTheNameFieldEmpty() throws Throwable {
        Thread.sleep(2000);
        giftCardPage.enterRecipientName("");
    }

    @When("^I leave the sender name field empty$")
    public void iLeaveTheSenderNameFieldEmpty() throws Throwable {
        Thread.sleep(2000);
        giftCardPage.enterSenderName("");
    }

    @When("^I leave the message field empty$")
    public void iLeaveTheMessageFieldEmpty() throws Throwable {
        Thread.sleep(2000);
        giftCardPage.enterMessage("");
    }

    @Then("^I should see error message on the customization page$")
    public void iShouldSeeErrorMessageOnTheCustomizationPage() throws Throwable {
        Thread.sleep(2000);
        String error = giftCardPage.getGiftCardErrorMessage();
        System.out.println("CUSTOMIZATION ERROR MESSAGE: " + error);
    }
}
