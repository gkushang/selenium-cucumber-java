package demo.cucumber.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage
{
    private final WebDriver _driver;

    public HomePage(WebDriver driver)
    {
        _driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li.visible>a.snav-action-logout")
    WebElement loginButton;

    public LoginPage clickLogin()
    {
        loginButton.click();
        return new LoginPage(_driver);
    }
}
