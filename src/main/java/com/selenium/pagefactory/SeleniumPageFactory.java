package com.selenium.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory {
	//create constructor: similar like method, no void, no static
	
	WebDriver driver;
	
	public SeleniumPageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath= "//*[@class='authorization-link']")//1 of 2//x-path identify multiple objects
	private List<WebElement> signinBtn; //Interview question. findElements()//best options instead of grouping
	@FindBy (xpath = "//*[@name='login[username]']")
	private WebElement email;
	@FindBy (xpath = "//*[@name='login[password]']")
	private WebElement password;
	@FindBy (xpath = "//*[@class='action login primary']")
	private WebElement secondSigninBtn;
	@FindBy (xpath = "//*[@class='greet welcome']")//1 of 2
	private List <WebElement>welcome;
	
	public List<WebElement> getWelcome() {
		return welcome;
	}
	public void setWelcome(List<WebElement> welcome) {
		this.welcome = welcome;
	}
	public WebDriver getDriver() {
		return driver;
	}
	//method created
	public List<WebElement> getSigninBtn() {
		return signinBtn;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSecondSigninBtn() {
		return secondSigninBtn;
	}
	
}
