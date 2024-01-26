#Introduction
Проект посвящен написанию автотестов на Java с использованием Selenide и JUnit5. Для сборки проекта использовался Maven.

#Написание первого теста
Псоле подключения всех зависимостей, установки необходимых библиотек и прочего, напишем свой первый тест, который будет проверять, что при введении верного логина и пароля сайт нас пускает на главную страницу
```java
    @Test
    public void checkCorrectLoginAndPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(CORRECT_LOGIN).inputPassword(CORRECT_PASSWORD).submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, ENTER_PASSWORD);
    }
```
