package com.ebay.calculator.ebay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

/**
 * A service class that performs calculations based on various operations.
 * <p>
 * The {@link Calculator} class provides methods to perform basic calculations using different
 * operations and supports chaining of operations.
 * </p>
 */
@Service
public class Calculator {
    private final Map<Operation, OperationService> operationServiceMap = new HashMap<>();

    /**
     * Constructs a {@link Calculator} with a list of {@link OperationService} implementations.
     * <p>
     * The provided services are mapped to their respective {@link Operation} types for later use in
     * performing calculations.
     * </p>
     * 
     * @param operationServices a list of {@link OperationService} implementations
     */
    public Calculator(List<OperationService> operationServices) {
        for (OperationService service : operationServices) {
            operationServiceMap.put(service.getOperationType(), service);
        }
    }

    /**
     * Performs a calculation based on the specified operation and operands.
     * <p>
     * This method retrieves the appropriate {@link OperationService} for the given operation type
     * and applies it to the provided operands.
     * </p>
     * 
     * @param op the {@link Operation} to be performed
     * @param num1 the first operand
     * @param num2 the second operand
     * @return the result of the calculation
     * @throws UnsupportedOperationException if the operation is not supported
     */
    public double calculate(Operation op, double num1, double num2) {
        OperationService operationService = operationServiceMap.get(op);
        if (Objects.isNull(op)) {
            throw new UnsupportedOperationException("Operation not supported: " + op);
        }
        return operationService.apply(num1, num2);
    }

    /**
     * Creates a {@link ChainedCalculator} instance for chaining operations.
     * <p>
     * This method allows the chaining of multiple calculations by providing an initial value and
     * applying a series of operations to it.
     * </p>
     * 
     * @param initialValue the initial value to start chaining operations
     * @return a new {@link ChainedCalculator} instance
     */
    public ChainedCalculator chain(double initialValue) {
        return new ChainedCalculator(initialValue, this);
    }

    /**
     * A helper class for chaining operations in a calculation process.
     * <p>
     * The {@link ChainedCalculator} class enables the sequential application of operations to
     * an initial value, allowing for complex calculations to be expressed fluently.
     * </p>
     */
    public static class ChainedCalculator {
        private double value;
        private final Calculator calculator;

        /**
         * Constructs a {@link ChainedCalculator} with an initial value and a {@link Calculator}.
         * 
         * @param initialValue the initial value for the chained calculations
         * @param calculator the {@link Calculator} instance used for performing operations
         */
        public ChainedCalculator(double initialValue, Calculator calculator) {
            this.value = initialValue;
            this.calculator = calculator;
        }

        /**
         * Applies an operation to the current value in the chain.
         * <p>
         * This method performs the specified operation with the current value and the provided number,
         * updating the current value in the chain.
         * </p>
         * 
         * @param operation the {@link Operation} to apply
         * @param num the operand for the operation
         * @return the current {@link ChainedCalculator} instance for further chaining
         */
        public ChainedCalculator apply(Operation operation, double num) {
            this.value = this.calculator.calculate(operation, this.value, num);
            return this;
        }

        /**
         * Retrieves the result of the chained calculations.
         * 
         * @return the final result after all chained operations have been applied
         */
        public double getResult() {
            return this.value;
        }
    }
}
