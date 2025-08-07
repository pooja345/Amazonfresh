package tests;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.FreshPage;
import pages.HomePage;
import pages.ProductPage;

public class AmazonFreshTest extends BaseTest {

    @Test
    public void testSelectOilAndAddToCart() throws InterruptedException {
        HomePage home = new HomePage(driver);
        FreshPage fresh = new FreshPage(driver);
        home.clickFreshMenu();
        Thread.sleep(3000);
        fresh.handlePopupIfAny();
        fresh.clickOilAndGhee();
        Thread.sleep(3000);
        ProductPage product = new ProductPage(driver);
        boolean isProductSelected = product.selectProduct("Organic Tattva");
        Thread.sleep(3000);

        if (isProductSelected) {
            product.clickAddToCart();
            Thread.sleep(3000);
            product.goToCart();
            Thread.sleep(3000);
        } else {
            System.out.println("Test Skipped: Product not available.");
        }
    }
}
