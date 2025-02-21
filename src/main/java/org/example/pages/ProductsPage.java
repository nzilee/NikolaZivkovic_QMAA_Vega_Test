package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class ProductsPage {
    private final Page page;
    private final List<Locator> allItems;

    // Selectors
    private final String priceSortSelect = ".product_sort_container";
    private final String items = "//div[@class='inventory_item']";
    private final String itemPrice = "//div[@class='inventory_item_price']";
    private final String itemName = "//div[@class='inventory_item_name']";
    private final String addToCartButton = "button:text('ADD TO CART')";
    private final String cartButton = "//div[@id='shopping_cart_container']/a";

    // Constructor
    public ProductsPage(Page page) {
        this.page = page;
        allItems = page.locator(items).all();
    }

    // Sorting items by price (low to high)
    public void performSortingLowToHigh() {
        page.selectOption(priceSortSelect, "lohi");
    }

    // Comparing firstItem's and lastItem's price
    public boolean isSortedCorrectly() {
        String firstItemPriceText = allItems.getFirst().locator(itemPrice).textContent();
        String lastItemPriceText = allItems.getLast().locator(itemPrice).textContent();
        double firstItemPrice = Double.parseDouble(firstItemPriceText.replace("$", ""));
        double lastItemPrice = Double.parseDouble(lastItemPriceText.replace("$", ""));

        return firstItemPrice < lastItemPrice;
    }

    // Adding specified items to the cart
    public void addItemsToCart(String item1, String item2) {
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).locator(itemName).textContent().contains(item1)) {
                allItems.get(i).locator(addToCartButton).click();
            }

            if (allItems.get(i).locator(itemName).textContent().contains(item2)) {
                allItems.get(i).locator(addToCartButton).click();
            }
        }
    }

    public String cartBadgeNumber() {
        return page.textContent(".shopping_cart_badge");
    }

    public ProductDetailPage displayItemDetails() {
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).locator(itemName).textContent().contains("Sauce Labs Backpack")) {
                allItems.get(i).locator(itemName).click();
                break;
            }
        }
        return new ProductDetailPage(page);
    }

    public CartPage navigateToCart() {
        page.click(cartButton);
        return new CartPage(page);
    }
}
