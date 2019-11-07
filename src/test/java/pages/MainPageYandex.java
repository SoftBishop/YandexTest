package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageYandex {

    @FindBy(id = "from")
    private WebElement  fromInput;

    @FindBy(id = "to")
    private WebElement toInput;

    @FindBy(id = "when")
    private WebElement whenInput;

    @FindBy(css = "button.Button.SearchForm__submit[type=submit]")
    private WebElement submitRouteButton;

    @FindBy(css= "label:nth-child(5) span")
    private WebElement busButton;

    public MainPageYandex(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setFromInput(String fromDestination)
    {
        fromInput.clear();
        fromInput.sendKeys(fromDestination);
    }


    public void setToInput(String toDestination)
    {
        toInput.clear();
        toInput.sendKeys(toDestination);
    }

    public void setWhenInput(String whenDestination)
    {
        whenInput.clear();
        whenInput.sendKeys(whenDestination);
    }

    public void clickSubmitRouteButton()
    {
        submitRouteButton.click();
    }


    public void clickBusButton()
    {
        busButton.click();
    }
}
