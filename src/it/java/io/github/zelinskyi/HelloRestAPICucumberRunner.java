package io.github.zelinskyi;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty", "json:target/cucumber.json",
				"lv.ctco.cukesrest.formatter.CukesRestJsonFormatter:target/cucumber2.json"},
		features = "classpath:io/github/zelinskyi/",
		glue = "lv.ctco.cukesrest.api",
		strict = true
)
public class HelloRestAPICucumberRunner {

}
