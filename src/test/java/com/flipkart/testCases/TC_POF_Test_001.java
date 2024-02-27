package com.flipkart.testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pageObject.PlaceOrderFlow;

public class TC_POF_Test_001 extends BaseClass
{
	@Test
	public void placeOrderFlowTest() throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		PlaceOrderFlow pof=new PlaceOrderFlow(driver);
		String title=driver.getTitle();
		String exp_title="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String pageSource_home=driver.getPageSource();
		
//		if(pageSource_home.contains((CharSequence) login_pop))
//		{
		//	login_pop.click();
//		}
		if(title.equals(exp_title))
		{
			Assert.assertTrue(true);
			pof.enterText(searchItem);
			Thread.sleep(3000);
			
		}else {
			captureScreen(driver, "Home Page Error");
			Assert.assertTrue(false);
		}
		try{
			WebElement login_pop=driver.findElement(By.xpath("/html/body/div[3]/div/span"));
		    if(login_pop.isDisplayed() && login_pop.isEnabled()){
		    	login_pop.click(); // here i want if  element.click(); command 
		    	pof.searchSelection(wait);
		     }
		}catch(Exception e){
			System.out.print(e.getMessage());
			pof.searchSelection(wait);
	    }
		 
		//pof.searchSelection();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String itemHeading="Apple iPad (9th Gen) 64 GB ROM 10.2 inch with Wi-Fi Only (Space Grey)";
		String pageSource=driver.getPageSource();
		
		if(pageSource.contains(itemHeading))
		{
			Assert.assertTrue(true);
			pof.itemSelect();
		}else {
			captureScreen(driver, "Search Results Error");
			Assert.assertTrue(false);
			}
		Set<String> handles=driver.getWindowHandles();
		Iterator it=handles.iterator();
		String parentid=(String) it.next();
		String childid=(String) it.next();
		driver.switchTo().window(childid);
		
		String exp_productpage_title="Apple iPad (9th Gen) 64 GB ROM 10.2 inch with Wi-Fi Only (Space Grey) Price in India - Buy Apple iPad (9th Gen) 64 GB ROM 10.2 inch with Wi-Fi Only (Space Grey) Space Grey 64 Online - Apple : Flipkart.com";		
		String act_productpage_title= driver.getTitle();
		if(exp_productpage_title.equals(act_productpage_title))
		{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			pof.addCart();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else {
			captureScreen(driver, "Product Page Error");
			Assert.assertTrue(false);
		}

		Thread.sleep(5000);
		String exp_shoppingCart_title="Shopping Cart | Flipkart.com";
		String act_shoppingCart_title= driver.getTitle();
		System.out.println("*********************************************************");
		System.out.println(act_shoppingCart_title);
		System.out.println("*********************************************************");
		if(exp_shoppingCart_title.equals(act_shoppingCart_title))
		{
			Assert.assertTrue(true);
			pof.placeOrder();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		}else {
			captureScreen(driver, "Shopping cart page Error");
			Assert.assertTrue(false);
		}
		
		String exp_paymentLogin_title="Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order";
		String act_paymentLogin_title=driver.getTitle();
		
		if(exp_paymentLogin_title.equals(act_paymentLogin_title))
		{
			Assert.assertTrue(true);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			pof.enterEmail(rand_email);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			pof.emailCont();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			pof.enterPhone(rand_phone);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			pof.phoneCont();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //*[@id="container"]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[4]/button
			try
			{
			WebElement OTP_text= driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh _17N0em']"));
			Assert.assertTrue(OTP_text.isDisplayed());
			}catch (Exception e) {
				System.out.println("OTP service unavailable");
			}
			try {
				WebElement SubmitButton= driver.findElement(By.xpath("//button[@type='submit']")); 
				Assert.assertTrue(SubmitButton.isDisplayed());
			} catch (Exception e) {
				WebElement LoginButton=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[4]/button"));
				Assert.assertTrue(LoginButton.isDisplayed());
			}
			
			
		}else {
			captureScreen(driver, "Payment Page Error");
			Assert.assertTrue(false);
		}
	}

}
