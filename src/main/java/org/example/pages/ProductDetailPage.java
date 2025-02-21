package org.example.pages;

import com.microsoft.playwright.Page;

public class ProductDetailPage {
    private final Page page;

    // Selectors
    private final String removeFromCartButton = "button:text('REMOVE')";

    // Constructor
    public ProductDetailPage(Page page) {
        this.page = page;
    }

    public void removeItemFromCart() {
        page.click(removeFromCartButton);
    }
}
