package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CompanyInfoPage  extends BasePage{

    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    private WebElement dividendAndYield;

    @FindBy(xpath = "//li[@data-test='STATISTICS']")
    private WebElement statisticsButton;

    public CompanyInfoPage(WebDriver driver) {
        super(driver);
    }

    public StatisticsPage search() {
        statisticsButton.click();
        return new StatisticsPage(driver);
    }
}
