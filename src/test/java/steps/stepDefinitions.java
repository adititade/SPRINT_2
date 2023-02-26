package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

import java.util.HashMap;


public class stepDefinitions {
    private WebDriver driver;
    String url;
    HomePage homePage;
    HashMap<String, String> data;
    Scenario scenario;

    public stepDefinitions(BrowserManager browserManager) {
        this.driver = browserManager.getDriver();
    }
    @Before(order= 1)
    public void before(Scenario scenario){
        this.scenario = scenario;
    }

    //First test_SearchBar
    @Given("the user navigates to home page")
    public void the_user_navigates_to_home_page() {
        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }
    @When("the user enter the product name")
    public void the_user_enter_the_product_name() {
        homePage = new HomePage(driver);
        homePage.getSearchBox().sendKeys(data.get("TypeValue"));
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("the products results should be displayed")
    public void the_products_results_should_be_displayed() {
        String text = homePage.getSearchResult().getText();
        Assert.assertEquals(text, data.get("SearchValue"));
    }


    //2nd TestCase_Pincode
    @Given("user navigates to home page")
    public void userNavigatesToHomePage() {
        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("the user enter the product name and clicks on the enter your pincode button")
    public void the_user_enter_the_product_name_and_clicks_on_the_enter_your_pincode_button() throws InterruptedException
        {
           homePage = new HomePage(driver);
           homePage.getSearchBox().sendKeys("womens kurti");
           homePage.getSearchBox().sendKeys(Keys.ENTER);
           homePage.getPincode_button().sendKeys("444101");
           homePage.getPincode_button().sendKeys(Keys.ENTER);
       }

    @Then("it will show the  search result  for entered pincode")
    public void it_will_show_the_search_result_for_entered_pincode() throws InterruptedException {

        homePage.getPincode_check().click();
    }

//3rd TestCase_InvalidPincode
@Given("the user navigates to the home page")
public void theUserNavigatesToTheHomePage() {
    url = QaProps.getValue("url");
    driver.get(url);
    data = TestDataReader.getData(scenario.getName());
}
@When("the user enter the product name and clicks on the enter your pincode button and trying to enter invalid pincode")
public void the_user_enter_the_product_name_and_clicks_on_the_enter_your_pincode_button_and_trying_to_enter_invalid_pincode() {
    homePage = new HomePage(driver);
    homePage.getSearchBox().sendKeys("womens kurti");
    homePage.getSearchBox().sendKeys(Keys.ENTER);
    homePage.getSearchInvalidPincode().sendKeys("111111");
    homePage.getSearchInvalidPincode().sendKeys(Keys.ENTER);
    homePage.getSearchResultPincode().click();
    }
    @Then("it will show the related search result is available for entered pincode or not")
public void it_Will_Show_The_Related_Search_Result_Is_Available_For_Entered_Pincode_Or_Not() {
        String text = homePage.getSearchInvalid_button().getText();
        Assert.assertEquals(text, "");
}

//Invalid search
    @Given("the User navigate to the home page")
    public void theUserNavigateToTheHomePage() {
        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("the user enter the invalid search and press enter")
    public void theUserEnterTheInvalidSearchAndPressEnter() {
        homePage = new HomePage(driver);
        homePage.getSearchBox().sendKeys(data.get("TypeValue"));
        homePage.getSearchBox().sendKeys(Keys.ENTER);

    }
    @Then("it will show that something wents wrong")
    public void itWillShowThatSomethingWentsWrong() {
        String value = homePage.getSearchResult().getText();
        Assert.assertEquals(value, data.get("SearchValue"));
    }

//Multiple search
    @Given("the user navigate to home page")
    public void theUserNavigateToHomePage() {
        url = QaProps.getValue("url");
        driver.get(url);

    }


    @When("the user enter the {string}")
    public void theUserEnterThe(String product) {
        homePage.getSearchBox().click();
        homePage.getSearchBox().sendKeys(product);

    }

    @Then("the products {string} should be displayed")
    public void theProductsShouldBeDisplayed(String result) {
        String text =  homePage.getSearchResult().getText();
        Assert.assertTrue(text.contains(result));
    }
}




