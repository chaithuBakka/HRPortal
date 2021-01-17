package com.or.hr.steps;

import com.or.hr.pages.SearchPage;

public class SearchSteps extends BaseSteps {
    SearchPage searchPage;

    public SearchSteps() {
        searchPage = new SearchPage(driver);
    }
}
