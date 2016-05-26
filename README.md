# JivoSite Mobile SDK для разработчиков
JivoSite Mobile SDK позволяет встроить чат в мобильные приложения iOS и Android и принимать обращения клиентов.

### Демо
В папке demo размещены 2 проекта iOs и Android с демонстрацией подключения SDK и его использования.
Эти приложения позволяют обратиться в техподдержку JivoSite в чате.

 - [App Store][iossdkapp]
 - [Google Play][androidsdkapp]

 [iossdkapp]: <https://itunes.apple.com/ru/app/jivosite-sdk-dla-razrabotcikov/id1085180661?mt=8>
 [androidsdkapp]: <https://play.google.com/store/apps/details?id=com.jivosite.supportapp&hl=ru>


### Системные требования
- iOS 8.0+, XCode 7.2
- Android 4.4+, Android Studio 2.0

### Подключение
О том как подключить SDK в проект можно посмотреть в видеоинструкциях:
 - [iOS][iosmanual]
 - [Android][androidmanual]

 [iosmanual]: <https://www.youtube.com/watch?v=2M5BqDubp7g>
 [androidmanual]: <https://www.youtube.com/watch?v=X5AEWG83G0g>


### Получение widget_id и site_id
Для получения widget_id и site_id необходимо в программе оператора нажать на кнопку "Протестировать чат", выбрать нужный из списка.
В браузере откроется окно с виджетом, нужно открыть консоль браузера и посмотреть значения переменных в объекте window.jivo_config

### Настройка
Настройка производится в файле index.html

        jivo_config = {

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

            //widget_id
            "widget_id": "eyLibOwrJA",

            //site_id
            "site_id": 204998,

            //ссылка, которая будет светиться в программе у оператора
            "app_link":'Widget_Mobile',

            //Текст в поле ввода
            "placeholder": 'Введите сообщение'
        }

#### iOS
Для подключения в проект iOS нужно перенести в свой проект папку html и исходные коды JivoSdk в контроллере для встаивания используем протокол JivoDelegate и размещаем компонент UIWebView инициализируем переменную JivoSdk и при инициализации передаем ссылку на webview и строку с локализацией lang будет загружаться файл index_<lang>.html, второй параметр необязательный, в этом случае будет загружен index.html в метод onEvent будут приходить события из компонента

#### Android
Для подключения в проект Android нужно перенести в папку assets ресурсы html и исходные коды JivoSdk в Activity для встаивания имплементируем JivoDelegate и размещаем компонент UIWebView инициализируем переменную JivoSdk и при инициализации передаем ссылку на webview и строку с локализацией lang будет загружаться файл index_<lang>.html, второй параметр необязательный, в этом случае будет загружен index.html в метод onEvent будут приходить события из компонента

### Работа
Виджет отправляет события в приложения, используя протокол jivoapi://

- установлено соединение (jivoapi://connection.connect)
- соединение откючено (jivoapi://connection.disconnect)
- ошибки при подключении (jivoapi://connection.error)
- получено сообщение (jivoapi://agent.message)
- чат сервер разорвал соединение, некому ответить (jivoapi://connection.force_offline)
- установлено подключение с сервером (jivoapi://connection.startup_ok)
- оператор принял чат (jivoapi://connection.accept)
- оператор передал чат (jivoapi://connection.transferred)
- изменился оператор (jivoapi://agent.set)

