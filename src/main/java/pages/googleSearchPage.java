package pages;

import io.appium.java_client.AppiumDriver;
import pageObjectModel.googleSearchPagePOM;

public class googleSearchPage extends googleSearchPagePOM {

    public googleSearchPage(AppiumDriver driver) {
        super(driver);
    } 
    // Perform search for a given keyword
    public googleSearchPage searchFor(String keyword) {
    	keywords.sendKeyOnTextBox(Txt_Search, keyword);
    	keywords.click(Ico_Search);
    	keywords.click(Btn_Search);
    	return this;
    }

    // Open the first search result
    public googleSearchPage openFirstResult() {
    	keywords.click(Lbl_FirstResult);
    	return this;
    }
}
