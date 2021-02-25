# LuxoftTask

This project is a sample Cucumber Java UI Automation Implementaion for https://www.ubs.com/global/en.html. It has 4 scenarios/scenario outlines (3 of them is a scenario outline) both from UI and one with API Level perspective. The details of scenarios will be explained in Further Notes section

### Prerequisites

1. JDK 15 (make sure Java class path is set)
2. IntelliJ 
3. IntelliJ Plugin for
    - Cucumber for Java
    - Gherkin

### Installing

1. JDK 15: https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html
2. IntelliJ Community Edition:https://www.jetbrains.com/idea/download/#section=windows
3. Open IntelliJ and Go: File/Settings/Plugins and write Cucumber for Java and click install.
   Repeat the same for Gherkin.


## Cloning the repository


```bash
git clone https://github.com/alperoguzkan/LuxoftTask.git
```


## WebDrivers

Webdrivers are already located in the proejct itself. And in the code its refering relevant user's directory. So you don't need to change the directory. 
Only thing you need to make sure of is that, browser versions should be compatible with driver versions:

For Google Chrome: ChromeDriver 88.0.4324.96 is used (That means your Chrome build should be a subversion of version 88)

For Mozilla Firefox: GeckoDriver 84.0.2 is used 

For Edge: EdgeDriver 88.0.705.74  is used 


## Running the tests

There are 2 ways of running test scenarios. 

1)This one is individual running of test scenarios/scenario outlines:
- Go to ```src\java\main\resources\Features\Account Transfer Demo.feature``` 
feature file and right click, then click  ```Run 'Feature:Account Transfer Demo'```

For the remainder 3 feature files, you can do the this with their respected names.

2)This one is for to run all test scenarios and outlines combined.
- Go to ```src\java\main\resources\Runners\Runner``` 
feature file and right click, then click  ```Run 'Runner'```


## Test Report

I have used cucumber-reporting. After each execution there will created a file called ```cucumber-reports.html'``` under  ```target``` file.

## config.properties file

This file is created for the control of some high level parameters:

defaultBrowser=chrome

browser_Chrome=chrome

browser_Firefox=firefox

browser_Edge=edge

defaultLanguage=EN

language_english=EN

language_german=DE

You can change defaultBrowser to ```firefox``` or ```edge``` to run them in their respected browsers.
You can change defaultLanguage to ```DE``` to run the cases in German language. (Main Page only allows 2 languages, so on the high level, I defined only 2 languages, but for ```Checking UBS Social Media Links``` scenario outline, I have added other language selection within the Examples section of the scenario outline.



## Further Notes:

I have designed 4 individual test scenarios/scenario outlines:

As I couldn't have a real UBS Account (even though I applied for it- and it says you will be contacted for the creation of the account, and I have not contacted yet), I designed
cases without any login, but I had tried to add many things from functional perspective of the website.

3 of them is scenario outline:
1) Account Transfer Demo.feature: This scenario outline uses the demo ebanking and make a transaction between two arbitarily selected users, the amount of money and note that will be sent is parametrized in cucumber file.
2) Checking UBS Social Media Links:This scenario is checking if the social media links is there at relevant page and working (i.e. waiting for http response code of 200). The language selection for the case is parametrized within the case. Normally I plan to make language selection from a single configuration file, but the langauge selection for the inner pages are not uniform, as main page only allows English and German, but others pages have other options as well. For the main page, I included a langauge selection function to select between English/German and this selection can be changed in from configuration file as mentioned config.properties file
3) Register.feature: This scenario outline is to create a user and includes some verifications. I used Fairy library to create some random data for personal information, though countryName and areaOfInterest is parametrized in the test case. You can add new examples to the scenario as well.


1 of them is scenario:
1) ETF Contact Number Extractor:This scenario is not intended for to verification, but an extraction of a specific information(i.e. etf contact number) into a file called ```etfContactNumber.txt'```. 
After each run, this file is overwritten, this might be used to retrieve the number if it is changed.

