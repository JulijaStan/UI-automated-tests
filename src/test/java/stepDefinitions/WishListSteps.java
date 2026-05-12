package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WishList;

import static org.junit.Assert.assertTrue;
import static stepDefinitions.Hooks.driver;

public class WishListSteps {

    WishList wishList = new WishList(driver);

    @Then("^The wish list icon should be visible on the home page$")
    public void theWishListIconShouldBeVisibleOnTheHomePage() throws Throwable {
        Thread.sleep(2000);
        assertTrue(wishList.isWishListVisible());
    }

    @When("I click on the wish list icon")
    public void iClickOnTheWishListIcon() throws Throwable{
        Thread.sleep(2000);
        wishList.clickWishListLink();
    }

    @And("^I should be redirected to the Wishlist page$")
    public void redirectionToTheWishList() throws Throwable {
        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains("wishlist"));
    }
}
