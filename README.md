# JivoChat Mobile SDK

With Jivo mobile SDK you can integrate the chat  widget for customer support into your native app for iOS or Android. Integration will only take a few minutes because the chat interface is already implemented – you only need to add a couple of lines in your code to get the chat working.

[Continue reading in English][sdkengver]
[sdkengver]:
<https://github.com/JivoSite/MobileSdk/blob/master/README.EN.md>

----

# JivoSite Mobile SDK для разработчиков
JivoSite Mobile SDK позволяет встроить чат для поддержки клиентов в нативные мобильные приложения iOS и Android и принимать обращения клиентов. Интеграция занимает несколько минут, так как интерфейс чата с лентой сообщений уже реализован – вам понадобится только добавить пару строчек в ваш код.


### Демо-приложения для iOS и Android
Посмотрите, как работает чат внутри приложения на примере наших демо-приложений. Эти две очень простые аппки позволяют написать в чат  техподдержке JivoSite.

 - [Демо-прога для iOS][iossdkapp]
 - [Демо-прога для Android][androidsdkapp]

 [iossdkapp]: <https://itunes.apple.com/ru/app/jivosite-sdk-dla-razrabotcikov/id1085180661?mt=8>
 [androidsdkapp]: <https://play.google.com/store/apps/details?id=com.jivosite.supportapp&hl=ru>

Исходники этих приложений можно найти в папке demo.


### Поддерживаемые ОС
- iOS 8.0+, XCode 7.2
- Android 4.4+, Android Studio 2.0

### Инструкция по началу работы
Посмотрите наши видео и все сразу станет понятно:
 - [Видео-мануал для iOS][iosmanual]
 - [Видео-мануал для Android][androidmanual]

 [iosmanual]: <https://www.youtube.com/watch?v=2M5BqDubp7g>
 [androidmanual]: <https://www.youtube.com/watch?v=X5AEWG83G0g>


### Получение widget_id и site_id
Для получения widget_id и site_id в панели управления добавьте канал связи “Мобильное приложение” – вы увидите widget_id и site_id на странице настроек.


### Конфигурация SDK
Настройка производится в файле index.html:

        jivo_config = {
            //widget_id - ЗАМЕНИТЕ НА СВОЙ!
            "widget_id": "xxxx",

            //site_id - ЗАМЕНИТЕ НА СВОЙ!
            "site_id": xxxxx,

            //цвет кнопки отправить
            "plane_color":"red",

            //цвет агентского сообщения
            "agentMessage_bg_color":'green',

            //цвет текста агентского сообщения
            "agentMessage_txt_color":'blue',

            //цвет клиентского сообщения
            "clientMessage_bg_color":'yellow',

            //цвет текста клиентского сообщения
            "clientMessage_txt_color":'black',

            //активное приглашение, если не используем, то оставить пустым
            "active_message": "Здравствуйте! Я могу вам чем-то помочь?",

            //ссылка, которая будет светиться в программе у оператора
            "app_link":'Widget_Mobile',

            //Текст в поле ввода
            "placeholder": 'Введите сообщение'
        }

#### iOS
Для подключения в проект iOS нужно перенести в свой проект папку html и исходные коды JivoSdk. В контроллере для встаивания используем протокол JivoDelegate и размещаем компонент UIWebView. Инициализируем переменную JivoSdk, при инициализации передаем ссылку на webview и строку с локализацией lang. Будет загружаться файл index_<lang>.html. Параметр lang необязательный, в этом случае будет загружен index.html. В метод onEvent будут приходить события из компонента. Перечень событий описан в разделе “События”.

#### Android
Для подключения в проект Android нужно перенести в папку assets ресурсы html и исходные коды JivoSdk. В Activity для встаивания имплементируем JivoDelegate и размещаем компонент UIWebView. Инициализируем переменную JivoSdk, при инициализации передаем ссылку на webview и строку с локализацией lang. Будет загружаться файл index_<lang>.html. Параметр lang необязательный, в этом случае будет загружен index.html. В метод onEvent будут приходить события из компонента.
Перечень событий описан в разделе “События”.

### События
Виджет отправляет следующие события в метод onEvent

- установлено соединение (‘connection.connect’)
- соединение откючено (‘connection.disconnect’)
- ошибки при подключении (‘connection.error’)
- получено сообщение (‘agent.message’)
- чат сервер разорвал соединение, некому ответить (‘connection.force_offline)
- установлено подключение с сервером (‘connection.startup_ok’)
- оператор принял чат (‘connection.accep’t)
- оператор передал чат (‘connection.transferred’)
- изменился оператор (‘agent.set’)
