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
import tools.WebElementsHandler;

import java.util.concurrent.TimeUnit;

public class WrongDirectionScenario {
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

        mainPageYandex.setFromInput("Кемерово проспект Ленина");
        mainPageYandex.setToInput("Кемерово Бакинский переулок");
        mainPageYandex.setWhenInput("среда");
        mainPageYandex.clickBusButton();
        mainPageYandex.clickSubmitRouteButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        RoutePageYandex routePageYandex = new RoutePageYandex(driver);

        WebElementsHandler elementsHandler = new WebElementsHandler();

        Assert.assertEquals
                ("Пункт отправления не найден. Проверьте правильность написания или выберите другой город.",
                elementsHandler.getTextFromElement(routePageYandex.getErrorDirectionMessage()));

        Assert.assertEquals(true,elementsHandler.isElementDisplayed(routePageYandex.getErrorDirectionMessage()));

    }
    @After
    public void stop()
    {
        driver.quit();
        driver = null;
    }

}
