package com.ebay.calculator.ebay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * The entry point for the Spring Boot application.
 * <p>
 * The {@link EbayApplication} class contains the {@code main} method that initializes the Spring
 * application context and demonstrates basic and chained calculations using the {@link Calculator} service.
 * </p>
 */
@SpringBootApplication
public class EbayApplication {

    /**
     * The main method that starts the Spring Boot application.
     * <p>
     * This method initializes the Spring application context, retrieves the {@link Calculator} bean,
     * and performs basic and chained calculations as examples. The results are printed to the console.
     * </p>
     * 
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EbayApplication.class, args);
        Calculator calculator = context.getBean(Calculator.class);

        // Basic calculation example
        double result = calculator.calculate(Operation.ADD, 2, 3);
        System.out.println("Basic Calculation (2 + 3): " + result);

        // Chaining operations: Start with 5, add 3, then multiply by 2
        double chainedResult = calculator.chain(5)
                                          .apply(Operation.ADD, 3)
                                          .apply(Operation.MULTIPLY, 2)
                                          .getResult();
                                          
        System.out.println("Chained Calculation (5 + 3) * 2: " + chainedResult);
    }
}
