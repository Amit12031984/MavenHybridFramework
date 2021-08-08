package com.Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtil {

	public static void SelectByText(WebElement Element, String Text)
	{
		Select sel = new Select(Element);
		sel.selectByVisibleText(Text);
	}
	
}
