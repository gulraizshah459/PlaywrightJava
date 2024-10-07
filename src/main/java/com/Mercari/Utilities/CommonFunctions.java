package com.Mercari.Utilities;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class CommonFunctions {
    //Waits for an element to be displayed (attached to the DOM and visible) within a specified timeout.
    public static boolean waitForElementToBeDisplayed(Page page, String locatorString, int timeoutInSeconds) {
        try {
            Locator locator = page.locator(locatorString);
            locator.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(timeoutInSeconds * 1000));
            return true;
        } catch (com.microsoft.playwright.TimeoutError e) {
            System.out.println("Timeout while waiting for element: " + locatorString);
            return false;
        }
    }
    //Waits for an element to be selected (attached to the DOM) within a specified timeout.
    public static boolean waitForElementToBeSelected(Page page, String locatorString, int timeoutInSeconds) {
        try {
            Locator locator = page.locator(locatorString);
            locator.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.ATTACHED)
                    .setTimeout(timeoutInSeconds * 1000));
            return true;
        } catch (com.microsoft.playwright.TimeoutError e) {
            System.out.println("Timeout while waiting for element to be selected: " + locatorString);
            return false;
        }
    }
}
