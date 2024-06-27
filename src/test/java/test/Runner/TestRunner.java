package test.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
//		"C:\\Users\\SAIDACHARY\\eclipse-workspace\\Test_11_Luma_Ecommerce_Project\\TestSuite\\TC01_Create_An_Account.feature"
//		"C:\\Users\\SAIDACHARY\\eclipse-workspace\\Test_11_Luma_Ecommerce_Project\\TestSuite\\TC02_SignInWithExisitingCustomer.feature"
//		"C:\\Users\\SAIDACHARY\\eclipse-workspace\\Test_11_Luma_Ecommerce_Project\\TestSuite\\TC03_PlaceSingleOrder.feature"
		"C:\\Users\\SAIDACHARY\\eclipse-workspace\\Test_11_Luma_Ecommerce_Project\\TestSuite\\TC04_PlaceMultipleOrders.feature"

}, glue = { "step.Defination" }, dryRun = false, monochrome = true
//				tags = "@SignIn"
)
public class TestRunner {
	

}