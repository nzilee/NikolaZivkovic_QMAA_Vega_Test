# NikolaZivkovic_QMAA_Vega_Test

# Playwright Automation with TestNG

**Test Cases:** https://docs.google.com/spreadsheets/d/1Ba2mbsvCKN1owgq0PWNV9NdFauaQS1RIu3cvBtGiqBA/edit?usp=sharing  
**Test Execution Report:** https://docs.google.com/spreadsheets/d/1SjxWOuJ0mM_7x3gbykpJmsKjDCkjsLbxZTxr1zezozE/edit?usp=sharing  
**Bug report:** https://docs.google.com/spreadsheets/d/1DbSzBUzMCrcjl9n-IqtT5aFwLxAb37-Qz04CGX2Teuo/edit?usp=sharing  
**Test Cases for automated scenarios:** https://docs.google.com/spreadsheets/d/1Eca_FStOZymFAW2FFaT7qNU-8hNplvjFpzYVvj-j1Ts/edit?usp=sharing

## Project Overview

This project is an automated UI testing framework for `https://www.saucedemo.com/v1/index.html`, built using:

- **Java** as the programming language
- **Playwright** as the automation framework
- **TestNG** for test execution
- **Page Object Model (POM)** for maintainability
- **Headless mode controlled via `Constants.java`**
- **Automatic screenshot capture on test failure**

The tests validate core functionalities, including login, sorting, cart operations, and checkout.

---

## Project Setup
### Prerequisites

Ensure the following are installed:

- **Java 17+** (Check version: `java -version`)
- **Maven** (Check version: `mvn -version`)
- **IntelliJ IDEA** (Recommended)

### Clone the Repository

```sh
git clone https://github.com/nzilee/NikolaZivkovic_QMAA_Vega_Test
cd NikolaZivkovic_QMAA_Vega_Test
```
Install Dependencies
```sh
mvn clean install
```

### Running Tests
**Headless Mode Configuration**  
Headless mode is controlled in Constants.java via the HEADLESS boolean value.  
Modify the file before running tests:
```sh
package config;

public class Constants {
    public static final boolean HEADLESS = true; // Set to false to run in headed mode
}
```

**Run Tests in IntelliJ**  
1. Open IntelliJ and navigate to the project.
2. Open testng.xml.
3. Right-click and select "Run 'testng.xml'".  
4. 
Alternatively, run tests using Maven:
```sh
mvn test
```
Project Structure
```sh
📦 SauceDemoAutomation
 ├── 📂 src/
 │    ├── 📂 main/java/org/example/pages/  # Page Object Model (POM) classes
 │    ├── 📂 test/java/
 │    │    ├── 📂 Base/        # Base test setup
 │    │    ├── 📂 Constants/   # Constants used
 │    │    ├── 📂 tests/       # Test cases
 │    │    ├── testng.xml      # TestNG test suite configuration
 ├── 📂 screenshots/           # Screenshots captured on test failure
 ├── pom.xml                   # Maven dependencies
 ├── README.md                 # Project documentation
 ```
**Features**  
- Page Object Model (POM) implemented
- Configurable headless mode via Constants.java
- Screenshot capture on test failure
- Screenshot Capture on Test Failure: 
If a test fails, a screenshot is automatically saved in the /screenshots/ directory.