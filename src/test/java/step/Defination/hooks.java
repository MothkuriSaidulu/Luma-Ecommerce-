package step.Defination;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseClass;

public class hooks extends BaseClass {



	@Before
	public void name() {
		System.out.println("print this before execution");

	}

	@After
	public void afterCucumber() {
		System.out.println("Print This After Execution completed");
		driver.close();
	}

}
