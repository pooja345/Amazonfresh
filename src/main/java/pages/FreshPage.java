package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FreshPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By oilAndGheeLink = By.xpath("//span[normalize-space()='Oil & ghee']");
    private By seeOilsLink = By.xpath("//a[normalize-space()='See Oils']");
    private By oilElement = By.xpath("//div[normalize-space()='Oil']");

    private By addToCartButton = By.id("add-to-cart-button");
    private By goToCartButton = By.id("attach-sidesheet-view-cart-button");

    public FreshPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait added
    }


    public void clickOilAndGhee() {
        if (wait == null) {
            throw new IllegalStateException("WebDriverWait is not initialized.");
        }
        wait.until(ExpectedConditions.elementToBeClickable(oilAndGheeLink)).click();
    }




    public void addToCart() {
        if (wait == null) {
            throw new IllegalStateException("WebDriverWait is not initialized.");
        }
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(goToCartButton)).click();
    }

    public void handlePopupIfAny() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement element = driver.findElement(By.xpath("//div[@id='GLUXProgramSpecificSheetSkipLink']/a[@class='a-link-normal' and contains(text() ,'Skip')]"));
            js.executeScript("arguments[0].click();", element);
        } catch (NoSuchElementException e) {
            // Popup not found, safe to ignore
        } catch (Exception e) {
            e.printStackTrace(); // Optional: log for debugging
        }
    }
}