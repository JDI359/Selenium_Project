package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath="//a[@id='createacc']")
    private WebElement createAccButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage login(){
        createAccButton.click();
        return new RegisterPage(driver);
    }
}
