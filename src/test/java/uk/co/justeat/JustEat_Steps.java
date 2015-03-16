package uk.co.justeat;

import java.util.List;
import junit.framework.Assert;
import cucumber.api.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JustEat_Steps {
	WebDriver driver = new FirefoxDriver();
	@Given("^I want food in \"(.*?)\" JUST EAT Holding Ltd\\. Fleet Place House, (\\d+) Fleet Place, London EC(\\d+)M (\\d+)RF$")
	public void i_want_food_in_JUST_EAT_Holding_Ltd_Fleet_Place_House_Fleet_Place_London_EC_M_RF(String arg1, int arg2, int arg3, int arg4) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://www.just-eat.co.uk/");
	}

	@When("^I search for restaurants$")
	public void i_search_for_restaurants() throws Throwable {
	         
        WebElement query = driver.findElement(By.id("where"));
        query.sendKeys("AR51");
        
        WebElement searchbutton = driver.findElement(By.id("btnSearch"));
        searchbutton.submit();
                   	    
	}

	@Then("^I should see some restaurants in \"(.*?)\"$")
	public void i_should_see_some_restaurants_in(String arg1) throws Throwable {
		WebElement searchResultsHeaderInnerh1 = driver.findElement(By.xpath(".//*[@id='searchResultsHeaderInner']/h1"));
        String sb = searchResultsHeaderInnerh1.getText();
        int noofrestaurants =0;
        noofrestaurants  = Integer.parseInt(sb.substring(0, sb.indexOf("takeaways")).trim());
        System.out.print("Number of restaurants found are : "+ noofrestaurants);
        Assert.assertTrue(noofrestaurants > 0);
        driver.quit();
	}
}
