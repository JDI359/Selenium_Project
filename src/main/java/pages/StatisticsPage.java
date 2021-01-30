package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class StatisticsPage extends BasePage{

    @FindBy(xpath = "//*[text()='Price/Book']//ancestor::tr[@class='Bxz(bb) H(36px) BdB Bdbc($seperatorColor) fi-row Bgc($hoverBgColor):h']//td[@class='Fw(500) Ta(end) Pstart(10px) Miw(60px)']")
    private WebElement priceBookValue;


    public StatisticsPage(WebDriver driver) {
        super(driver);
    }
}
