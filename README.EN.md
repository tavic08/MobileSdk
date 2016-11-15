# JivoChat Mobile SDK for Developers
With the Jivo mobile SDK you can integrate the chat widget for customer support into your native app for iOS or Android. Integration will only take a few minutes because the chat interface is already implemented – you only need to add a couple of lines in your code to get the chat working.

### Demo apps for iOS and Android
Check out our demo-apps for a live preview of how the chat will look like and function inside your own app. These two very simple demo-apps we've created allow you to chat directly with our support team... so now you can imagine how users of your own app will be able to easily connect with your own support team.

- [Demo-app for iOS][iossdkapp]
- [Demo-app for Android][androidsdkapp]

 [iossdkapp]: <https://itunes.apple.com/en/app/jivosite-sdk-dla-razrabotcikov/id1085180661?mt=8>
[androidsdkapp]: <https://play.google.com/store/apps/details?id=com.jivosite.supportapp&hl=en>

The source code for these applications can be found in the demo folder.

### Supported OS
- iOS 8.0+, XCode 7.2
- Android 4.4+, Android Studio 2.0

### Instructions for getting started
View our video and everything will become clear:
- [Video manual for iOS][iosmanual]
- [Video manual for Android][androidmanual]

[iosmanual]: <https://www.youtube.com/watch?v=2M5BqDubp7g>
[androidmanual]: <https://www.youtube.com/watch?v=X5AEWG83G0g>

### Get the widget_id and site_id
The widget_id and site_id can be found by going to the admin panel and then into the settings section of your Mobile app SDK. If you didn't create one yet, go "Add communication channels -> Mobile app SDK" and after asigning a new name, the widget_id and site_id will be displayed.

### SDK Configuration
The following configuration settings can be located in the index.html file:

        jivo_config = {
            //widget_id - REPLACE with YOUR own!
            "widget_id": "xxxx",

            //site_id - REPLACE with YOUR own!
            "site_id": xxxxx,

            //the color of the submit button
            "plane_color":"red",

            //color of agent messages
            "agentMessage_bg_color":'green',

            //text color of the message agent
            "agentMessage_txt_color":'blue',

            //color of the client message
            "clientMessage_bg_color":'yellow',

            //text color of the client message
            "clientMessage_txt_color":'black',

            //active the invitation, if not use, leave blank
            "active_message": "Hello! Can I help you?",

            //link that will glow in the operator program
            "app_link":'Widget_Mobile',

            //The text in the input field
            "placeholder": "Enter message',

            //use secure connection
            "secure": true,

            //use for replace onEvent function
            //"event_func": function(event) {console.log(event)}
        }

#### iOS
To use the SDK in the iOS app you need to move the folder and the html source code of JivoSdk into your project. In the controller for the integration we place the UIWebView component and use the JivoDelegate protocol. Declare a JivoSDK variable and initialize it. During the initialization pass a reference to a webview and languageKey string, which will load either the Russian or English localization file index_<lang>.html. Second parameter is optional in this case, the index.html file will be loaded. In the onEvent method will receive the events from the component. The list of such events can be found  below.

#### Android
To use the SDK in the Android app the resources html and source codes of JivoSdk should be put to the assets folder. In Activity to incorporate implement JivoDelegate and place the UIWebView component. Declare a JivoSDK variable and initialize it. During the initialization pass a reference to a webview and the languageKey string, which will load either the Russian or English localization file index_<lang>.html. The onEvent method will receive the events from the component. The list of such events can be found  below.

### Events
The widget sends the following events in the onEvent method

- a connection is being established (‘connection.connect’)
- connection terminated (‘connection.disconnect’)
- errors during connection (the‘connection.error’)
- receiving a message (‘agent.message’)
- the chat server has terminated the connection, there is no one to answer (a‘connection.force_offline)
- have a connection to a server‘connection.startup_ok’)
- the operator has accepted the chat‘connection.accep't)
- the operator has transferred the chat‘connection.transferred’)
- changed operator (‘agent.set’)

