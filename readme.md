# UI + API Автотестирование - на стенде CI _(Continuous Integration)_

###UI тесты (Selenide + Junit + PageObject):
1. Валидация поля ввода суммы кредита на сайте alfabank.ru (валидация текста, валидация значений)
2. Проверка корректного отображения заголовка найденного товара на сайте yandex.market.ru

###API тесты (RestAssured + Hamcrest + Junit):
Тесты с использованием GET, POST, PUT запроса - проверка корректного ответа от сервера (статус код), проверка конкретных значений полученных в ответе от сервера

###Реализация CI:
1. В Jenkins создается параметризированная джоба. В джобе указан репозиторий с github, где находятся тесты. Сборщик Gradle.

![Иллюстрация к проекту](https://github.com/jon/coolproject/raw/master/image/image.png)



