# MobileSdk

Компонент widget mobile состоит из 2-х файлов:
index.html
bundle.js

в Папке supportApp размещены 2 проекта iOs и Android с демонстрацией подключения компонента и его использования
В ресурсах каждого проекта есть папка html, где расмещен встраиваемый виджет

в Папке sdk размещены файлы sdk для передачи в публичное хранилище

# Системные требования
Требуется ос: iOS 8.0+ , Android 4.4+
Для сборки: XCode 7.2, Android Studio 2.0

# Настройка
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

# iOS
    Для подключения в проект iOS нужно перенести в свой проект папку html и исходные коды JivoSdk
    в контроллере для встаивания используем протокол JivoDelegate и размещаем компонент UIWebView
    инициализируем переменную JivoSdk и при инициализации передаем ссылку на webview и строку с локализацией lang
    будет загружаться файл index_<lang>.html, второй параметр необязательный, в этом случае будет загружен index.html
    в метод onEvent будут приходить события из компонента

# Android
    Для подключения в проект Android нужно перенести в папку assets ресурсы html и исходные коды JivoSdk
    в Activity для встаивания имплементируем JivoDelegate и размещаем компонент UIWebView
    инициализируем переменную JivoSdk и при инициализации передаем ссылку на webview и строку с локализацией lang
    будет загружаться файл index_<lang>.html, второй параметр необязательный, в этом случае будет загружен index.html
    в метод onEvent будут приходить события из компонента

# Работа
Виджет отправляет события в приложения, используя протокол jivoapi://


//установлено соединение
jivoapi://connection.connect

//соединение откючено
jivoapi://connection.disconnect

//ошибки при подключении
jivoapi://connection.error

//получено сообщение
jivoapi://agent.message

чат сервер разорвал соединение, некому ответить
jivoapi://connection.force_offline

установлено подключение с сервером
jivoapi://connection.startup_ok

оператор принял чат
jivoapi://connection.accept

оператор передал чат
jivoapi://connection.transferred

изменился оператор
jivoapi://agent.set
