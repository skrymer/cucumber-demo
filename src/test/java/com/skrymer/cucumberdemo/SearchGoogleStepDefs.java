package com.skrymer.cucumberdemo;

import com.skrymer.cucumberdemo.browser.BrowserDriver;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.annotation.Annotation;

/**
 * Created by skrymer on 2/12/17.
 */
public class SearchGoogleStepDefs implements En {

    public SearchGoogleStepDefs(){
        Given("^I navigate to the google home page$", () -> {
            // Write code here that turns the phrase above into concrete actions
            BrowserDriver.loadPage("http://www.google.com");
        });

        When("^searching for 'sonni'$", () -> {
            // Write code here that turns the phrase above into concrete actions
            WebElement element = BrowserDriver.getCurrentDriver().findElement(By.name("q"));
            element.sendKeys("sonni");
            element.submit();
        });

        Then("^I should see 'awesome' on the page$", () -> {
            // Write code here that turns the phrase above into concrete actions
            BrowserDriver.getCurrentDriver().getPageSource().contains("sonni");
        });

        When("^searching for 'google'$", () -> {
            // Write code here that turns the phrase above into concrete actions
            WebElement element = BrowserDriver.getCurrentDriver().findElement(By.name("q"));
            element.sendKeys("google");
            element.submit();
        });

        Then("^I should see 'google' on the page$", () -> {
            // Write code here that turns the phrase above into concrete actions
            BrowserDriver.getCurrentDriver().getPageSource().contains("google");
        });
    }
}
