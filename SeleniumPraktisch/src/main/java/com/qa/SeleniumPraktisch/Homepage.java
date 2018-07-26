package com.qa.SeleniumPraktisch;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	
	  @FindBy(id = "menu-item-374")
	    private WebElement registration;

	    @FindBy(xpath = "//*[@id=\"menu-item-141\"]/a")
	    private WebElement droppable;

	    @FindBy(xpath = "//*[@id=\"menu-item-142\"]/a")
	    private WebElement selectable;

	    public void navReg() {
	        registration.click();
	    }

	    public void navDrop() {
	        droppable.click();
	    }

	    public void navSelect() {
	        selectable.click();
	    }

}
