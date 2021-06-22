package scenarious;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPageYandex;
import pages.RoutePageYandex;
import tools.ImageRecognizer;
import tools.WebElementsHandler;

import java.util.concurrent.TimeUnit;

public class KemerovoMoscowScenario {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void openSite()
    {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @Test
    public void myFirstTest() throws InterruptedException {

        driver.navigate().to("https://rasp.yandex.ru/");

        MainPageYandex mainPageYandex = new MainPageYandex(driver);

        mainPageYandex.setFromInput("Кемерово");
        mainPageYandex.setToInput("Москва");
        mainPageYandex.setWhenInput("15.11.2019");
        mainPageYandex.clickSubmitRouteButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        RoutePageYandex routePageYandex = new RoutePageYandex(driver);

        Assert.assertEquals(3,routePageYandex.getRoutes().size());

        WebElementsHandler webElementsHandler = new WebElementsHandler();

        int quantityElementsIsDisplayedIcons
                = webElementsHandler.countElementsIsDisplayed(routePageYandex.getTransportIcon());

        int quatityElementsComaparedRoutes =
                webElementsHandler.countElementsCompareText(
                        routePageYandex.getRouteNames(),"Кемерово — Москва");

        ImageRecognizer imageRecognizer = new ImageRecognizer();

        Assert.assertEquals(3,quatityElementsComaparedRoutes);
        Assert.assertEquals(3,quantityElementsIsDisplayedIcons);
        Assert.assertEquals(3,webElementsHandler.countElementsIsDisplayed(routePageYandex.getRouteDurations()));
        Assert.assertEquals(quantityElementsIsDisplayedIcons,imageRecognizer.collectImages());

    }
    @After
    public void stop()
    {
        driver.quit();
        driver = null;
    }
}
