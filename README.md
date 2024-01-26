# Introduction
Проект посвящен написанию автотестов на Java с использованием Selenide и JUnit5 для сайта ok.ru
Для сборки проекта использовался Maven.

# Написание первого теста
После подключения всех зависимостей, установки необходимых библиотек и прочего, напишем свой первый тест, который будет проверять, что при введении верного логина и пароля сайт нас пускает на главную страницу.
```java
    @Test
    public void checkCorrectLoginAndPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(CORRECT_LOGIN).inputPassword(CORRECT_PASSWORD).submitLoginAndPassword();
        ProfilePage profilePage = new ProfilePage();
        String href = profilePage.getHrefProfilePage();
        Assertions.assertEquals(href, TOP_MENU);
    }
```
Здесь мы вводим логин и пароль, далее проверяем, что на странице, куда нас перекинуло после нажатия на кнопку "Войти", мы видим соответствующее меню.

# Аннотация @ParameterizedTest
Понятно, что при каких-то различных введенных данных сайт должен реагировать одинаково. Чтобы избежать безмерного копирования одного и того же кода, существует аннотация @ParameterizedTest. 
```java
    @ParameterizedTest
    @ValueSource(strings = {"", INCORRECT_PASSWORD})
    void checkEmptyLogin(String word) {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin("").inputPassword(word).submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, ENTER_YOUR_USERNAME);

    }
```
Здесь мы проверяем, что на пустой и неправильный ввод пароля сайт введет себя одинаково. С помощью @ParameterizedTest уместили два теста в один. 

# Аннотация @MethodSource
Но что делать, если мы хотим реализовать что-то похожее на @ParameterizedTest, но данные, которые мы будем вводить, не будут являться строчками. Для этого случая тоже есть своя аннотация
```java
    @ParameterizedTest
    @MethodSource(value = "testLoginsAndPasswords2")
    public void nonSuccesLoginOrPassword(UserModel userModel) {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin(userModel.getLoginName()).inputPassword(userModel.getPassword()).submitLoginAndPassword();
        String text_of_error = loginPage.emptyInputLoginAndPassword();
        Assertions.assertEquals(text_of_error, INCORRECT_LOGIN_OR_PASSWORD);
    }

    private static Stream<UserModel> testLoginsAndPasswords2() {
        UserModel user1 = UserModel.builder().loginName(INCORRECT_LOGIN).password(CORRECT_PASSWORD).build();
        UserModel user2 = UserModel.builder().loginName(CORRECT_LOGIN).password(INCORRECT_PASSWORD).build();
        UserModel user3 = UserModel.builder().loginName(CORRECT_LOGIN).password(UPPERCASE_PASSWORD).build();
        UserModel user4 = UserModel.builder().loginName(INCORRECT_LOGIN).password(INCORRECT_PASSWORD).build();
        return Stream.of(user1, user2, user3, user4);
    }
```

Теперь вместо строк с логином и паролем у нас данные типа "UserModel". И вместо того, чтобы писать 4 отдельных теста, мы всё уместили в 4 строчки.

# Allure
После написания большого количества тестов естественным желанием будет собрать все их результаты воедино, нарисовать графики, в общем посмотреть на картину в целом. Такую возможность предоставляет Allure (подробнее про него можно почитать на официальном сайте).

Давайте запустим все тесты, которые мы написали (какие-то сломаем специально, для наглядности) и посмотрим, что получится
![alt-текст](https://github.com/trueuser3/web_automation/blob/branch-for-readme/images/Screenshot%20from%202024-01-27%2001-40-08.png)














