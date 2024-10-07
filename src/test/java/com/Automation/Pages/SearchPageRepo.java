package com.Automation.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

import static com.Automation.Utilities.CommonFunctions.*;

public class SearchPageRepo {
    Page page;
    // Locators for various elements on the search page
    String searchField = "//input[@aria-label = '検索キーワードを入力']";
    String categoryTierSelect = "li[data-testid='category_id'] select.merInputNode";
    String searchListItemsText = "//section[@data-testid='search-history']//div[@role='listitem']//p";
    String homePageLogo = "//*[@data-testid='mercari-logo']";
    String searchResultText = "//*[contains(text(),'の検索結果')]";


    //Constructor to initialize the Page object.
    public SearchPageRepo(Page page){
        this.page = page;
    }
    //Clicks on the search field.
    public void clickOnSearchField(){
        page.click(searchField);
    }
    //Clicks on an element with the specified text.
    public void clickOnText(String text){
        String categoryTier = "//*[text()='"+text+"']";
        Assert.assertTrue(waitForElementToBeDisplayed(page,categoryTier,10));
        page.click(categoryTier);
    }
    //Verifies that the selected categories and checkbox are present and correct.
    public void verifyCategoriesShouldBePresent(String text1, String text2, String text3){
        // Get the list of select elements
        Locator selectElements = page.locator(categoryTierSelect);

        // Get the selected text of the first select element
        String selectedText1 = selectElements.first().locator("option:checked").textContent();
        Assert.assertEquals(text1, selectedText1);

        // Get the selected text of the second select element
        String selectedText2 = selectElements.nth(1).locator("option:checked").textContent();
        Assert.assertEquals(text2, selectedText2);

        // Locate the checkbox element
        String checkboxLocator = "//span[text()='" + text3 + "']/ancestor::label/input";
        // Assert that the checkbox is selected
        Assert.assertTrue(waitForElementToBeSelected(page,checkboxLocator,10));

    }
    //Verifies the number of search history list items.
    public void verifySearchHistoryListItems(int countOfItems){
        // Wait for list item to be present
        page.waitForSelector(searchListItemsText);

        // Get all matching elements
        Locator listElements = page.locator(searchListItemsText);
        int tempListCount = listElements.count();

        Assert.assertEquals(countOfItems, tempListCount);
    }
    //Verifies that the latest browsing history is showing the expected text.
    public void verifyLatestBrowsingHistoryIsShowing(String textToCheck){
        // Wait for list item to be present
        page.waitForSelector(searchListItemsText);

        // Get the first list item's text content
        Locator listElements = page.locator(searchListItemsText);
        String tempHistoryText = listElements.first().textContent();
        Assert.assertEquals(textToCheck,tempHistoryText);
    }
    //Verifies that the search result screen is visible.
    public void verifySearchScreenVisible(){
        Assert.assertTrue(waitForElementToBeDisplayed(page,searchResultText,10));
    }
    //Clicks on the homepage logo to navigate to the homepage.
    public void clickOnHomepage(){
        page.locator(homePageLogo).click();
    }
    //Searches for the given text.
    public void searchForText(String textToSearch){
        page.locator(searchField).fill(textToSearch);
        page.locator(searchField).press("Enter");
    }
}
