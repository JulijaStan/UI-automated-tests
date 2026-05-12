package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.SearchResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepDefinitions.Hooks.driver;

public class SearchSteps {

    HomePage home = new HomePage(driver);
    SearchResult searchResult = new SearchResult(driver);

    //------------------ Search bar is visible on the home page ------------------//
    @Then("^The search bar should be visible on the home page$")
    public void TheSearchBarIsVisible() throws Throwable{
         assertTrue(home.isSearchInputVisible());
    }

    @And("^The search bar should be enabled$")
    public void theSearchBarShouldBeEnabled() throws Throwable{
        assertTrue(home.isSearchInputEnabled());
    }
//------------------ Perform search operations ------------------//
    @When("^I enter \"([^\"]*)\" in the search bar$")
    public void iEnterInTheSearchBar(String value) throws Throwable{
        Thread.sleep(2000); // wait for results to load
        home.enterSearchValue(value);
    }

    @And("^I click the search button$")
    public void iClickTheSearchButton() throws Throwable{
        Thread.sleep(2000); // wait for results to load
        home.clickSearchButton();
    }

    @Then("^I should see search results$")
    public void iShouldSeeSearchResults() throws Throwable {
        Thread.sleep(2000); // wait for results to load
        assertTrue(searchResult.areSearchResultsVisible());
    }

    @Then("^I should see a message indicating minimum length$")
    public void iShouldSeeAMessageIndicatingNoResultsWereFound() throws Throwable{
        Thread.sleep(2000); // wait for results to load
        String actualMessage = searchResult.getSearchWarningElement().getText().trim();
        String expectedMessage = "Search term minimum length is 3 characters";
        Assert.assertEquals("Warning message is incorrect", expectedMessage, actualMessage);
    }

    @When("^I leave the search bar empty$")
    public void iLeaveTheSearchBarEmpty() throws Throwable{
        Thread.sleep(2000); // wait for results to load
        home.enterSearchValue("");
    }

    @Then("^I should see alert with message$")
    public void iShouldSeeAlertWithMessage() throws Throwable {
        String alertText = driver.switchTo().alert().getText();
        Thread.sleep(2000); // wait for results to load
        assertEquals("Please enter some search keyword", alertText);
    }

    @And("^I click \"([^\"]*)\" button on alert$")
    public void iClickButtonOnAlert(String buttonName) throws Throwable{
        if(buttonName.equals("OK")){
            Thread.sleep(2000); // wait for results to load
            driver.switchTo().alert().accept();
        } else {
            throw new PendingException("Button not defined yet: " + buttonName);
        }
    }

    @And("^I click on \"([^\"]*)\" option$")
    public void iClickOnOption(String name) throws Throwable{
        Thread.sleep(2000); // wait for results to load
        searchResult.clickAdvancedSearch();
    }

    @When("^I select \"([^\"]*)\" category from dropdown$")
    public void iSelectCategoryFromDropdown(String category) throws Throwable{
        Thread.sleep(2000); // wait for results to load
        searchResult.selectCategory(category);
    }
}

