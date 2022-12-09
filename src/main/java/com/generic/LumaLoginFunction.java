package com.generic;//common code

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.Highlighter;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LumaLoginFunction {
	
	public void getLogin(){
		//Selenium code
		//1st- open browser
		
	//WebDriverManager.chromedriver().setup();
	//WebDriver driver = new ChromeDriver();//comman+shif+O-->automatic import
		//remove above driver and get below//mac-->chrome and safari will work
	WebDriver driver = DriverManager.getBrowser("safari");
	driver.manage().window().maximize();
	driver.navigate().to(Constants.URL);
	SeleniumPageFactory pf = new SeleniumPageFactory (driver);////create pagefactory object to call the methods
	SeleniumWait.getImplicitWait(driver, 3);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));//one time we delcare implicitwait
	//slow down the automation as it goes all the code
	//explicit wait = WebDriver Wait
	SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0),3);
	
	//click sign in
	Highlighter.getColor(driver, pf.getSigninBtn().get(0), "red");
	pf.getSigninBtn().get(0).click();//when is list we need to go get() first and then click 0 -->index
		//put user
	Highlighter.getColor(driver, pf.getEmail(),"green");
	pf.getEmail().click();
	pf.getEmail().sendKeys(Constants.user);
		//put pass
	Highlighter.getColor(driver, pf.getPassword(),"blue");
	pf.getPassword().click();
	pf.getPassword().sendKeys(Constants.password);
		//click sing in
	Highlighter.getColor(driver, pf.getSecondSigninBtn(),"purple");
	pf.getSecondSigninBtn().click();
	  //validation
	//If welcome displayed, test pass or fail
	Highlighter.getColor(driver, pf.getWelcome().get(0), "orange");
	boolean status = pf.getWelcome().get(0).isDisplayed();
	SoftAssert sa = new SoftAssert();//SoftAssert is non static so need to create object
	sa.assertTrue(status);
	}

}
