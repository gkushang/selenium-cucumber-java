package demo.cucumber.selenium.guice.providers;

import com.google.inject.Provider;
import demo.cucumber.selenium.helpers.EnhancedProperties;
import demo.cucumber.selenium.helpers.WebDriverFactory;
import org.openqa.selenium.WebDriver;


public class WebDriverProvider implements Provider<WebDriver>
{
    @Override
    public WebDriver get()
    {
        String browser = new EnhancedProperties().get().getProperty("browser");

        return WebDriverFactory
                .getDriverFromMap(browser)
                .getDriver();
    }
}
