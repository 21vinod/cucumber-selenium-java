package com.vinod.step_definitions.android;

import com.vinod.utilities.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Mobile_Web_Test_StepDefinations {
   // private static AppiumDriver driver;
   WebDriver driver ;

    @Given("I launch {string} on {string}")
    public void iLaunchUrlOnMobile(String url, String platform) {
        driver = Driver.getDriver();
        driver.get(url);
    }

    @Given("I launch the mobile browser")
    public void iLaunchMobileBrowser() {
        // Nothing required here if browser launches on setup
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver.get(url);
    }

    @And("I enter {string} in the search box")
    public void iEnterInTheSearchBox(String text) {
        WebElement searchBox = driver.findElement(By.cssSelector("[aria-label=\"Search\"]"));
        searchBox.sendKeys(text);
    }

    @And("I press the search button")
    public void iPressTheSearchButton() {
        WebElement searchBox = driver.findElement(By.cssSelector("[aria-label=\"Search\"]"));
        searchBox.sendKeys(Keys.ENTER);
    }

    @Then("I should see search results containing {string}")
    public void iShouldSeeSearchResultsContaining(String expected) {
        List<WebElement> results = driver.findElements(By.cssSelector("h3"));
        boolean match = results.stream().anyMatch(e -> e.getText().toLowerCase().contains(expected.toLowerCase()));
        Assert.assertTrue("Search results should contain: " + expected, match);
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @And("I enter {string} in the {string} field")
    public void iEnterInTheField(String value, String fieldName) {
        WebElement input = driver.findElement(By.name(fieldName));
        input.clear();
        input.sendKeys(value);
    }

    @And("I press the submit button")
    public void iPressTheSubmitButton() {
        try {
            WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
            submit.click();
        } catch (NoSuchElementException e) {
            WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
            submit.click();
        }
    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
        // This depends on form implementation
        boolean isConfirmationVisible = driver.getPageSource().toLowerCase().contains("thank you")
                || driver.getPageSource().toLowerCase().contains("submitted");
        Assert.assertTrue("Confirmation message not found!", isConfirmationVisible);
    }

    @And("I scroll down to {string}")
    public void iScrollDownTo(String sectionText) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + sectionText + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Then("I should see the section header {string}")
    public void iShouldSeeTheSectionHeader(String headerText) {
        WebElement header = driver.findElement(By.xpath("//*[contains(text(),'" + headerText + "')]"));
        Assert.assertTrue(header.isDisplayed());
    }

    @And("I press the login button")
    public void iPressTheLoginButton() {
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedMessage) {
        WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertTrue(error.getText().contains(expectedMessage));
    }

//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }

}
