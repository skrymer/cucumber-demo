package com.skrymer.cucumberdemo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by skrymer on 2/12/17.
 */
@RunWith(Cucumber.class)
@CucumberOptions( //features = "/home/nielses/code/github/cucumber-demo/src/test/resources/features",

    plugin = {"pretty", "html:target/cucumber"})
public class RunCukesTest {
}