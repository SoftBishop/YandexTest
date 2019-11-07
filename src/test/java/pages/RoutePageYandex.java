package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RoutePageYandex {

    @FindBy(css = "article.SearchSegment.SearchSegment_isNotInterval." +
            "SearchSegment_isNotGone.SearchSegment_isVisible")
    private List<WebElement> routes;

    @FindBy(css = "h3.SegmentTitle__title")
    private List<WebElement> routeNames;

    @FindBy(css = "div.SearchSegment__duration")
    private List<WebElement> routeDurations;

    @FindBy(css = "svg.TransportIcon__icon")
    private List<WebElement> transportIcon;

    @FindBy(css = "div.ErrorPageSearchForm__title")
    private WebElement errorDirectionMessage;

    public RoutePageYandex(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> getRoutes() {
        return routes;
    }

    public List<WebElement> getRouteNames() {
        return routeNames;
    }

    public List<WebElement> getRouteDurations() {
        return routeDurations;
    }

    public List<WebElement> getTransportIcon() {
        return transportIcon;
    }

    public WebElement getErrorDirectionMessage() {
        return errorDirectionMessage;
    }
}
