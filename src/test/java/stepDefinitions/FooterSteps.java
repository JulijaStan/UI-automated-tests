package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FooterPage;

import static org.junit.Assert.assertTrue;
import static stepDefinitions.Hooks.driver;

public class FooterSteps {

    FooterPage footer = new FooterPage(driver);

    //------------------ Footer visibility ------------------//
    @And("^The footer should be visible on the page$")
    public void theFooterShouldBeVisibleOnThePage() throws Throwable{
        Thread.sleep(1000);
        assertTrue("Footer is not visible!", footer.isFooterVisible());
    }

    //------------------ Navigation by links ------------------//
    @When("^I click on footer link \"([^\"]*)\" under Information$")
    public void iClickOnFooterLinkUnder(String link) throws Throwable{
        footer.clickFooterLink(link);
    }

    @Then("^I should be redirected to \"([^\"]*)\"$")
    public void iShouldBeRedirectedTo(String link) throws Throwable {
        Thread.sleep(1500);
        assertTrue("User was not redirected correctly!",
                footer.isRedirectedTo(link));
    }

    @When("^I click on footer link \"([^\"]*)\" under Customer service$")
    public void iClickOnFooterLinkUnderCustomerService(String link) throws Throwable{
        footer.clickCustomerLink(link);
    }

    @When("^I click on footer link \"([^\"]*)\" under My account$")
    public void iClickOnFooterLinkUnderMyAccount(String link) throws Throwable{
        footer.clickMyAccountLink(link);
    }

    @When("^I click on footer link \"([^\"]*)\" under Follow us$")
    public void iClickOnFooterLinkUnderFollowUs(String link) throws Throwable{
        footer.clickFollowUsLink(link);
        footer.switchToNewTab();
    }

    @Then("^The footer copyright text should be visible$")
    public void theFooterCopyrightTextShouldBeVisible() throws Throwable{
        Thread.sleep(1000);
        assertTrue("Copyright text is missing!", footer.isCopyrightVisible());
    }

    @And("^The Powered by link should navigate correctly$")
    public void thePoweredByLinkShouldNavigateCorrectly() throws Throwable{
        footer.clickPoweredBy();
        assertTrue("Powered by link did not navigate!",
                footer.isPoweredByNavigated());
    }
}