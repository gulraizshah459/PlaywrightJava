package com.Mercari.Tests;

import com.Mercari.Base.BaseClass;
import org.testng.annotations.*;

public class SearchTest extends BaseClass {

    @Test
    public void SearchConditionsAreSetCorrectly(){
        searchPageRepo.clickOnSearchField();
        searchPageRepo.clickOnText("カテゴリーからさがす");
        searchPageRepo.clickOnText("本・雑誌・漫画");
        searchPageRepo.clickOnText("本");
        searchPageRepo.clickOnText("コンピュータ・IT");
        searchPageRepo.verifySearchScreenVisible();
        searchPageRepo.verifyCategoriesShouldBePresent("本・雑誌・漫画", "本","コンピュータ・IT");
    }
    @Test
    public void SearchConditionsAreSetCorrectlyFromTheLatestBrowsingHistory(){
        searchPageRepo.clickOnSearchField();
        searchPageRepo.clickOnText("カテゴリーからさがす");
        searchPageRepo.clickOnText("ファッション");
        searchPageRepo.clickOnText("すべて");
        searchPageRepo.verifySearchScreenVisible();
        searchPageRepo.clickOnHomepage();
        searchPageRepo.clickOnSearchField();
        searchPageRepo.clickOnText("カテゴリーからさがす");
        searchPageRepo.clickOnText("本・雑誌・漫画");
        searchPageRepo.clickOnText("本");
        searchPageRepo.clickOnText("コンピュータ・IT");
        searchPageRepo.verifySearchScreenVisible();
        searchPageRepo.verifyCategoriesShouldBePresent("本・雑誌・漫画", "本","コンピュータ・IT");
        searchPageRepo.clickOnHomepage();
        searchPageRepo.clickOnSearchField();
        searchPageRepo.verifySearchHistoryListItems(2);
        searchPageRepo.verifyLatestBrowsingHistoryIsShowing("コンピュータ・IT");
        searchPageRepo.clickOnText("コンピュータ・IT");
        searchPageRepo.verifySearchScreenVisible();
        searchPageRepo.verifyCategoriesShouldBePresent("本・雑誌・漫画", "本","コンピュータ・IT");
        searchPageRepo.searchForText("javascript");
        searchPageRepo.verifySearchScreenVisible();
        searchPageRepo.clickOnHomepage();
        searchPageRepo.clickOnSearchField();
        searchPageRepo.verifyLatestBrowsingHistoryIsShowing("javascript, コンピュータ・IT");

    }


}
