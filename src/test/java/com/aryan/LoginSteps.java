package com.aryan;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class LoginSteps {

    private WebDriver driver;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:2306/UserAuthWeb_war/login.jsp");
    }

    @When("I enter {string} as username and {string} as password")
    public void iEnterAsUsernameAndAsPassword(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("I click the Login button")
    public void iClickTheLoginButton() {
        driver.findElement(By.xpath("//*[@type =\"submit\"]")).click();
    }

    @Then("I should be redirected to the welcome page")
    public void iShouldBeRedirectedToTheWelcomePage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/welcome.jsp"));
        driver.quit();
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
