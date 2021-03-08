package owner.demo;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import owner.config.IOwnerConfig;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelper.*;

public class BaseTest {

    static final IOwnerConfig config = ConfigFactory.create(IOwnerConfig.class, System.getProperties());
    private static final String ALLURE_SELENIDE_LISTENER_NAME = "AllureSelenide";

    @BeforeAll
    static void setup() {
        addListener(ALLURE_SELENIDE_LISTENER_NAME, new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();

        if (config.remoteUrl() != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = config.remoteUrl();
        }
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser logs", getLogs());
        if (config.videoStorage() != null)
            attachVideo();
        closeWebDriver();
    }
}
