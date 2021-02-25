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

2)This one is for to run all test scenarios and outlines combined.
- Go to ```src\java\main\resources\Runners\Runner``` 
feature file and right click, then click  ```Run 'Runner'```


## Test Report

I have used cucumber-reporting. After each execution there will created a file called ```cucumber-reports.html'``` under  ```target``` file.


## Further Notes:

I have designed 4 individual test scenarios/scenario outlines:

3 of them is 

