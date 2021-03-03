package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.Enviroment.alfabankURL;


public class AlfabankCreditValuePage {
    SelenideElement
            creditInput = $("[data-test-id='input']"),
            clickOnButton = $("[data-test-id='creditTerm-4']"),
            inputBar = $("input[type='range']"),
            progressBar = $("[data-test-id='calcLayout']").$("progress");


    @Step("Переход на сайт alfabank.ru")
    public void openUrl() {
        open(alfabankURL);
    }

    @Step("Ввод суммы в поле: \"Сумма кредита\" ")
    public void enterCreditValue(String text) {
        creditInput.setValue(text);
        clickOnButton.click();
    }

    @Step("Проверка корректного значения в поле установки суммы кредита (UI)")
    public void verifyValueInputBar(String value) {
        inputBar.shouldBe(value(value));
    }

    @Step("Проверка корректного значения в поле progressBar (UI)")
    public void verifyValueProgressBar(String value) {
        progressBar.shouldHave(value(value));
    }









}