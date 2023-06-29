package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();

    @Given("the {string} is accessed")
    public void theIsAccessed(String urlValue) {
        driver.get(urlValue);
        System.out.println("The " + urlValue + " was succeed by the driver");
    }

    @Then("the following error message are displayed:")
    public void theFollowingErrorMessageAreDisplayed(List<String> errorMessageList) throws InterruptedException {
        for (int i = 0; i < errorMessageList.size(); i++) {
            Thread.sleep(500);
            String elementXpath = ".//*[contains(text(),'" + errorMessageList.get(i) + "')]";
            WebElement errorMassageElement = driver.findElement(By.xpath(elementXpath));
            boolean isErrorMessageNumberIDisplayed = errorMassageElement.isDisplayed();
            Assertions.assertTrue(isErrorMessageNumberIDisplayed, "The error message " + errorMessageList.get(i) + " is displayed");

        }
    }


    @Then("the current url contains the following keyword: {string}")
    public void theCurrentUrlContainsTheFollowingKeyword(String keyword) throws InterruptedException {
        Thread.sleep(500);
        boolean urlContainsCollectedString = driver.getCurrentUrl().contains(keyword);
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(urlContainsCollectedString, "The " + keyword +" is present within the URL");
    }
}
