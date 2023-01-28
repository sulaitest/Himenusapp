package com.Himenusapp.PageObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {
	String emailid = "Restaurant@himenus.com";
	String pass = "Abc@123";
	String em ="";
	String pwd = "";
	String passtext,emtext;
	boolean loginstatus;
	public LoginPage(AndroidDriver driver)
	{
		super(driver);
	}
@AndroidFindBy(xpath="//*[@text='Enter your email']")
public AndroidElement email_txt;
@AndroidFindBy(xpath="//*[@text='Enter your password']")
public AndroidElement pass_txt;
@AndroidFindBy(xpath="//*[@text='Sign in']")
public AndroidElement btn_login;

//Validate Without Credentials.
public boolean withoutcredentials()
{
email_txt.sendKeys(em);
pass_txt.sendKeys(pwd);
btn_login.click();
String emtext = email_txt.getAttribute("value");
String passtext = pass_txt.getAttribute("value");
btn_login.click();
boolean loginstatus;
//storedmsg = "please enter your credentials";
//Check whether the current screen is Home Screen or not.
String curracty = driver.currentActivity();
System.out.println("Current Activity is" + curracty);

if(emtext.isEmpty()&& passtext.isEmpty())
{
	loginstatus = false;
	System.out.println("Login Failed");
	
}
else
{
	loginstatus = true;
	System.out.println("Login Passed");
}
return loginstatus;
}

//Check if the email field is displayed or not.

public boolean emaildisplay()
{
	if(email_txt.isDisplayed())
	{
		loginstatus=true;
	}
	else
	{
		loginstatus = false;
	}
	return loginstatus;
}

//Check if the Password field is displayed or not.
public boolean passdisplay()
{
	if(pass_txt.isDisplayed())
	{
		loginstatus =true;
		System.out.println("Email Field is displayed");
	}
	else
	{
		loginstatus = false;
		System.out.println("Email Field is not displayed");
	}
	return loginstatus;
}

//Check if the email field is enabled or not.
public boolean emailenable()
{
	if(email_txt.isEnabled())
	{
	loginstatus = true;	
	System.out.println("Email Field is enabled");
	}
	else
	{
		loginstatus = false;
		System.out.println("Email Field is not displayed");
	}
	return loginstatus;
	
	}

//Enter the email id and keep the password field as empty.
public boolean passemptycheck()
{
	email_txt.sendKeys(emailid);
	pass_txt.sendKeys(pwd);
	btn_login.click();
	if(passtext.isEmpty())
	{
		loginstatus = true;
		System.out.println("Password Field is Empty");
	}
	else
	{
		loginstatus = false;
		System.out.println("Password is not Empty");
	}
	return loginstatus;
}
//Keep the Email field as Empty and password entered.
public boolean emailemptycheck()
{
	email_txt.sendKeys(em);
	pass_txt.sendKeys(pass);
	btn_login.click();
	if(emtext.isEmpty())
	{
		loginstatus = true;
		System.out.println("Email field is empty");
	}
	else
	{
		loginstatus = false;
		System.out.println("Email Field is not Empty");
	}
	return loginstatus;
}
//Enter Space before the emailid value.
public boolean spacebeforeemail()
{
	String sp = "";
	email_txt.sendKeys(sp + emailid);
	String spemail = email_txt.getAttribute("value");
	pass_txt.sendKeys(pass);
	btn_login.click();
	if(emtext.contentEquals(spemail))
	{
		loginstatus = true;
		System.out.println("Space before Email is not accepted");
	}
	else
	{
		loginstatus = false;
		System.out.println("Space before Email is not accepted");
	}
	return loginstatus;
}
//Enter the Invalid Credentials.
public boolean Invalidcredentials()
{
	String ema = "Hotels@himenus.com";
	String pa = "Hotels@546";
	email_txt.sendKeys(ema);
	String etxt = email_txt.getAttribute("value");
	pass_txt.sendKeys("pa");
	String patxt = pass_txt.getAttribute("value");
	btn_login.click();
	String cactiviity = driver.currentActivity();
	String cactivity = null;
	System.out.println("Current Activity :" + cactivity);
	if(cactivity=="Home")
	{
		loginstatus = true;
		System.out.println("Login Passed");
	}
	else
	{
		loginstatus = false;
		System.out.println("Login Failed");
	}
	return loginstatus;
	}
// Enter the Valid Credentials.
public boolean Validcredentials()
{
	String vemail = "Restaurant@himenus.com";
	String vpass = "Abc@123";
	boolean logstatus;
	email_txt.sendKeys(vemail);
	String vem =email_txt.getAttribute("value");
	pass_txt.sendKeys(vpass);
	String vep =pass_txt.getAttribute("value");
	btn_login.click();
	String cacty = driver.currentActivity();
	System.out.println("Current Activity is" + cacty);
	if(vem.equals(vemail) && (vep.equals(vpass)))
	{
		logstatus = true;
		System.out.println("Valid Credentials");
		
	}
	else
	{
		logstatus = false;
		System.out.println("Invalid Credentials");
	}
	return logstatus;
}
//Validate the Email Format
//Under progress.
//Validate the Password Format.
public  boolean passformatcheck(String password)
{
	pass_txt.clear();
	String[] passarr = {"Ahamed@salih20","1234"};
	for (int i = 0; i < passarr.length; i++) {
		String passw = passarr[i];
		pass_txt.sendKeys(passw+"\n");
	}
	btn_login.click();
	//Regex to Check the Valid Password.
	String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" +"(?=.*[@#$%^&+=])"+"(?=\\S+$).{8,20}$";
	
	//Compile the Regex.
	Pattern p = Pattern.compile(regex);
	if(password==null)
	{
		return false;
			}
	Matcher m = p.matcher(password);
	return m.matches();
}
//Check password text is masked or not.
public boolean passmaskcheck()
{
	boolean passmaskstatus;
WebElement password = driver.findElement(By.id("pwd"));
if(password.getAttribute("type")=="password")
{
	passmaskstatus = true;
	System.out.println("Password is masked");
		}
else
{
	passmaskstatus = false;
	System.out.println("Password is not masked");
}
return passmaskstatus;
}

//Check the length of the Password.
public boolean passlengthcheck()
{
	boolean passlenstatus;
	String lpass = "Abc@123";
	pass_txt.sendKeys(lpass);
	String getpass = pass_txt.getAttribute("value");
	int passlen = getpass.length();
	if(passlen>=8 && passlen<=20)
	{
		passlenstatus = true;
		System.out.println("Password length is Valid");
	}
	else
	{
		passlenstatus = false;
		System.out.println("Password length is not Valid");
	}
	return passlenstatus;
}

}



