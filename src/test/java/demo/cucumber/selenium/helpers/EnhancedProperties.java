package demo.cucumber.selenium.helpers;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;


public class EnhancedProperties
{
    public Properties get()
    {
        Properties properties = new Properties();
        try
        {
            properties.load(new ClassPathResource(
                    "environments/qa.properties").getInputStream());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return properties;
    }
}

