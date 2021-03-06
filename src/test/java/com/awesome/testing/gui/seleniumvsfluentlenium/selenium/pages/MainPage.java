package com.awesome.testing.gui.seleniumvsfluentlenium.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage extends PageObject {

    @FindBy(css = "input.gsc-input")
    private WebElement searchBar;

    @FindBy(css = "input.gsc-search-button")
    private WebElement searchButton;

    @FindBy(css = "h1")
    private WebElement post;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void isInitialized() {
        assertThat(post.isDisplayed()).isTrue();
    }

    public SearchResultsPage searchFor(String searchTerm) {
        this.searchBar.clear();
        this.searchBar.sendKeys(searchTerm);
        this.searchButton.click();
        return new SearchResultsPage(driver);
    }

}