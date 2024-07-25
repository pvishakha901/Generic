package Wrappers;

import java.util.List;

import org.openqa.selenium.WebElement;

public class WebRadioButton {
	public static void radioTest(WebElement element, String value) {
		//for(WebElement radiobtns: element) {
			String radio = element.getAttribute("value");
			if(radio.equals(value)) {
				if(!element.isSelected()) {
					element.click();
				}
				else {
					if (element.isSelected()) {
						element.click();
					}
				}
			}
		//}
	}

}
