package com.epam.tests.pages;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

/**
 * Created by Anhelina_Khalii on 14.04.2015.
 */
public class ResultPage extends WebDriverPage {

    WebDriverWait wait;

    public ResultPage(WebDriverProvider driverProvider) {
        super(driverProvider);
        wait = new WebDriverWait(driverProvider.get(), 30);
        org.openqa.selenium.support.PageFactory.initElements(driverProvider.get(), this);
    }

    public boolean verifySearchResultAsPage() {
        try {
            findElement(By
                    .xpath("//head//title[text()='GISMETEO.COM: Weather forecast']")).isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }

}
