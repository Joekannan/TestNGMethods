package testNGMethods;

import org.testng.annotations.DataProvider;

public class DataproviderMethod {
	@DataProvider(name="loginData")
    public static Object[][] getDataFromDataprovider(){
	    Object [] [] loginCredentials =  
	    	{
	            { "Jothi", "Password123" },
	            { "Jeena", "Password123" },
	            { "Caroline", "Password123" }
	        };
	    return loginCredentials;

    }
}
