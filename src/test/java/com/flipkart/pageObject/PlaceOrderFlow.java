package com.flipkart.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderFlow 
{
	WebDriver ldriver;
	
	public PlaceOrderFlow(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Search for Products, Brands and More']")
	@CacheLookup
	WebElement SearchTxt;
	
	@FindBy(xpath="//li[1]//div[1]//a[1]//div[2]")//li[2]//div[1]//a[1]//div[2], //*[@id="container"]/div/div[1]/div[1]/div[2]/div[2]/form/ul/li[2]/div/a/div[2]
	@CacheLookup
	WebElement listSearch;
	
	@FindBy(xpath="//li[2]//div[1]//a[1]//div[2]")
	@CacheLookup
	WebElement listSearch2;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]/div[3]/div[1]/div[1]")
	@CacheLookup
	WebElement ItemSelect;
	
	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	@CacheLookup
	WebElement addToCart;
	
	@FindBy(xpath="//span[normalize-space()='Place Order']")
	@CacheLookup
	WebElement orderPlace;
	
	@FindBy(xpath="//input[@type='text']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//span[normalize-space()='CONTINUE']")
	@CacheLookup
	WebElement emailContinue;
	
	@FindBy(xpath="//input[@class='_2IX_2- _17N0em']")
	@CacheLookup
	WebElement phone;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement phoneSubmit;
	
	
	public void enterText(String item)
	{
		SearchTxt.sendKeys(item);
	}
	public void searchSelection(WebDriverWait  wait)
	{
		WebElement selectionWait=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]//div[1]//a[1]//div[2]")));
		WebElement selectionWait2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[2]//div[1]//a[1]//div[2]")));
		String list1_test=listSearch.getText();
		String list2_test=listSearch2.getText();
		if(list1_test.contains("ipad 9th generation"))
			{
			selectionWait.click();
			}else if(list2_test.contains("ipad 9th generation"))
			{
				selectionWait2.click();
			}
	}
	public void itemSelect()
	{
		ItemSelect.click();
	}
	public void addCart()
	{
		addToCart.click();
	}
	public void placeOrder()
	{
		orderPlace.click();
	}
	
	public void enterEmail(String Email)
	{
			email.clear();
			email.sendKeys(Email);
	}
	
	public void emailCont()
	{
		emailContinue.click();
	}
	
	public void enterPhone(String Phone)
	{
		phone.clear();
		phone.sendKeys(Phone);
	}
	
	public void phoneCont()
	{
		phoneSubmit.click();
	}
}
