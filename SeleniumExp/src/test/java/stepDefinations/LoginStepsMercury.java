package stepDefinations;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testUtils.BaseClass;
import testUtils.DriverManager;

public class LoginStepsMercury extends BaseClass{
	private WebDriver driver;
	@Given("^Initialize the browser with Chrome$")
	public void initialize_the_browser_with_Chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Opening");
	    driver = DriverManager.getDriverInstance("chrome", 20);
	}

	@When("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(arg1);
	}
	@Then("^User Logged in (.+)$")
    public void user_logged_in(String flag) throws Throwable {
        
    }

    @And("^User enters user (.+) and password (.+)$")
    public void user_enters_user_and_password(String username, String password) throws Throwable {
        System.out.println(username);
        System.out.println(password);
    }

    @And("^Close Browser$")
    public void close_browser(DataTable dt) throws Throwable {
        System.out.println(dt.getGherkinRows().get(0).getCells());
        DriverManager.killDriverInstance();
    }
}
