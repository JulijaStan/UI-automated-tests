package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishList {

    WebDriver driver;

    public WishList(WebDriver driver) {
        this.driver = driver;
    }
// Locator for Wish list
    private final By wishListLink = By.className("ico-wishlist");

    public boolean isWishListVisible() {
        return driver.findElement(wishListLink).isDisplayed();
    }

    public void clickWishListLink() {
        driver.findElement(wishListLink).click();
    }
}
