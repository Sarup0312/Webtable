package com.model.webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Web_Table 
{
    public static void main(String[] args) 
	{
	  System.setProperty("webdriver.chrome.driver", "E:\\soft\\chromedriver.exe");
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");
	  driver.manage().window().maximize();
	  
	  //locate 1st web table
	  WebElement table=driver.findElement(By.xpath("//div[@id='innings_1']/child::div[1]"));
	  
	  
	  //locate 1row of the table from which the score card id started
	  List<WebElement> rows=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));// we get 26 rows for this locator
	  int count1=rows.size();
	  System.out.println("The no of rows in the 1st table is   "+count1);
	  
	  
	  //to locate 1st run column(51)
	  List<WebElement> ls=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"));
	  int count2=ls.size();
	  System.out.println("The no of columns is   "+count2);
	  
	  int sum=0;
	  for(int i=0;i<count2-2;i++)//bcz except extras and total so count-2
	  {
		  String val=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
		 int value=Integer.parseInt(val);
		  sum=sum+value;
      }
	  System.out.println("Sum of Runs is "+sum);
	  
	  String extraval= table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
	  int extras=Integer.parseInt(extraval);
	  System.out.println("Extras Run are :"+extras);
	  
	  int acttotalruns=sum+extras;
      System.out.println("Actual total runs are:"+acttotalruns);
      
      
     String totalval= table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
     int total=Integer.parseInt(totalval);
     System.out.println("The Total no of runs are:"+total);
     
     
     if(acttotalruns==total)
     {
    	 System.out.println("Scorecard is matched");
     }
     else
     {
    	 System.out.println("Scorecard is  not matched");
     }

	  
	
	}

}
