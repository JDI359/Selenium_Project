package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

        @FindBy(xpath="//input[@id='usernamereg-month']")
        private WebElement selectMonthDropdownReg;

        @FindBy(xpath="//option[text()='May']")
        private WebElement selectMonthMayReg;

        @FindBy(xpath="//button[@id='reg-submit-button']")
        private WebElement continueButtonForReg;

        @FindBy(xpath="//input[@id='usernamereg-day']")
        private WebElement dayReg;

        @FindBy(xpath="//input[@id='usernamereg-year']")
        public WebElement yearReg;

        public RegisterPage(WebDriver driver) {
                super(driver);
        }

        public void regInfoPopulation (String firstNameField, String lastNameField, String emailField, String phoneField, String dayField, String yearField){
                firstNameReg.sendKeys(firstNameField);
                lastNameReg.sendKeys(lastNameField);
                emailReg.sendKeys(emailField);
                //ВЕРОЯТНО ЩЕ ТРЯБВА ДА ПРЕОБРАЗУВАМ ДО ИНТ?
                phoneReg.sendKeys(phoneField);
                selectMonthDropdownReg.click();
                selectMonthMayReg.click();
                dayReg.sendKeys(dayField);
                yearReg.sendKeys(yearField);
                continueButtonForReg.click();
            return;
        }
}
