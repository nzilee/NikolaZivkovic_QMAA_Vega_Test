package org.example.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    // Selectors
    private final String usernameField = "#user-name";
    private final String passwordField = "#password";
    private final String loginButton = "#login-button";
    private final String errorBanner = "h3[data-test='error']";

    // Constructor
    public LoginPage(Page page) {
        this.page = page;
    }

    // Login method
    public ProductsPage performLogin(String username, String password) {
        page.fill(usernameField, username);
        page.fill(passwordField, password);
        page.click(loginButton);

        return new ProductsPage(page);
    }

    public boolean isErrorContains(String errorText) {
        return page.textContent(errorBanner).contains(errorText);
    }
}
