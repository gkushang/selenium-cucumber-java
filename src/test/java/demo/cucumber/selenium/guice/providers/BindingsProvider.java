package demo.cucumber.selenium.guice.providers;

import com.google.inject.Provider;
import demo.cucumber.selenium.helpers.Bindings;


public class BindingsProvider implements Provider<Bindings>
{
    @Override
    public Bindings get()
    {
        return new Bindings();
    }
}
