package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static helpers.Enviroment.yandexmarketURL;


public class YandexMarketPage {
    SelenideElement
            searchMarketItem = $("#header-search"),
            clickButtonSearch = $("button[type='submit']"),
            clickMarketItem = $x("//h3/a"),
            verifyMarketItem = $x("//div[@data-apiary-widget-name='@MarketNode/ProductCardTitle']/descendant::h1");


    @Step("Переход на сайт market.yandex.ru")
    public void openUrl () {
        open(yandexmarketURL);
    }

    @Step("Ввод текста в поле поиска")
    public void typeSearchItem (String text) {
        searchMarketItem.setValue(text);
        clickButtonSearch.click();

    }

    @Step("Переход на страницу товара")
    public void selectItem () {
        clickMarketItem.click();
        switchTo().window(1);
    }

    @Step("Проверка, что на странице товара присутствует искомый текст")
    public void verifyTextItem (String text) {
        verifyMarketItem.shouldHave(text(text));
        }

}
