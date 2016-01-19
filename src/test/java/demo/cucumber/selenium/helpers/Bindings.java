package demo.cucumber.selenium.helpers;

import demo.cucumber.selenium.pages.HomePage;
import demo.cucumber.selenium.pages.LoginPage;
import org.openqa.selenium.WebDriver;


/**
 * Created by kugajjar on 1/15/16.
 */
public class Bindings
{
    private WebDriver _driver;
    private HomePage _homePage;
    private LoginPage _loginPage;

    public void setDriver(WebDriver driver)
    {
        _driver = driver;
    }

    public WebDriver getDriver()
    {
        return _driver;
    }

    public void setHomePage(HomePage homePage)
    {
        _homePage = homePage;
    }

    public HomePage getHomePage()
    {
        return _homePage;
    }


    public void setLoginPage(LoginPage loginPage)
    {
        _loginPage = loginPage;
    }

    public LoginPage getLoginPage()
    {
        return _loginPage;
    }
}
