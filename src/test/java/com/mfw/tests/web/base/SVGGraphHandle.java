package com.mfw.tests.web.base;

import static com.mfw.driver.DriverManager.getDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SVGGraphHandle extends WebBase {

	
	/* SVG : Scalable vector graph basically vector images
	 * We can't use traditional xpath to fetch data from svg
	 * So for we have use //*[name()='svg']
	 * 
	 */
	
	@Test
	public void svgGraphHandle() throws InterruptedException {
		getDriver().get("https://emicalculator.net/");
		Thread.sleep(5000);
		String textXpath = "//*[name()='svg']//*[local-name()='g' and @class = 'highcharts-label highcharts-tooltip highcharts-color-undefined']//*[local-name()='text']";
		String verticalXpath = "//*[name()='svg']//*[local-name()='g' and @class = 'highcharts-series-group']//*[local-name()='rect']";
		List<WebElement> verticalBarList =  getDriver()
				.findElements(By.xpath(verticalXpath));
		System.out.println(verticalBarList.size());
		
		
		
		for(WebElement e : verticalBarList) {
			Actions actions = new Actions(getDriver());
			actions.moveToElement(e).perform();
			Thread.sleep(500);
			 String text = getDriver().findElement(By.xpath(textXpath)).getText();
			 System.out.println(text);
			
		}
	}
	
	@Test
	public void SVGPieHandle() throws InterruptedException {
		getDriver().get("https://emicalculator.net/");
		Thread.sleep(5000);
		String barXpath = "//*[name()='svg']//*[local-name()='g' and @class = 'highcharts-series highcharts-series-0 highcharts-pie-series highcharts-tracker']//*[local-name()='path']";
		String textXpath = "//*[name()='svg']//*[local-name()='g' and @style = 'white-space:nowrap;font:14px Lato, Helvetica Neue, Helvetica, Arial, sans-serif;pointer-events:none;']//*[local-name()='text']";
		
		List<WebElement> verticalBarList =  getDriver().findElements(By.xpath(barXpath));
		
		for(WebElement e : verticalBarList) {
			Actions actions = new Actions(getDriver());
			actions.moveToElement(e).click().perform();;
			Thread.sleep(500);
			String text = getDriver().findElement(By.xpath(textXpath)).getText();
			 System.out.println(text);
		}
	}
}