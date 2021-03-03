package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.Enviroment.alfabankURL;


public class AlfabankCreditTextPage {
    SelenideElement
            creditInput = $("[data-test-id='input']"),
            clickOnButton = $("[data-test-id='creditTerm-4']"),
            valueOfCredit = $("[data-test-id='input']").sibling(0),
            textSumOfCredit = $("[data-test-id='input']").preceding(0),
            inputBar = $("input[type='range']"),
            progresBar = $("[data-test-id='calcLayout']").find(".progress");


    @Step("Переход на сайт alfabank.ru")
    public void openUrl() {
        open(alfabankURL);
    }

    @Step("Ввод суммы в поле: \"Сумма кредита\" ")
    public void enterCreditValue(String text) {
        creditInput.setValue(text);
        clickOnButton.click();
    }

    @Step("Проверка соответствия отображаемого и введенного числа")
    public void assertValueDisplayToEnter(String text) {
        valueOfCredit.shouldHave(text(text));
    }

    @Step("Проверка корректности отображения названия поля \"Сумма кредита\" после ввода числа")
    public void verifyTextSumOfCredit(String text) {
        textSumOfCredit.shouldHave(Condition.text(text));
    }

    @Step("Проверка корректного значения в поле установки суммы кредита (UI)")
    public void verifyValueInputBar(String value) {
        inputBar.shouldHave(value(value));
    }

    @Step("Проверка корректного значения в поле progressBar (UI)")
    public void verifyValueProgressBar(String value) {
        progresBar.shouldHave(value(value));
    }




}