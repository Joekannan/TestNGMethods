package testNGMethods;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class TestNGAnnotations {
	@Test
	  public void test1() {
		  System.out.println("Inside test 1 method");
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Inside beforeMethod");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("Inside afterMethod");
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Inside beforeClass");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("Inside afterClass");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("Inside beforeTest");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("Inside afterTest");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("Inside beforeSuite");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("Inside afterSuite");
	  }
}
