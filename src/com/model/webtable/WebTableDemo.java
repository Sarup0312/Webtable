package com.model.webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemo 
{
	public static void main(String[] args) 
	{
		System.out.println("Web table Demo Edited From Git Hub");
		System.setProperty("webdriver.chrome.driver", "E:\\soft\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("file:///E:/selnium/StudentDetails.html");
		driver.manage().window().maximize();
		
		//NO of Rows
		List<WebElement> ls1= driver.findElements(By.tagName("tr"));
	    int count=ls1.size();
	    System.out.println("The No Of Rows Are:"+count);
	    
	    
	    
	    for(WebElement row:ls1)
	    {
	    	List<WebElement> ls2=row.findElements(By.tagName("td"));
	    	for(WebElement col:ls2)
	    	{
	    		System.out.println(col.getText());
	    	}
	    }
		
		
	}

}
