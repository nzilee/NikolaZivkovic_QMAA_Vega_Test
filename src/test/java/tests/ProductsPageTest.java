package tests;

import Base.BaseTest;
import Constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTest extends BaseTest {

    // Intentional invalid test for capturing screenshot
    @Test (priority = 100)
    public void invalidSortTest() {
        productsPage = loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);

        Assert.assertTrue(productsPage.isSortedCorrectly());
    }

    @Test (priority = 200)
    public void sortTest() {
        productsPage.performSortingLowToHigh();
        Assert.assertTrue(productsPage.isSortedCorrectly());
    }

    @Test (priority = 300)
    public void addAndRemoveItemsFromCartTest() {
        productsPage.addItemsToCart(Constants.ITEM_1, Constants.ITEM_2);
        Assert.assertEquals(productsPage.cartBadgeNumber(), "2");
        productDetailPage = productsPage.displayItemDetails();
        productDetailPage.removeItemFromCart();
        Assert.assertEquals(productsPage.cartBadgeNumber(), "1");
    }

}
