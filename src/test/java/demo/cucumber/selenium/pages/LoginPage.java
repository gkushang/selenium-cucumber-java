package demo.cucumber.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage
{
    private final WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "#btnLogin")
    private WebElement loginButton;

    @FindBy(css = ".notification.notification-critical")
    private WebElement notificationMessage;

    public HomePage login(String _username, String _password)
    {
        username.clear();
        username.sendKeys(_username);

        password.clear();
        password.sendKeys(_password);

        loginButton.click();

        return new HomePage(driver);
    }

    public String getNotificationMessage()
    {
        return notificationMessage.getText();
    }

}
