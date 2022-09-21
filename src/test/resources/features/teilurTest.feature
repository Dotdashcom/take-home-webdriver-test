#Language : En
#encoding: utf-8
#Developer : Bressan, Luis

  @IntegrationTest

  Feature: Quality Engineer Test environment from docker

  @Test @Login
  Scenario Outline: TS:["<TS>"] - [1 / 2 Login ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    When Enter "<Username>" and "<Password>"
    Then validate result "<type>" "<result>" "<result2>"
    Examples:
      | TS  | Scenario | Description          |HomePage                       |type |Username   | Password                    |result                          |result2|
      | 001 |    0001  | Login Success        |http://10.10.0.25:7080/login   |LOGIN|tomsmith   | SuperSecretPassword!        |Secure Area                     |       |
      | 001 |    0002  | Login Error          |http://10.10.0.25:7080/login   |LOGIN|tomsmith   | test                        | Your password is invalid!      |       |


    @Test @CheckBox
    Scenario Outline: TS:["<TS>"] - [ 3 checkboxes ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      When test checks and unchecks checkboxes "<status>"
      Then validate result "<type>" "<status>" "<result>"
      Examples:
        | TS  | Scenario | Description                              |HomePage                            |type|status |result|
        | 001 |    0001  | Test checks and unchecks checkboxes.     |http://10.10.0.25:7080/checkboxes   |CKBX|true   |      |
        | 001 |    0002  | Test checks and unchecks checkboxes.     |http://10.10.0.25:7080/checkboxes   |CKBX|false  |      |

    @Test @context
    Scenario Outline: TS:["<TS>"] - [ 4 context menu ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And test right click on context menu
      Then validate result "<type>" "<status>" "<result>"
      Examples:
        | TS  | Scenario | Description                              |HomePage                              |type|status|result|
        | 001 |    0001  | Test right clicks on the context menu.   |http://10.10.0.25:7080/context_menu   |CON |      |      |

    @Test @drag
    Scenario Outline: TS:["<TS>"] - [ 5 dragdrop ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And test drags element A to element B "<type>"
      #Then validate result "<type>" "<status>"
      Examples:
        | TS  | Scenario | Description                              |HomePage                              |type|result|
        | 001 |    0001  | Test right clicks on the context menu.   |https://jqueryui.com/resources/demos/droppable/default.html|0||
        #| 002 |    0002  | Test right clicks on the context menu.   |http://10.10.0.25:7080/drag_and_drop  |1 |



    @Test   @dropdown
    Scenario Outline: TS:["<TS>"] - [ 6 dropdow ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And select doropdopwn "<type>"
      #Then validate result "<type>" "<status>"
      Examples:
        | TS  | Scenario | Description                                                  |HomePage                              |type        |result|
        | 001 |    0001  | test selects Option 1 and Option 2 from the drop down menu.   |http://10.10.0.25:7080/dropdown      |Option 1    |      |
        | 001 |    0002  | test selects Option 1 and Option 2 from the drop down menu.   |http://10.10.0.25:7080/dropdown      |Option 2    |      |



    @Test @dinamic
    Scenario Outline: TS:["<TS>"] - [ 8 dinamic content ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And Test refreshes the page a couple of times "<times>"
      Examples:
        | TS  | Scenario | Description                                                  |HomePage                                      |times        |
        | 001 |    0001  | test selects Option 1 and Option 2 from the drop down menu.   |http://10.10.0.25:7080/dynamic_content       |5    |

    @Test @dinamicControl
    Scenario Outline: TS:["<TS>"] - [ 8 dinamic content ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      When Test clicks on the Remove Button and uses explicit wait "<times>"
      Then validate result "<type>" "<status>" "<result>"
      And Test clicks on Add Button
      And validate result "<type>" "<status2>" "<result>"
      And Test clicks on the Enable Button
      And validate result "<type>" "<status3>" "<result>"
      And Test clicks on the Disabled Button
      And validate result "<type>" "<status4>" "<result>"
      Examples:
        | TS  | Scenario | Description            |HomePage                                   |type|status     |status2     |status3       |status4        |result|
        | 001 |    0001  | test Dynamic Controls  |http://10.10.0.25:7080/dynamic_controls    |DC  |It's gone! |It's back!  |It's enabled! |It's disabled! |     |


    @Test @DynamicLoading
    Scenario Outline: TS:["<TS>"] - [ 9 Dynamic Loading ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And Test clicks the start button
      And validate result "<type>" "<status>" "<result>"
      Examples:
        | TS  | Scenario | Description          |HomePage                                      |status           |result|
        | 001 |    0001  | test Dynamic Loading  |http://10.10.0.25:7080/dynamic_loading/2        |Hello World!   |     |


    @Test @FileDownload
    Scenario Outline: TS:["<TS>"] - [ 10 File Download ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And Test clicks file download
      And validate result "<type>" "<status>" "<result>"
      Examples:
        | TS  | Scenario | Description          |HomePage                             |type   |status         |result|
        | 001 |    0001  | test File Download  |http://10.10.0.25:7080/download       |FILE   |some-file.txt  |      |


    @Test @Fileupload
    Scenario Outline: TS:["<TS>"] - [ 11 File Download ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And Test clicks file upload "<status>"
      And validate result "<type>" "<status>" "<result>"
      Examples:
        | TS  | Scenario | Description          |HomePage                             |type    |status         |result|
        | 001 |    0001  | test File Upload     |http://10.10.0.25:7080/upload        |LOGIN   |some-file.txt  |      |




    @Test @FloatingMenu
    Scenario Outline: TS:["<TS>"] - [ 12 Floating Menu ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And Test scrollpage
      And validate result "<type>" "<status>" "<result>"
      Examples:
        | TS  | Scenario | Description          |HomePage                             |type    |status      |result|
        | 001 |    0001  | test Floating Menu   |http://10.10.0.25:7080/floating_menu |LOGIN   |Home        |      |

    @Test @Iframe
    Scenario Outline: TS:["<TS>"] - [ 13 Iframe ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And Test switch to iframe
      And validate result "<type>" "<status>" "<result>"
      Examples:
        | TS  | Scenario | Description          |HomePage                 |type    |status           |result|
        | 001 |    0001  | test Iframe     |http://10.10.0.25:7080/iframe |LOGIN   |SOME TEXT        |      |


    @Test @MouseHover
    Scenario Outline: TS:["<TS>"] - [ 14 Mouse Hover ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And Test does a mouse hover on each image "<image>"
      And validate result "<type>" "<status>" "<result>"
      Examples:
        | TS  | Scenario | Description          |HomePage                  |type    |status             |image|result|
        | 001 |    0001  | Mouse Hover     |http://10.10.0.25:7080/hovers  |LOGIN   |name: user1        |1    |      |
        | 001 |    0002  | Mouse Hover     |http://10.10.0.25:7080/hovers  |LOGIN   |name: user2        |2    |      |
        | 001 |    0003  | Mouse Hover     |http://10.10.0.25:7080/hovers  |LOGIN   |name: user3        |3    |      |


    @Test @JavaScript
    Scenario Outline: TS:["<TS>"] - [ 15 JavaScript Alerts ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And Test Clicks on JS Alert Button "<stage>"
      And validate result "<type>" "<status>" "<result>"
      Examples:
        | TS  | Scenario | Description            |HomePage                                  |type    |status             |stage|result                             |
        | 001 |    0001  | JavaScript Alerts      |http://10.10.0.25:7080/javascript_alerts  |JS1     |I am a JS Alert    |     1|You successfuly clicked an alert  |
        | 001 |    0001  | JavaScript Alerts      |http://10.10.0.25:7080/javascript_alerts  |JS1     |I am a JS Confirm  |     2|You clicked: Ok                   |
        | 001 |    0001  | JavaScript Alerts      |http://10.10.0.25:7080/javascript_alerts  |JS1     |I am a JS prompt   |     3|You entered: TESTE 123            |


    @Test @JavaScriptError
    Scenario Outline: TS:["<TS>"] - [ 16 JavaScript Error ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And Test finds the JavaScript error on the page "<result>"
      Examples:
        | TS  | Scenario | Description            |HomePage                                 |type |status    |result        |
        | 001 |    0001  | JavaScript Error       |http://10.10.0.25:7080/javascript_error  |     |          |reading 'xyz'  |


    @Test @windows
    Scenario Outline: TS:["<TS>"] - [ 17 Open in New Tab  ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And Test clicks on the Click Here link
      And validate result "<type>" "<status>" "<result>"
      Examples:
        | TS  | Scenario | Description            |HomePage                         |type |status    |result        |
        | 001 |    0001  | Open in New Tab       |http://10.10.0.25:7080/windows   |NW   |          |New Window  |


    @Test @Notification
    Scenario Outline: TS:["<TS>"] - [ 18 Notification   ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And Test Click Here link a multiple times "<result>"
      And validate result "<type>" "<status>" "<result>"
      Examples:
        | TS  | Scenario | Description            |HomePage                                                 |type |status    |result        |
        | 001 |    0001  | Notification Message    |http://10.10.0.25:7080/notification_message_rendered    |NW   |          |Action successful|
        | 001 |    0002  | Notification Message    |http://10.10.0.25:7080/notification_message_rendered    |NW   |          |Action unsuccesful, please try again|
        #| 001 |    0003  | Notification Message    |http://10.10.0.25:7080/notification_message_rendered    |NW   |          |Action Unsuccessful|



