package tests;

import Base.BaseTest;
import Constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;

public class CheckoutPageTests extends BaseTest {

    //Checking CheckoutStep1 behaviour
    @Test (priority = 100)
    public void checkoutFailureTest() {
        productsPage = loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
        productsPage.addItemsToCart(Constants.ITEM_1, Constants.ITEM_2);
        cartPage = productsPage.navigateToCart();
        checkoutStep1Page = cartPage.clickContinueButton();

        // Continuing with empty fields
        checkoutStep1Page.clickContinueButton();
        Assert.assertTrue(checkoutStep1Page.isErrorVisible());
        Assert.assertTrue(checkoutStep1Page.isErrorContains("First Name"));
        // Continuing with only first name
        checkoutStep1Page.inputFirstName();
        checkoutStep1Page.clickContinueButton();
        Assert.assertTrue(checkoutStep1Page.isErrorVisible());
        Assert.assertTrue(checkoutStep1Page.isErrorContains("Last Name"));
        // Continuing with only first + last name
        checkoutStep1Page.inputLastName();
        checkoutStep1Page.clickContinueButton();
        Assert.assertTrue(checkoutStep1Page.isErrorVisible());
        Assert.assertTrue(checkoutStep1Page.isErrorContains("Postal Code"));
        // Continuing with all the fields filled
        checkoutStep1Page.inputPostalCode();
        checkoutStep2Page = checkoutStep1Page.clickContinueButton();
    }

    // Comparing allItemPrice with subtotal, tax and total
    @Test (priority = 200)
    public void checkAmounts() {
        DecimalFormat df = new DecimalFormat("#.##");

        double allItemPrices = checkoutStep2Page.getAllPrices();
        double subtotalPrice = checkoutStep2Page.getSubtotal();
        double taxPrice = checkoutStep2Page.getTax();
        double totalPrice = checkoutStep2Page.getTotal();

        Assert.assertEquals(allItemPrices, subtotalPrice);
        Assert.assertEquals(Math.round((allItemPrices + taxPrice) * 100.0) / 100.0, totalPrice);
    }
}
