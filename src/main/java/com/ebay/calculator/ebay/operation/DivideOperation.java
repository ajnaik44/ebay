package com.ebay.calculator.ebay.operation;

import org.springframework.stereotype.Service;

import com.ebay.calculator.ebay.Operation;
import com.ebay.calculator.ebay.OperationService;

/**
 * Implementation of {@link OperationService} for division.
 * <p>
 * This service performs division of two double values. It handles the case where the divisor is zero
 * by throwing an {@link IllegalArgumentException}.
 * </p>
 * 
 * @see Operation
 * @see OperationService
 */
@Service
public class DivideOperation implements OperationService {

    /**
     * Returns the operation type for this service.
     * <p>
     * This implementation returns {@link Operation#DIVIDE}, indicating that this service performs division.
     * </p>
     * 
     * @return the operation type {@link Operation#DIVIDE}
     */
    @Override
    public Operation getOperationType() {
        return Operation.DIVIDE;
    }

    /**
     * Applies the division operation to the given operands.
     * <p>
     * This method divides the first operand by the second operand. If the second operand is zero,
     * an {@link IllegalArgumentException} is thrown to prevent division by zero.
     * </p>
     * 
     * @param a the dividend
     * @param b the divisor
     * @return the result of dividing {@code a} by {@code b}
     * @throws IllegalArgumentException if {@code b} is zero
     */
    @Override
    public double apply(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
