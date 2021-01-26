import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage_NavigationMenu;
import utils.CsvReader;
import java.io.IOException;

public class TestCase1 extends TestUtils {

    @DataProvider(name = "reg-data-file")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/login-data.csv");
    }


    @Test
    public void executeProductTest(){

        MainPage_NavigationMenu signInStep = new MainPage_NavigationMenu(driver);
        ProductListerPage productListerPage = loginPage.login("standard_user", "secret_sauce");

        LoginPage loginPage = new LoginPage(driver);
        ProductListerPage productListerPage = loginPage.login("standard_user", "secret_sauce");

        Reporter.log("Login is successful.");

        productListerPage.addToCart("Sauce Labs Backpack");

        //Hard assert
        Assert.assertTrue(productListerPage.isProductPriceCorrect("Sauce Labs Backpack", "$29.99"));

        //Soft asserts
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productListerPage.isProductPriceCorrect("Sauce Labs Backpack", "$29.99"));
        softAssert.assertTrue(productListerPage.isProductPriceCorrect("Sauce Bike Light", "$222.99"));
        softAssert.assertFalse(productListerPage.isProductPriceCorrect("Sauce Bike Light", "$29.99"));

        softAssert.assertAll();
    }

//    @Test(dataProvider = "reg-data-file")
//    public void register (String user, String pass){
//
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
//    }
}
