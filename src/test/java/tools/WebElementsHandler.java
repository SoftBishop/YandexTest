package tools;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElementsHandler {

    public int countElementsCompareText(List<WebElement> elements, String text)
    {
        int counterElements =0;
        try {
            for (WebElement element : elements) {
                if (element.getText().equals(text)) {
                    counterElements++;
                }
            }
        }
        catch (StaleElementReferenceException ex)
        {
            for (WebElement element : elements) {
                if (element.getText().equals(text)) {
                    counterElements++;
                }
            }
        }
        return counterElements;
    }

    public int countElementsIsDisplayed(List<WebElement> elements) {
        int counterDisplayed = 0;
        try {
            for (WebElement element : elements)
            {
                if (element.isDisplayed())
                {
                    counterDisplayed++;
                }
            }
        } catch (StaleElementReferenceException ex) {
            for (WebElement element : elements)
            {
                if (element.isDisplayed())
                {
                    counterDisplayed++;
                }
            }
        }
        return counterDisplayed;
    }

    public String getTextFromElement(WebElement webElement)
    {
        return webElement.getText();
    }

    public boolean isElementDisplayed(WebElement webElement)
    {
        return webElement.isDisplayed();
    }
}
