package Base;

import Constants.Constants;
import com.microsoft.playwright.*;
import org.example.pages.*;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.nio.file.Paths;
import java.util.logging.Logger;

public class BaseTest {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected static final Logger logger = Logger.getLogger(BaseTest.class.getName());
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ProductDetailPage productDetailPage;
    protected CartPage cartPage;
    protected CheckoutStep1Page checkoutStep1Page;
    protected CheckoutStep2Page checkoutStep2Page;


    @BeforeTest
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(Constants.HEADLESS).setSlowMo(Constants.SLOWMO));
        context = browser.newContext();
        page = context.newPage();
        page.navigate(Constants.URL);
        loginPage = new LoginPage(page);
        logger.info("Browser launched URL: " + Constants.URL + " ; Headless mode: " + Constants.HEADLESS);
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            String testName = result.getName();
            String screenshotPath = "screenshots/" + testName + ".png";

            try {
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));
                logger.warning("Screenshot captured for failed test: " + testName);
            } catch (Exception e) {
                logger.severe("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
        logger.info("Browser context closed.");
        playwright.close();
        logger.info("Playwright instance closed.");
    }
}
