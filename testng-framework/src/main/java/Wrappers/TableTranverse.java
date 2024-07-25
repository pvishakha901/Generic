package Wrappers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class TableTranverse extends TestBase {

	public WebDriver driver;

	public TableTranverse(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static int selectElementFromtable(int i, List<WebElement> tableHeader, String coloumnTitle) {
		for (i = 0; i < tableHeader.size(); i++) {
			if (tableHeader.get(i).getText().equalsIgnoreCase(coloumnTitle)) {			
				break;
			}
		}
		System.out.println(i);
		return i;
	}

}
