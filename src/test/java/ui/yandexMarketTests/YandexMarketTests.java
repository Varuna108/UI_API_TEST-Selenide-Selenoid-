package ui.yandexMarketTests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.YandexMarketPage;
import ui.testbase.TestBase;

import static com.codeborne.selenide.Selenide.sleep;

@Tag("web")
public class YandexMarketTests extends TestBase {

    @Test
    @Description("Positive test. Page Object")
    void successProductSearchWithPO() {
        YandexMarketPage yandexMarketPage = new YandexMarketPage();

        yandexMarketPage.openUrl();

        yandexMarketPage.typeSearchItem("iPhone 8");

        yandexMarketPage.selectItem();

        yandexMarketPage.verifyTextItem("Смартфон Apple iPhone 8 64GB");

        sleep(3);

    }
}
