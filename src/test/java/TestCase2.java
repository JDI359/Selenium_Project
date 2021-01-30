import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.CsvReader;

import java.io.IOException;

public class TestCase2 extends TestUtils {


    @DataProvider(name = "companies-data-file")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/companies_data.csv");
    }


    @Test(dataProvider = "companies-data-file")
    public void falseRegistration (String companyName, String forAndDivValueFromData, String prBookValueFromData){

        initTest();

        MainPage_NavigationMenu openCompanyPage = new MainPage_NavigationMenu(driver);
        MainPage_NavigationMenu popUp = openCompanyPage.acceptCookies();

        WebElement searchField = openCompanyPage.getSearchField();
        searchField.sendKeys(companyName);

        CompanyInfoPage companyInfoPage = openCompanyPage.goToCIP();
        Reporter.log("Jump to company page in is successful.");

        CompanyInfoPage companyInfoPage1 = new CompanyInfoPage(driver);

        WebElement forwardAndDividedValue = companyInfoPage1.getDividendAndYield();
        String forwardAndDividedValueAttribute = forwardAndDividedValue.getText();
        SoftAssert softAssertFirst = new SoftAssert();
        softAssertFirst.assertEquals(forwardAndDividedValueAttribute, forAndDivValueFromData);

        StatisticsPage statisticsPage =  companyInfoPage.search();

        StatisticsPage statisticsPage1 = new StatisticsPage(driver);
        WebElement priceBookValueOnPage = statisticsPage1.getPriceBookValue();
        String priceBookValueOnSomething = priceBookValueOnPage.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(priceBookValueOnSomething, prBookValueFromData);

        tearDownDriver();
    }
}
