package org.example.pages;

import com.microsoft.playwright.Page;

public class CartPage {
    private final Page page;

    // Selectors
    private final String checkoutButton = "//a[@class = 'btn_action checkout_button']";

    // Constructor
    public CartPage(Page page) {
        this.page = page;
    }

    public CheckoutStep1Page clickContinueButton() {
        page.click(checkoutButton);
        return new CheckoutStep1Page(page);
    }
}
