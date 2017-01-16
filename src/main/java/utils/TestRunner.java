package utils;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestRunner {

	public static void failedTestRunner() {

		
		TestNG runner = new TestNG();
		List<String> list=new ArrayList<String>();
		list.add("C:\\Users\\aurph\\Desktop\\Workspace\\TechnosoftHotels\\test-output\\SmokeTestScenerio\\testng-failed.xml");
		runner.setTestSuites(list);
		runner.run(); 
	}

}
