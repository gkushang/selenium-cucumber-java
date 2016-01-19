package demo.cucumber.selenium.stepdefs;

import java.util.concurrent.TimeUnit;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import demo.cucumber.selenium.helpers.Bindings;
import demo.cucumber.selenium.helpers.WebDriverFactory;
import demo.cucumber.selenium.pages.HomePage;
import org.openqa.selenium.WebDriver;


@Singleton
public class BeforeAfter
{
    //    private final Logger LOG = Logger.getLogger(BeforeAfter.class);

    private final Bindings _bindings;

    private WebDriver _driver; //IWebDriver C#

    @Inject
    public BeforeAfter(Bindings bindings)
    {
        _bindings = bindings;
    }

    @Before
    public void setUpTestBed() throws Throwable
    {
        _driver = WebDriverFactory.getDriverFromMap("firefox").getDriver();

        //implicit wait
        _driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        _bindings.setDriver(_driver);

        _driver.navigate().to("https://www.paypal.com/deals/offers");

        HomePage homePage = new HomePage(_driver);

        _bindings.setHomePage(homePage);
    }

    @After
    public void tearDown() throws Throwable
    {
//        _driver.quit();
    }
}