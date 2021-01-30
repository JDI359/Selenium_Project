package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MainPage_NavigationMenu extends BasePage {

    @FindBy(xpath = "//button[@name='agree']")
    private WebElement termsOfServiceButton;

    @FindBy(xpath = "//a[@id='header-signin-link']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='yfin-usr-qry']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id='header-desktop-search-button']")
    private WebElement searchButton;

    public boolean isAgreeDisplayed() {
         termsOfServiceButton.isDisplayed();
         return true;
    }

    public MainPage_NavigationMenu(WebDriver driver) {
        super(driver);
    }

    public MainPage_NavigationMenu acceptCookies(){
        if(isAgreeDisplayed()){
            termsOfServiceButton.click();
        }
        return null;
    }

    public LoginPage login(){
        signInButton.click();
        return new LoginPage(driver);
    }

    public CompanyInfoPage goToCIP(){
        searchButton.click();
        return new CompanyInfoPage(driver);
    }
}
