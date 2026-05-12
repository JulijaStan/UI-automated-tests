package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GiftCardPage {

    private WebDriver driver;

    public GiftCardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Universal locators for any gift card
    private final By recipientName = By.xpath("//input[contains(@id,'RecipientName')]");
    private final By senderName = By.xpath("//input[contains(@id,'SenderName')]");
    private final By message = By.xpath("//textarea[contains(@id,'Message')]");
    private final By addToCartButton = By.xpath("//input[contains(@id,'add-to-cart-button')]");
    private final By giftCardErrorMessage = By.id("bar-notification");

    // Check that all customization fields are visible
    public boolean isOnGiftCardPage() {
        return driver.findElements(recipientName).size() > 0 &&
                driver.findElements(senderName).size() > 0 &&
                driver.findElements(message).size() > 0;
    }

    public void enterRecipientName(String recipientName) {
        driver.findElement(this.recipientName).clear();
        driver.findElement(this.recipientName).sendKeys(recipientName);
    }

    public void enterSenderName(String senderName) {
        driver.findElement(this.senderName).clear();
        driver.findElement(this.senderName).sendKeys(senderName);
    }

    public void enterMessage(String message) {
        driver.findElement(this.message).clear();
        driver.findElement(this.message).sendKeys(message);
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getGiftCardErrorMessage() {
        return driver.findElement(giftCardErrorMessage).getText();
    }
}
