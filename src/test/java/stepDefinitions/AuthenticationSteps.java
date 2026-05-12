package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuthentificationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static stepDefinitions.Hooks.driver;

public class AuthenticationSteps {

    AuthentificationPage auth = new AuthentificationPage(driver);

    //------------------ Authentication links tests ------------------//
    @Then("^I click on the Login link$")
    public void iClickOnLogin() throws Throwable{
        auth.clickLoginLink();
    }

    @Then("^I should be redirected to the Login page$")
    public void iShouldBeRedirectedToTheLoginPage() throws Throwable{
        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @When("I click on the Register link")
    public void iClickOnTheRegistrationLink() throws Throwable{
        auth.clickRegisterLink();
    }

    @Then("^I should be redirected to the Registration page$")
    public void iShouldBeRedirectedToTheRegistrationPage() throws Throwable{
        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains("register"));
    }

}

