package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\Hari Raju\\eclipse-workspace\\FreeCRMBDD\\src\\main\\java\\Features\\contacts.feature", //Path of the feature file
		glue= {"stepDefinitions"}, // The path of the stepDefinition files
		format =  {"pretty","html:test-output","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"},
		//to generate different types of reporting
		monochrome = true, // display the console output in a proper readable format
		strict = true,//it will check if  any step is not defined in step definition file
		dryRun =false  //to check the mapping is  proper between  feature file and stepdefinition file
		)
public class LoginRunner {


} 	