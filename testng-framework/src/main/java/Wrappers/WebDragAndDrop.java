package Wrappers;

import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDragAndDrop {
	
	public static void dragAndDrop(WebElement sourceElement, WebElement destinationElement,WebDriver driver) {
	    try {
	        if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
	            Actions action = new Actions(driver);
	            action.dragAndDrop(sourceElement, destinationElement).build().perform();
	        } else {
	            System.out.println("Element was not displayed to drag");
	        }
	    } catch (StaleElementReferenceException e) {
	        System.out.println("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "
	                + e.getStackTrace());
	    } catch (NoSuchElementException e) {
	        System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace());
	    } catch (Exception e) {
	        System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
	    }
	}

}
