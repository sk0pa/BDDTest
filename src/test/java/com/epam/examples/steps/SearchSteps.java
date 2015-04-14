package com.epam.examples.steps;

import static org.junit.Assert.assertTrue;
import com.epam.tests.pages.PageFactory;
import com.epam.tests.pages.SearchPage;
import com.epam.tests.pages.ResultPage;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class SearchSteps {

    private final PageFactory pages;
    private SearchPage searchPage;
    private ResultPage resultPage;

    public SearchSteps(PageFactory pages) {
        this.pages = pages;
    }

    @BeforeScenario
    public void setupPages() {
        searchPage = pages.newSearchPage();
        resultPage = pages.newResultPage();
    }

    @Given("I am on search page")
    public void openSearchPage() {
        searchPage.open();
    }

    @When("Enter the value in Search field $value")
    public void setSearchParameters(String value) {
        searchPage.typeSearchParameters(value);
    }

    @When("click on search button")
    public void clickButtonSearch() {
        searchPage.clickSearchButton();
    }

    @When("click on first link")
    public void clickFirstLink() { searchPage.clickOnFirstResult(); }

    @Then("verify the new page")
    public void verifyPageAsSearchResult() {
        assertTrue(resultPage.verifySearchResultAsPage()); }

    @Then("verify the search results")
    public void verifySearchResultShown() {
        assertTrue(searchPage.verifySearchResults());
    }

    @Then("verify the message")
    public void messageIsShown() {
        assertTrue(searchPage.verifyEmptySearchMessage());
    }
}
