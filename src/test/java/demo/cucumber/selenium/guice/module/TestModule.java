package demo.cucumber.selenium.guice.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import demo.cucumber.selenium.guice.providers.BindingsProvider;
import demo.cucumber.selenium.helpers.Bindings;


public class TestModule extends AbstractModule
{

    @Override
    protected void configure()
    {
        bind(Bindings.class).toProvider(BindingsProvider.class).in(
                Singleton.class);
    }

}