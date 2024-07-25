package Wrappers;

import org.openqa.selenium.WebElement;

public class Button {
	public static void clickButton(WebElement element) {
		// This method performing click operation on WebButton
		if(WebElementCommon.isClickable(element)) {
	            element.click();    
		}
	}

}
