package com.Mercari.Base;

import com.Mercari.DriverFactory.PlaywrightBrowserManager;
import com.Mercari.Pages.SearchPageRepo;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseClass {
    PlaywrightBrowserManager playwrightBrowserManager;
    public SearchPageRepo searchPageRepo;
    Page page;
    Properties property;

    /**
     * Sets up the test environment before each test method.
     * Initializes the Playwright browser, loads properties, and creates page objects.
     */
    @BeforeMethod
    public void setup(){
        playwrightBrowserManager = new PlaywrightBrowserManager(); // Initialize Browser Manager
        property = playwrightBrowserManager.initialize_properties(); // Load properties from config file
        page = playwrightBrowserManager.getPlaywrightDriver(property); // Initialize Playwright driver
        searchPageRepo = new SearchPageRepo(page); // Initialize Search Page repository
    }

    /**
     * Tears down the test environment after each test method.
     * Closes the Playwright browser.
     */
    @AfterMethod
    public void tearDown(){
        page.context().browser().close(); // Close the browser
    }
}
