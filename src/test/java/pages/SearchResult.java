package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchResult {

    private WebDriver driver;

    public SearchResult(WebDriver driver) {
        this.driver = driver;
    }
    //Locators for SearchSteps
    private final By searchWarning = By.className("warning");
    private final By advancedSearchCheckbox = By.id("As");
    private final By categorySearch = By.id("Cid");

    //Actions for SearchSteps
    public boolean areSearchResultsVisible() {
        By resultsLocator = By.cssSelector(".search-results .item-box");
        return driver.findElements(resultsLocator).size() > 0;
    }

    public WebElement getSearchWarningElement() {
        return driver.findElement(searchWarning);
    }

    public void clickAdvancedSearch() {
        driver.findElement(advancedSearchCheckbox).click();
    }

    public void selectCategory(String category) {
        Select dropdown = new Select(driver.findElement(categorySearch));
        dropdown.selectByVisibleText(category);
    }
}
