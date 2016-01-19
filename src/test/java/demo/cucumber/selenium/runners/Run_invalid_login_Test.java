package demo.cucumber.selenium.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(format = {
        "json:target/invalid_login.json",
        "html:target/invalid_login"}, features = {"classpath:features/login.feature"}, tags = {"@invalid_login"})
public class Run_invalid_login_Test extends CucumberUiTest
{
}