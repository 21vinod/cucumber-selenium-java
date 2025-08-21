package com.vinod.step_definitions.android;

import com.vinod.utilities.Driver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.When;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.Pause;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

import static com.vinod.utilities.GestureUtils.performSwipe;
import static com.vinod.utilities.GestureUtils.performTap;

public class Real_Device_with_apk {

    AppiumDriver driver = (AppiumDriver) Driver.getDriver();

    UiAutomator2Options cap = new UiAutomator2Options();
    IOSDriver driv = new IOSDriver(cap);
    AppiumDriver andDrive = (AppiumDriver)new AndroidDriver(cap);

    @Given("I will launch android application")
    public void i_will_launch_android_application() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("/n");

    }
    @Then("I will replay recorded action on the application")
    public void i_will_replay_recorded_action_on_the_application() {
        performTap(driver, 261, 1951);
        performTap(driver, 334, 623);
        performTap(driver, 101, 476);
        performTap(driver, 160, 623);

        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));

        performSwipe(driver, 449, 1676, 440, 985);
        performSwipe(driver, 467, 1805, 591, 348);
        performTap(driver, 211, 1915);
        performSwipe(driver, 719, 366, 724, 366);
        performTap(driver, 165, 861);
        performTap(driver, 980, 536);
        performTap(driver, 137, 866);
        performSwipe(driver, 632, 1805, 614, 930);

        driver.quit();
    }
}
