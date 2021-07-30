package org.pagination;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/pagination/");
		
		List<String> nameList = new ArrayList<String>();
		List<WebElement> pages = driver.findElements(By.xpath("//div[@id='dtBasicExample_paginate']//a"));
		Select select = new Select(driver.findElement(By.name("dtBasicExample_length")));
		select.selectByVisibleText("100");
		if (pages.size()!=0) {
			
			do {
				List<WebElement> allNames = driver.findElements(By.xpath("//td[@class='sorting_1']"));

				for (WebElement names : allNames) {
					nameList.add(names.getText());
				}
				WebElement nextButton = driver.findElement(By.id("dtBasicExample_next"));
				if (nextButton.isEnabled()) {
					nextButton.click();
				}else {
					break;
				}
			} while (true);
						
		}
		for (String names : nameList) {
			System.out.println(names);
			
		}
		driver.quit();
		
	}

}
