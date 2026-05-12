package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private String pageUrl = "https://demowebshop.tricentis.com/";

    public void open() {
        driver.get(pageUrl);
    }

    //Locators for LogoSteps
    private final By logo = By.cssSelector("img[src*='logo']");
    private final By contactUsButton = By.linkText("Contact us");

    //Locators for SearchSteps
    private final By searchInput = By.id("small-searchterms");
    private final By searchButton = By.cssSelector("input[value='Search']");

//    //Locators for categories and subcategories
    private By menuItem(String name) {
        return By.xpath("//ul[@class='top-menu']//a[normalize-space()='" + name + "']");
    }

    //Actions for LogoSteps
    public boolean isLogoVisible() {
        return driver.findElement(logo).isDisplayed();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public boolean isOnHomePage() {
        return driver.getCurrentUrl().equals(pageUrl);
    }

    public void clickContactUs() {
        driver.findElement(contactUsButton).click();
    }

    public void clickCategory(String categoryName) {
        driver.findElement(menuItem(categoryName)).click();
    }

    public WebElement getCategoryElement(String name) {
        return driver.findElement(menuItem(name));
    }

    public WebElement getSubcategoryElement(String name) {
        return driver.findElement(menuItem(name));
    }

    //Actions for Search Steps
    public boolean isSearchInputVisible() {
        return driver.findElement(searchInput).isDisplayed();
    }

    public boolean isSearchInputEnabled() {
        return driver.findElement(searchInput).isEnabled();
    }

    public void enterSearchValue(String value) {
        WebElement searchElem = driver.findElement(searchInput);
        searchElem.clear();
        searchElem.sendKeys(value);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

}
