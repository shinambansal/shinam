package cucumberOptions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
	    plugin     =   {
	    		"html:target/cucumber" , 
	    		"json:target/cucumber.json",
	    		"pretty"
	    		},
		features   =   {"src/test/java/features"},
		glue       =   {"stepDefinations"},
		tags       =   {"@LoginMercury"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{
//public class TestRunner {
	@BeforeClass()
	static public void beforeClassMethod() {
		System.out.println("Executing Before Class Method");
	}

	@AfterClass()
	static public void afterClassMethod() {
		System.out.println("Printing After Class Method");
	}

}