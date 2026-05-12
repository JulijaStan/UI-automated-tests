package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterPage {

    WebDriver driver;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Locator for footer links.
     *
     * normalize-space()  -> removes extra spaces
     * translate()        -> makes text lowercase
     * contains()         -> partial match
     *
     * This XPath:
     * 1. Finds footer block by its title <strong> (example: "Information", "Customer service")
     * 2. Then finds the link by text inside that block
     */

    private By informationLink(String linkText) {
        return By.xpath(
                "//div[@class='column information']//a[" +
                        "contains(translate(normalize-space(text()), " +
                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" +
                        linkText.toLowerCase() + "')]"
        );
    }
    private By customerServiceLink(String linkText) {
        return By.xpath(
                "//div[@class='column customer-service']//a[" +
                        "contains(translate(normalize-space(), " +
                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" +
                        linkText.toLowerCase() +
                        "')]"
        );
    }
    private By myAccountServiceLink(String linkText) {
        return By.xpath(
                "//div[@class='column my-account']//a[" +
                        "contains(translate(normalize-space(), " +
                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" +
                        linkText.toLowerCase() +
                        "')]"
        );
    }

    private By followUsLink(String linkText) {
        return By.xpath(
                "//div[@class='column follow-us']//a[" +
                        "contains(translate(normalize-space(), " +
                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" +
                        linkText.toLowerCase() + "')]"
        );
    }

    private final By poweredBy = By.cssSelector("div.footer-poweredby a");
    private final By copyright = By.cssSelector("div.footer-disclaimer");


    public void clickFooterLink(String linkText) {
        driver.findElement(informationLink(linkText)).click();
    }

    public void clickCustomerLink(String linkText) {
        driver.findElement(customerServiceLink(linkText)).click();
    }

    public void clickMyAccountLink(String linkText) {
        driver.findElement(myAccountServiceLink(linkText)).click();
    }

    public void clickFollowUsLink(String link) {
        driver.findElement(followUsLink(link)).click();
    }

    public boolean isRedirectedTo(String expectedUrlPart) {
        return driver.getCurrentUrl().toLowerCase().contains(expectedUrlPart.toLowerCase());
    }

    public void switchToNewTab() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

    public boolean isCopyrightVisible() {
        return driver.findElement(copyright).isDisplayed();
    }

    public void clickPoweredBy() {
        driver.findElement(poweredBy).click();
    }

    public boolean isPoweredByNavigated() {
        // Expect URL contains "nopcommerce"
        return driver.getCurrentUrl().toLowerCase().contains("nopcommerce");
    }

    public boolean isFooterVisible() {
        return driver.findElement(copyright).isDisplayed();
    }
}


