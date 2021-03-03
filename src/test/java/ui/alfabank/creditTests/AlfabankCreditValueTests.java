package ui.alfabank.creditTests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AlfabankCreditValuePage;
import ui.testbase.TestBase;

import static com.codeborne.selenide.Selenide.sleep;

@Tag("web")
public class AlfabankCreditValueTests extends TestBase {

    @BeforeAll
    static void setUpConfiguration() {
        Configuration.fastSetValue = true;
    }

    @Test
    @Description("Positive test with PO")
    void verificationCreditValuePO() {

        AlfabankCreditValuePage alfabankCreditValue = new AlfabankCreditValuePage();

        alfabankCreditValue.openUrl();

        alfabankCreditValue.enterCreditValue("4999999");

        alfabankCreditValue.verifyValueInputBar("5000000");

        alfabankCreditValue.verifyValueProgressBar("4899999");

        sleep(3);

        }
    }

