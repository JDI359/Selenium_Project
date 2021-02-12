package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter
public class RegisterPage extends BasePage{

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

        @FindBy(xpath="//button[@id='reg-submit-button']")
        private WebElement continueButtonForReg;

        @FindBy(xpath="//input[@id='usernamereg-day']")
        private WebElement dayReg;

        @FindBy(xpath="//input[@id='usernamereg-year']")
        public WebElement yearReg;

        @FindBy(id="reg-submit-button")
        private WebElement contRegButton;

        @FindBy(xpath=("//div[@id='reg-error-yid']"))
        private WebElement isYidErrorPresent;

        @FindBy(xpath=("//div[@id='reg-error-password']"))
        private WebElement isPasswordErrorPresent;

        @FindBy(xpath=("//div[@id='reg-error-phone']"))
        private WebElement isPhoneErrorPresent;

        @FindBy(xpath=("//div[@id='reg-error-birthDate']"))
        private WebElement isBirthDateErrorPresent;

        public void selectBirthMonth(){
                Select birthMonth = new Select(driver.findElement(By.id("usernamereg-month")));
                birthMonth.selectByVisibleText("May");
        }

        public RegisterPage clickRegButton(){
                contRegButton.click();
                return new RegisterPage(driver);
        }


        public RegisterPage(WebDriver driver) {
                super(driver);
        }
}
