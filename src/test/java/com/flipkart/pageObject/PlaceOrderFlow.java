package com.flipkart.pageObject;
// 1. Libraries imported to be used in the class
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
	WebDriver ldriver;                                                //Webdriver object to work with the browser actions
	
	public PlaceOrderFlow(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

//WebElement for searching ipad in the search box
	@FindBy(xpath="//input[@placeholder='Search for Products, Brands and More']")
	@CacheLookup
	WebElement SearchTxt;

//WebElement for identifying the item in the dynamic search
	@FindBy(xpath="//li[1]//div[1]//a[1]//div[2]")
	@CacheLookup
	WebElement listSearch;

//WebElement for identifying the item in dynamic search
	@FindBy(xpath="//li[2]//div[1]//a[1]//div[2]")
	@CacheLookup
	WebElement listSearch2;

//WebElement for identifying the element to be clicked on the result page
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]/div[3]/div[1]/div[1]")
	@CacheLookup
	WebElement ItemSelect;

//WebElement for identifying the button to add item to cart
	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	@CacheLookup
	WebElement addToCart;

//WebElement for identifying the button to place order
	@FindBy(xpath="//span[normalize-space()='Place Order']")
	@CacheLookup
	WebElement orderPlace;

//WebElement for identifying the text box to enter random email
	@FindBy(xpath="//input[@type='text']")
	@CacheLookup
	WebElement email;

//WebElement for identifying the button to click after entering email
	@FindBy(xpath="//span[normalize-space()='CONTINUE']")
	@CacheLookup
	WebElement emailContinue;

//WebElement for identifying the text box to enter the random phone number
	@FindBy(xpath="//input[@class='_2IX_2- _17N0em']")
	@CacheLookup
	WebElement phone;

//WebElement for identifying the button to click after entering the phone number
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement phoneSubmit;
	
//Method to enter text in search box on flipkart homepage
	public void enterText(String item)
	{
		SearchTxt.sendKeys(item);
	}

//Method to click the searched item in the dynamic search dropdown
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

//Method to click the item in the result page
	public void itemSelect()
	{
		ItemSelect.click();
	}

//Method to click the add to cart button on product page
	public void addCart()
	{
		addToCart.click();
	}

//Method to click the button to place order on cart page
	public void placeOrder()
	{
		orderPlace.click();
	}

//Method to enter random email 
	public void enterEmail(String Email)
	{
			email.clear();
			email.sendKeys(Email);
	}

//Method to click the continue button after email entered
	public void emailCont()
	{
		emailContinue.click();
	}

//Method to enter random phone number
	public void enterPhone(String Phone)
	{
		phone.clear();
		phone.sendKeys(Phone);
	}

//Method to click the button after entering phone number
	public void phoneCont()
	{
		phoneSubmit.click();
	}
}
