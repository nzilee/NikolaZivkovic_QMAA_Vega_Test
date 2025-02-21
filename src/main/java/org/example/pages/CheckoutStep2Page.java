package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class CheckoutStep2Page {
    private final Page page;

    // Selectors
    private final String cartItem = "div.cart_item";
    private final String subtotalPrice = "div.summary_subtotal_label";
    private final String taxPrice = "div.summary_tax_label";
    private final String totalPrice = "div.summary_total_label";

    // Constructor
    public CheckoutStep2Page(Page page) {
        this.page = page;
    }

    // Method used to fetch totalPrice for all items displayed in checkout
    public double getAllPrices() {
        List<Locator> cartItems = page.locator(cartItem).all();
        double totalPrice = 0.0;
        for (int i = 0; i < cartItems.size(); i++) {
            String priceText = cartItems.get(i).locator("//div[@class = 'inventory_item_price']").textContent();
            double price = Double.parseDouble(priceText.replace("$", ""));
            totalPrice += price;
        }
        return totalPrice;
    }

    // Methods for fetching checkout price data
    public double getSubtotal() {
        String subtotalText = page.textContent(subtotalPrice);
        return Double.parseDouble(subtotalText.replace("Item total: $", ""));
    }

    public double getTax() {
        String taxText = page.textContent(taxPrice);
        return Double.parseDouble(taxText.replace("Tax: $", ""));
    }

    public double getTotal() {
        String totalText = page.textContent(totalPrice);
        return Double.parseDouble(totalText.replace("Total: $", ""));
    }
}
