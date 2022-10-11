package com.mfw.tests.web.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.iterators.ObjectArrayIterator;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mfw.driver.DriverManager;
import com.mfw.utils.HttpDownloadUtility;

public class DittoData  extends WebBase{
	
	
	public static List<String> links = new ArrayList<>();
	
	
	@Test(priority = 1)
	public void login() throws IOException {
//		int j = 89;
		DriverManager.getDriver().findElement(By.id("id_username")).sendKeys("Lenskart_Manager");
		DriverManager.getDriver().findElement(By.id("id_password")).sendKeys("hubbub.bromidic.immense");
		DriverManager.getDriver().findElement(By.xpath("//button")).click();
		
		for(int i = 89; i <= 95; i++) {
			
			DriverManager.getDriver().get("https://daft.ditto.com/products/" + i + "/");
			
			String link = DriverManager
			.getDriver()
			.findElement(By.xpath("//*[normalize-space(text()) = 'Blend']//following-sibling::dd/a"))
			.getAttribute("href");
			
//			System.out.println(link); 
//			links.add(link);
			
			HttpDownloadUtility.downloadFile(link, "E:/download");
			
		}
		
//		links
//		.parallelStream()
//		.forEach(e -> HttpDownloadUtility.downloadFile(e, "E:/download"));
	}
	
	
//	@Test(priority = 1)
//	public void downloadFiles() {
//		int i = 1;
//		links
//		.parallelStream()
//		.forEach(e -> HttpDownloadUtility.downloadFile(e, "E:/download/" + i + 1));
//		
//	}
	

}
