package com.ebay.calculator.ebay.operation;

import org.springframework.stereotype.Service;

import com.ebay.calculator.ebay.Operation;
import com.ebay.calculator.ebay.OperationService;

/**
 * Implementation of {@link OperationService} for multiplication.
 * <p>
 * This service performs multiplication of two double values.
 * </p>
 * 
 * @see Operation
 * @see OperationService
 */
@Service
public class MultiplyOperation implements OperationService {

    /**
     * Returns the operation type for this service.
     * <p>
     * This implementation returns {@link Operation#MULTIPLY}, indicating that this service performs multiplication.
     * </p>
     * 
     * @return the operation type {@link Operation#MULTIPLY}
     */
    @Override
    public Operation getOperationType() {
        return Operation.MULTIPLY;
    }

    /**
     * Applies the multiplication operation to the given operands.
     * <p>
     * This method multiplies the first operand by the second operand.
     * </p>
     * 
     * @param a the first operand
     * @param b the second operand
     * @return the result of multiplying {@code a} by {@code b}
     */
    @Override
    public double apply(double a, double b) {
        return a * b;
    }
}
