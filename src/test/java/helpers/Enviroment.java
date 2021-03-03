package helpers;

public class Enviroment {
    public final static String
            selenoidURL = System.getProperty("selenoid_url", "autotest.su"),
            yandexmarketURL = System.getProperty("yandexMarketUrl", "https://market.yandex.ru"),
            alfabankURL = System.getProperty("googleUrl", "https://alfabank.ru/");
}
