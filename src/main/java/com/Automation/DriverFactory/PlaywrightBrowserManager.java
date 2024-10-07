package com.Automation.DriverFactory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import java.awt.*;
import java.io.FileInputStream;
import java.util.Properties;

public class PlaywrightBrowserManager {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties property;
    // Function for getting the page for the execution
    public Page getPlaywrightDriver(Properties property){
        // Getting screen dimensions to set the viewport size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();

        // Getting browser name from property file
        String browserName = property.getProperty("browser");
        playwright = Playwright.create();

        // Launching the browser based on the configuration
        switch (browserName.toUpperCase()){
            case "CHROME":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "FIREFOX":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
        }
        // Creating a new browser context with the specified viewport size
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
        page = browserContext.newPage();
        // Setting a default timeout for page operations
        page.setDefaultTimeout(120000);
        // Navigating to the specified URL and waiting for the DOM to load
        page.navigate(property.getProperty("url").trim());
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return page;
    }

    public Properties initialize_properties(){
        try {
            // Loading properties from the config file
            FileInputStream properties = new FileInputStream("./src/test/resources/config/config.properties");
            property = new Properties();
            property.load(properties);
        }
        catch (Exception ex){
            System.out.println("Properties File not found "+ ex.toString());
        }

        return property;
    }
}
