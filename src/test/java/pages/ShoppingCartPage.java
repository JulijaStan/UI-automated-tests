package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators and methods for ShoppingCartPage
    private final By cartLink = By.className("ico-cart");
    private final By addToCartButton = By.cssSelector(".product-box-add-to-cart-button");
    private final By itemName = By.cssSelector("td.product a");
    private final By price = By.className("product-price");
    private final By checkBox = By.cssSelector("input[name='removefromcart']");
    private final By updateItem = By.cssSelector("input[name='updatecart']");
    private final By emptyCartMessage = By.className("order-summary-content");

    public void clickCartLink() {
        driver.findElement(cartLink).click();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(price).getText();
    }
    public void clickUpdateCart() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
    }
    public void selectRemoveItem() {
        wait.until(ExpectedConditions.elementToBeClickable(updateItem)).click();
    }
    public String getInformationText() {
        return driver.findElement(emptyCartMessage).getText();
    }

}
