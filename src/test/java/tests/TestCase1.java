package tests;

import base.TestUtils;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage_NavigationMenu;
import pages.RegisterPage;
import utils.CsvReader;

import java.io.IOException;

public class TestCase1 extends TestUtils {

    @DataProvider(name = "reg-data-file")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/login_data.csv");
    }


    @Test
    public void falseRegistration () {

        MainPage_NavigationMenu signInStep = new MainPage_NavigationMenu(driver);
        signInStep.acceptCookies();
        LoginPage loginPage = signInStep.login();
        Reporter.log("Jump to sign in is successful.");

        LoginPage clickRegisterStep = new LoginPage(driver);
        RegisterPage registerPage = clickRegisterStep.login();
        Reporter.log("Jump to register is successful.");
    }


    @Test(dataProvider = "reg-data-file")
    public void falseRegistration (String firstNameField, String lastNameField, String emailField, String passwordField, String phoneField, String dayField, String yearField) {

        RegisterPage reg = new RegisterPage(driver);

        WebElement username = reg.getFirstNameReg();
        username.sendKeys(firstNameField);

        WebElement lastname = reg.getLastNameReg();
        lastname.sendKeys(lastNameField);

        WebElement password = reg.getPasswordReg();
        password.sendKeys(passwordField);

        WebElement email =  reg.getEmailReg();
        email.sendKeys(emailField);

        WebElement phone =  reg.getPhoneReg();
        phone.sendKeys(phoneField);

        Select birthMonth = new Select(driver.findElement(By.id("usernamereg-month")));
        birthMonth.selectByVisibleText("May");

        WebElement days =  reg.getDayReg();
        days.sendKeys(dayField);

        WebElement years =  reg.getYearReg();
        years.sendKeys(yearField);

        WebElement confirmReg = reg.getContRegButton();
        confirmReg.click();


        Assert.assertTrue(reg.getIsYidErrorPresent().isDisplayed());
        Assert.assertTrue(reg.getIsPasswordErrorPresent().isDisplayed());
        Assert.assertTrue(reg.getIsPhoneErrorPresent().isDisplayed());
        Assert.assertTrue(reg.getIsBirthDateErrorPresent().isDisplayed());
    }
}
