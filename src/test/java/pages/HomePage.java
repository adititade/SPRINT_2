package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //TestCase_Searchbar
    @FindBy(xpath = "//input[@class=\"col-xs-20 searchformInput keyword\"]")
    WebElement SearchBox;

    @FindBy(xpath = "//span[@class=\"nnn\"][1]")
    WebElement SearchResult;

    public WebElement getSearchBox() {
        return SearchBox;
    }

    public WebElement getSearchResult() {
        return SearchResult;
    }

    //Testcase_Pincode
    @FindBy(xpath = "//input[@class=\"sd-input\"]")
    WebElement Pincode_button;
    @FindBy(xpath = "//button[@class=\"pincode-check\"]")
    WebElement Pincode_check;

    public WebElement getPincode_button() {
        return Pincode_button;
    }

    public WebElement getPincode_check() {
        return Pincode_check;
    }

    //TestCASE_InvalidPincode
    @FindBy(xpath = "//input[@class=\"sd-input\"]")
    WebElement SearchInvalidPincode;
    @FindBy(xpath = "//button[@class=\"pincode-check\"]")
    WebElement SearchResultPincode;
    @FindBy(id = "err-pincode")
    WebElement SearchInvalid_button;

    public WebElement getSearchInvalidPincode() {
        return SearchInvalidPincode;
    }

    public WebElement getSearchResultPincode() {
        return SearchResultPincode;
    }

    public WebElement getSearchInvalid_button() {
        return SearchInvalid_button;
    }

    //Invalid Search
    @FindBy(xpath = "//input[@class=\"col-xs-20 searchformInput keyword\"]\")")
    WebElement InvalidSearch;
    @FindBy(xpath = "//span[@class=\"alert-heading\"]\")")
    WebElement InvalidSearchButton;

    public WebElement getInvalidSearch() {
        return InvalidSearch;
    }

    public WebElement getInvalidSearchButton() {
        return InvalidSearchButton;
    }
}
