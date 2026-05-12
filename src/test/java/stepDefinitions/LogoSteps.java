package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.AuthentificationPage;
import pages.HomePage;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static stepDefinitions.Hooks.driver;

public class LogoSteps {

    HomePage home = new HomePage(driver);
    AuthentificationPage auth = new AuthentificationPage(driver);

    //------------------ Logo functionality tests ------------------//
    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable{
        home.open();
    }

    @When("^I click on \"([^\"]*)\" button$")
    public void iClickOnContactUsButton(String name) throws Throwable{
        if(name.equals("Contact us")){
            home.clickContactUs();
        } else {
            throw new PendingException("Button not defined yet: " + name);
        }
    }

    @Then("^I should be on Contact us page$")
    public void iShouldBeOnContactUsPage() throws Throwable{
        Thread.sleep(2000); // wait for page to load
        assertEquals("https://demowebshop.tricentis.com/contactus", driver.getCurrentUrl());
    }

    @And("^The logo should be visible on the page$")
    public void theLogoShouldBeVisibleOnThePage() throws Throwable{
        assertTrue(home.isLogoVisible());
    }

    @When("^I click on the logo$")
    public void iClickOnTheLogo() throws Throwable{
        home.clickLogo();
    }

    @Then("^I should be redirected to the home page$")
    public void iShouldBeRedirectedToTheHomePage() throws Throwable{
        Thread.sleep(2000); // wait for page to load
        assertTrue(home.isOnHomePage());
    }

    @When("^I click on \"([^\"]*)\" category$")
    public void iClickOnCategory(String category) throws Throwable{
        Thread.sleep(2000); // wait for page to load
        home.clickCategory(category);
    }

    @Then("^I should be on Computers category page$")
    public void iShouldBeOnComputersCategoryPage() throws Throwable{
        Thread.sleep(2000); // wait for page to load
        assertEquals("https://demowebshop.tricentis.com/computers", driver.getCurrentUrl());
    }

    @When("^I click on \"([^\"]*)\" subcategory under \"([^\"]*)\"$")
    public void iClickOnSubcategoryUnder(String subcategory, String category) throws Throwable{
        // Use Actions to perform hover and click because submenus are displayed on mouse hover, not by clicking the main category directly.
        // 1. Hover on main category
        // 2. Hover + click subcategory
        Actions actions = new Actions(driver);
        Thread.sleep(2000); // wait for page to load
        actions.moveToElement(home.getCategoryElement(category)).perform();
        actions.moveToElement(home.getSubcategoryElement(subcategory)).click().perform();
    }

    @Then("^I should be on \"([^\"]*)\" subcategory page$")
    public void iShouldBeOnDesktopsSubcategoryPage(String subcategory) throws Throwable{
        Thread.sleep(2000); // wait for page to load
        String expectedUrl = "https://demowebshop.tricentis.com/" + subcategory.toLowerCase();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
