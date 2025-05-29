package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    private static final String SELENOID_URL = System.getProperty("selenoid_url");
    private static final String SELENOID_LOG = System.getProperty("selenoid_login");
    private static final String SELENOID_PASS = System.getProperty("selenoid_password");

    @BeforeAll
    static void beforeAll(){

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";

        //Configuration.timeout = 10000;
        //Configuration.holdBrowserOpen = true;
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}
