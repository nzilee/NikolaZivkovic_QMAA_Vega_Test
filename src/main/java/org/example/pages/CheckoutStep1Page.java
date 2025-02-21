package org.example.pages;

import com.microsoft.playwright.Page;

public class CheckoutStep1Page {
    private final Page page;

    // Selectors
    private final String firstNameInput = "input#first-name";
    private final String lastNameInput = "input#last-name";
    private final String postalCodeInput = "input#postal-code";
    private final String continueButton = "//input[@class = 'btn_primary cart_button']";
    private final String errorBanner = "h3[data-test='error']";

    // Constructor
    public CheckoutStep1Page(Page page) {
        this.page = page;
    }

    public CheckoutStep2Page clickContinueButton() {
        page.click(continueButton);
        return new CheckoutStep2Page(page);
    }

    public void inputFirstName() {
        page.fill(firstNameInput, "John");
    }

    public void inputLastName() {
        page.fill(lastNameInput, "Doe");
    }

    public void inputPostalCode() {
        page.fill(postalCodeInput, "11010");
    }

    public boolean isErrorVisible() {
        return page.isVisible(errorBanner);
    }

    public boolean isErrorContains(String errorText) {
        return page.textContent(errorBanner).contains(errorText);
    }
}
