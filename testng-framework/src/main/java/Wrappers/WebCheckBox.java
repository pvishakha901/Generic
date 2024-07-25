package Wrappers;

import org.openqa.selenium.WebElement;

public class WebCheckBox {
	public static void checkBoxSelect(WebElement checkBox) {
		if (!checkBox.isSelected()) {
			checkBox.click();
		}
	}
	public static void checkBoxDeSelect(WebElement checkBox) {
		if (checkBox.isSelected()) {
			checkBox.click();
		}
	}

}
