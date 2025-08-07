package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // <-- Initialize wait
    }

    private By product(String productName) {
        return By.xpath("//span[@class='a-truncate-cut'][contains(normalize-space(text()),'" + productName + "')]");
    }

    public boolean selectProduct(String productName) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(product(productName)));
            WebElement productElement = wait.until(ExpectedConditions.presenceOfElementLocated(product(productName)));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productElement);
            wait.until(ExpectedConditions.elementToBeClickable(productElement)).click();
            return true; // Product found and clicked
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Product not found: " + productName);
            return false;
        }
    }

    public void clickAddToCart() {
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    public void goToCart() {
        driver.findElement(By.id("nav-cart")).click();
    }
}
