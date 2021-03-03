package ui.alfabank.creditTests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AlfabankCreditTextPage;
import ui.testbase.TestBase;

import static com.codeborne.selenide.Selenide.sleep;

@Tag("web")
public class AlfabankCreditTextTests extends TestBase {

    @BeforeAll
    static void setUpConfiguration() {
        Configuration.fastSetValue = true;
    }

    @Test
    @Description("Positive test with PO")
    void verificationCreditValuePO() {

        AlfabankCreditTextPage alfabankCreditTest = new AlfabankCreditTextPage();

        alfabankCreditTest.openUrl();

        alfabankCreditTest.enterCreditValue("4999999");

        alfabankCreditTest.assertValueDisplayToEnter("4 999 999");

        alfabankCreditTest.verifyTextSumOfCredit("Сумма кредита");

        sleep(3);

        }
    }

