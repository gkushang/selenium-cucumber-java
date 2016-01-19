package demo.cucumber.selenium.stepdefs;

import com.google.inject.Inject;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.cucumber.selenium.helpers.Bindings;
import demo.cucumber.selenium.pages.HomePage;
import demo.cucumber.selenium.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class LoginStepDefs
{

    private final Bindings _bindings;
    private WebDriver _driver;

    @Inject //[Bindings] C#
    public LoginStepDefs(Bindings bindings)
    {
        _bindings = bindings;
    }

    @When("^user tries to login with invalid credentials$")
    public void user_tries_to_login_with_invalid_credentials() throws Throwable
    {
        HomePage homePage = _bindings.getHomePage();

        LoginPage loginPage = homePage.clickLogin();

        loginPage.login("invalid@email.com", "invalidPassword");

        _bindings.setLoginPage(loginPage);
    }


    @When("^no page user tries to login with invalid credentials$")
    public void no_page_user_tries_to_login_with_invalid_credentials() throws Throwable
    {
        _driver = _bindings.getDriver();
        //id, class, tagName, name, css, xPath, linkText, partialLinkText
        //find Login Button
        //. -> class
        //# -> id

//        WebElement loginButton = _driver.findElement(By.xpath("html/body/div[2]/div/header/div/div/ul/li[4]/a"));
        WebElement loginButton = _driver.findElement(By.cssSelector("li.visible>a.nav-action-logout"));
//        WebElement loginButton = _driver.findElement(By.linkText("Log-In"));
//        WebElement loginButton = _driver.findElement(By.partialLinkText("In"));

        loginButton.click();

        WebElement username = _driver.findElement(By.id("email"));
//        WebElement username = _driver.findElement(By.cssSelector("#email"));

        username.clear();
        username.sendKeys("invalid@email.com");

        WebElement password = _driver.findElement(By.id("password"));

        password.clear();
        password.sendKeys("invalidPassword");

        WebElement log_in = _driver.findElement(By.cssSelector("#btnLogin"));

        log_in.click();

        //click Login Button

    }

    @Then("^he sees the error message$")
    public void he_sees_the_error_message() throws Throwable
    {
        Thread.sleep(2000);

        LoginPage loginPage = _bindings.getLoginPage();

        assertThat("notification message is incorrect", loginPage.getNotificationMessage(),
                   is("Some of your info isn't correct. Please try again."));
    }
}