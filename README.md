
# eBay Calculator

## Overview

The eBay Calculator is a Java-based application that performs various mathematical operations, including addition, subtraction, multiplication, and division. It uses Spring Boot for dependency injection and provides both basic and chained calculation functionalities.

## Features

- **Basic Calculation**: Perform basic operations such as addition, subtraction, multiplication, and division.
- **Chained Calculation**: Allows chaining multiple operations in a single calculation process.
- **Custom Operations**: Easily extendable to include additional operations.

## Requirements

- Java 17 or later
- Maven

## Setup

### Clone the Repository

```bash
git clone https://github.com/ajnaik44/ebay/
cd ebay
```

### Build the Project

Ensure you have Maven installed. Run the following command to build the project:

```bash
mvn clean install
```

### Run the Application

You can run the application using the Maven wrapper script:

```bash
./mvnw spring-boot:run
```

Alternatively, you can use the following command if Maven is installed:

```bash
mvn spring-boot:run
```

## Usage

### Basic Calculation

The `Calculator` class provides a method to perform basic calculations:

```java
double result = calculator.calculate(Operation.ADD, 2, 3);
System.out.println("Basic Calculation (2 + 3): " + result);
```

### Chained Calculation

You can chain operations as follows:

```java
double chainedResult = calculator.chain(5)
                                  .apply(Operation.ADD, 3)
                                  .apply(Operation.MULTIPLY, 2)
                                  .getResult();
System.out.println("Chained Calculation (5 + 3) * 2: " + chainedResult);
```

## Project Structure

- **`src/main/java/com/ebay/calculator/ebay`**: Contains the main application classes and configuration.
  - `EbayApplication.java`: Entry point of the Spring Boot application.
  - `Calculator.java`: Main calculator logic and chaining functionality.
  - `Operation.java`: Enum representing available operations.
  - `OperationService.java`: Interface for operation services.
- **`src/main/java/com/ebay/calculator/ebay/operation`**: Contains implementations of various operations.
  - `AddOperation.java`
  - `SubtractOperation.java`
  - `MultiplyOperation.java`
  - `DivideOperation.java`
- **`src/test/java/com/ebay/calculator/ebay`**: Contains unit tests for the application.

## Contributing

Feel free to fork the repository and submit pull requests for improvements or new features.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any questions or inquiries, please contact:

- **Name**: Ajay Naik
- **Email**: [your-email@example.com](mailto:your-email@example.com)

---

You can adjust the contact information, project details, and any other sections as needed.
