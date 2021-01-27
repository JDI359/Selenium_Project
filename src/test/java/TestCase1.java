import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
    public void reachRegistrationPage() throws InterruptedException {


        MainPage_NavigationMenu signInStep = new MainPage_NavigationMenu(driver);
        LoginPage loginPage = signInStep.login();

        Reporter.log("Jump to sign in is successful.");

        LoginPage clickRegisterStep = new LoginPage(driver);
        RegisterPage registerPage = clickRegisterStep.login();

        Reporter.log("Jump to register is successful.");

        Thread.sleep(2000);

//        //Hard assert
//        Assert.assertTrue(productListerPage.isProductPriceCorrect("Sauce Labs Backpack", "$29.99"));
//
//        //Soft asserts
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(productListerPage.isProductPriceCorrect("Sauce Labs Backpack", "$29.99"));
//        softAssert.assertTrue(productListerPage.isProductPriceCorrect("Sauce Bike Light", "$222.99"));
//        softAssert.assertFalse(productListerPage.isProductPriceCorrect("Sauce Bike Light", "$29.99"));
//
//        softAssert.assertAll();
    }

    @Test(dataProvider = "reg-data-file")
    public void falseRegistration (String user, String pass){

        RegisterPage registerPage = new RegisterPage(driver);
//        RegisterPage registerPage1 = registerPage.regInfoPopulation();

//        WebElement yearReg

//        WebElement username = driver.findElement(By.id("user-name"));
//        username.sendKeys(user);
//
//        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
//        password.sendKeys(pass);
//
//        WebElement loginButton = driver.findElement(By.className("btn_action"));
//        loginButton.click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", loginButton);
//        js.executeScript("arguments[0].click();", loginButton);
    }
}
