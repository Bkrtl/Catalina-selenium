package net.romina.step_definitions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.romina.utilities.Driver;
import net.romina.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before
    public void setUp(){
        System.out.println("\tthis is coming from BEFORE");
    }

    @After("@db")
    public void tearDownDatabase(){
        System.out.println("\tCLOSING DATABASE CONNECTION");
    }
    @Before("@db")
    public void setUpDatabase(){
        System.out.println("\tCONNECTION DATABASE");
    }

    @After
    public void tearDown(Scenario scenario){
        //if the scenario fails take the screenshot
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }

        Driver.closeDriver();
    }
}
