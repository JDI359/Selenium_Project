package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage_NavigationMenu extends BasePage {

    @FindBy(xpath = "//a[@id='header-signin-link']")
    private WebElement signInButton;

    public MainPage_NavigationMenu(WebDriver driver) {
        super(driver);
    }

    public LoginPage login(){
        signInButton.click();
        return new LoginPage(driver);
    }
}
