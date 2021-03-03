# UI + API Автотестирование - на стенде CI _(Continuous Integration)_

**UI тесты (Selenide + Junit + PageObject):**
1. Валидация поля ввода суммы кредита на сайте alfabank.ru (валидация текста, валидация значений)
2. Проверка корректного отображения заголовка найденного товара на сайте yandex.market.ru

**API тесты (RestAssured + Hamcrest + Junit):**
Тесты с использованием GET, POST, PUT запроса - проверка корректного ответа от сервера (статус код), проверка конкретных значений полученных в ответе от сервера

**Реализация CI:**
1. В Jenkins создается параметризированная джоба. В джобе указан репозиторий с github, где находятся тесты. Сборщик Gradle, тесты запускаются командой gradle clean "gradle task name"

![JobJenkins](https://github.com/Varuna108/UI_API_TEST-Selenide-Selenoid-/blob/master/src/test/resources/images/jenkins%20job.png)

2. UI тесты отправляются на Selenoid, где в режиме реального времени можно посмотреть выполнение теста в Selenoid UI:
   
![Selenoid_UI_VNC](https://github.com/Varuna108/UI_API_TEST-Selenide-Selenoid-/blob/master/src/test/resources/images/selenoid_ui_vnc.png)

3. Пройденные тесты записываются видеорекордером и появляются на вкладке Videos в Selenoid UI, где их также можно посмотреть:

UI тест альфабанк:
![alfabank_test](https://github.com/Varuna108/UI_API_TEST-Selenide-Selenoid-/blob/master/src/test/resources/images/alfabank_credi_input_validate.gif)

UI тест яндекс.маркет:
![yandexmarket_test](https://github.com/Varuna108/UI_API_TEST-Selenide-Selenoid-/blob/master/src/test/resources/images/yandex_market.gif)

4. По окончанию тестирования, в Jenkins формируется Allure отчет, где можно посмотреть процент пройденных/упавших/не выполненных тестов. Шаги теста. Скриншот последней страницы, логи браузера, исходный код тестируемой страницы, видео пройденного теста.
   
![allure_report](https://github.com/Varuna108/UI_API_TEST-Selenide-Selenoid-/blob/master/src/test/resources/images/allure_report.png)

![allure_suites](https://github.com/Varuna108/UI_API_TEST-Selenide-Selenoid-/blob/master/src/test/resources/images/allure_suites.png)
   

