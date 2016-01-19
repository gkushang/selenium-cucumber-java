package demo.cucumber.selenium.helpers;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;


public enum WebDriverFactory
{
    FIREFOX("firefox")
            {
                @Override
                public WebDriver getDriver()
                {
                    final DesiredCapabilities caps = DesiredCapabilities.firefox();
                    return new FirefoxDriver(caps);
                }
            },

    CHROME("chrome")
            {
                @Override
                public WebDriver getDriver()
                {
                    final DesiredCapabilities caps = DesiredCapabilities.chrome();
                    return new ChromeDriver(caps);
                }

            },

    SAFARI("safari")
            {
                @Override
                public WebDriver getDriver()
                {
                    final DesiredCapabilities caps = DesiredCapabilities.safari();
                    return new SafariDriver(caps);
                }
            };


    private static final Map<String, WebDriverFactory> stringMap = new HashMap<String, WebDriverFactory>();
    private String name;

    static
    {
        for (final WebDriverFactory from : values())
        {
            stringMap.put(from.toString(), from);
        }
    }

    private WebDriverFactory(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public static WebDriverFactory getDriverFromMap(String name)
    {
        return stringMap.get(name);
    }

    public abstract WebDriver getDriver();

}
