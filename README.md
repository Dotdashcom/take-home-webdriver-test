# DotDashCom Selemium test cases

Ganbayar Tsogbadrakh ( ganbayar.us@gmail.com )

All tests are completed successfully. 


1. Tests are annotated @Test
2. Used teardown mechanism
3. Tests are runnable from IDE's (tested in Eclipse , Intellij) 

for linux:

Download chrome driver :
Click here: [DOWNLOAD](https://sites.google.com/a/chromium.org/chromedriver/downloads)

Give executable permission:
```bash
Sudo chmod +x chromedriver

```
If you dont want GUI , enable headless option in chrome driver:
```java
ChromeOptions options = new ChromeOptions();
WebDriver driver = new ChromeDriver(options.addArguments("--remote-allow-origins=*"));
options.setHeadless(true);
```



