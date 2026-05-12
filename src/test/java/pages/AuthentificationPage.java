package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthentificationPage {

    private WebDriver driver;

    public AuthentificationPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators for AuthentificationSteps
    private final By loginLink = By.className("ico-login");
    private final By registerLink = By.className("ico-register");

    //Actions for AuthentificationSteps
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

}
