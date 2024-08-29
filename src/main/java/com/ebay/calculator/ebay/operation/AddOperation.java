package com.ebay.calculator.ebay.operation;

import org.springframework.stereotype.Service;

import com.ebay.calculator.ebay.Operation;
import com.ebay.calculator.ebay.OperationService;

/**
 * Implementation of {@link OperationService} for addition.
 * <p>
 * This service performs addition of two double values.
 * </p>
 * 
 * @see Operation
 * @see OperationService
 */
@Service
public class AddOperation implements OperationService {

    /**
     * Returns the operation type for this service.
     * <p>
     * This implementation returns {@link Operation#ADD}, indicating that this service performs addition.
     * </p>
     * 
     * @return the operation type {@link Operation#ADD}
     */
    @Override
    public Operation getOperationType() {
        return Operation.ADD;
    }

    /**
     * Applies the addition operation to the given operands.
     * <p>
     * This method adds the two provided double values and returns the result.
     * </p>
     * 
     * @param a the first operand
     * @param b the second operand
     * @return the result of adding {@code a} and {@code b}
     */
    @Override
    public double apply(double a, double b) {
        return a + b;
    }
}
