package demo.cucumber.selenium.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty"}, glue = {"demo.cucumber.selenium.stepdefs"},
                 monochrome = false, strict = true, tags = {"~@blocked", "~@todo"})

public abstract class CucumberUiTest
{
}