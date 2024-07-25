package Wrappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;

public class WebWindowHandle {

	public static void switchToNextTab(WebDriver driver) {
		  String windHandleCurrent = driver.getWindowHandle();
		  ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
	        for(int i =0;i<windows.size();i++ ) {
	            String aWindow = windows.get(i);
	            if(aWindow != windHandleCurrent) {
	                driver.switchTo().window(aWindow);
	            }
	        }
	      
	    }
	    
	    public static void closeAndSwitchToNextTab(WebDriver driver) {
	        driver.close();
	        String windHandleCurrent = driver.getWindowHandle();
	        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
	        for(int i =0;i<windows.size();i++ ) {
	            String aWindow = windows.get(i);
	            if(aWindow != windHandleCurrent) {
	                driver.switchTo().window(aWindow);
	            }
	        }
	    }

	    public static void switchToPreviousTab(WebDriver driver) {
	        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
	        driver.switchTo().window(tab.get(0));
	    }

	    public static void closeTabAndReturn(WebDriver driver) {
	        driver.close();
	        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
	        driver.switchTo().window(windows.get(0));
	    }
      
	    public static void switchToPreviousTabAndClose(WebDriver driver) {
	    	ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
	    	driver.switchTo().window(windows.get(1));
	    	 driver.close();
	    }
	    
	    public static void switchToNextWindow(WebDriver driver) {
	    	Set<String> windows = driver.getWindowHandles();
	    	Iterator<String> it = windows.iterator();
	    	String parentID = it.next();
	    	String childID  = it.next();
	    	driver.switchTo().window(childID );
	    	///driver.switchTo().window(parentID);
	    }
	 
	
}
