package com.virta.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/virta/features"}, glue = {"com.virta.stepDefinitions"}, plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},tags="@StationAPI",monochrome=true, dryRun=false)

public class TestRunner {
}
