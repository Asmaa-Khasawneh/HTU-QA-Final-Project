package ui.data;

import ui.tests.BaseTest;

public class LoginData extends BaseTest {

	public	 String TheWebSite="https://www.saucedemo.com/";
	 
	public String[] UserName = { "standard_user","problem_user", "locked_out_user","error_user", "performance_glitch_user" ,"visual_user"};
	 
	public String Password="secret_sauce";
	
	public String ExpectedForSuccess="Products";
	
	public String ExpectedForLocked="Epic sadface: Sorry, this user has been locked out.";
	
	public String WrongPassword="WrongPass";

	public String ExpectedForNegative="Epic sadface: Username and password do not match any user in this service";
 
	
	
	
	
}
