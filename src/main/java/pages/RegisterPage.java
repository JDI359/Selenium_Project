package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

        @FindBy(xpath="//a[@id='header-signin-link']")
        private WebElement signInButton;

        @FindBy(xpath="//a[@id='createacc']")
        private WebElement createAccButton;

        @FindBy(xpath="//input[@id='usernamereg-firstName']")
        private WebElement firstNameReg;

        @FindBy(xpath="//input[@id='usernamereg-lastName']")
        private WebElement lastNameReg;

        @FindBy(xpath="//input[@id='usernamereg-yid']")
        private WebElement emailReg;

        @FindBy(xpath="//input[@id='usernamereg-password']")
        private WebElement passwordReg;

        @FindBy(xpath="//input[@id='usernamereg-phone']")
        private WebElement phoneReg;

        @FindBy(xpath="//input[@id='usernamereg-phone']")
        private WebElement phoneReg;

        @FindBy(xpath="//input[@id='usernamereg-month']")
        private WebElement selectMonthDropdownReg;

        @FindBy(xpath="//option[text()='May']")
        private WebElement selectMonthMayReg;

        @FindBy(xpath="//button[@id='reg-submit-button']")
        private WebElement continueButtonForReg;

        public RegisterPage(WebDriver driver){
            super(driver);
        }

        public ProductListerPage login (String usernameField, String passwordField){
            username.sendKeys(usernameField);
            password.sendKeys(passwordField);
            loginButton.click();
            return new ProductListerPage(driver);
        }
}
