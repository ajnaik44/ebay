package com.ebay.calculator.ebay.operation;

import org.springframework.stereotype.Service;

import com.ebay.calculator.ebay.Operation;
import com.ebay.calculator.ebay.OperationService;

/**
 * Implementation of {@link OperationService} for subtraction.
 * <p>
 * This service performs subtraction of one double value from another.
 * </p>
 * 
 * @see Operation
 * @see OperationService
 */
@Service
public class SubtractOperation implements OperationService {

    /**
     * Returns the operation type for this service.
     * <p>
     * This implementation returns {@link Operation#SUBTRACT}, indicating that this service performs subtraction.
     * </p>
     * 
     * @return the operation type {@link Operation#SUBTRACT}
     */
    @Override
    public Operation getOperationType() {
        return Operation.SUBTRACT;
    }

    /**
     * Applies the subtraction operation to the given operands.
     * <p>
     * This method subtracts the second operand from the first operand.
     * </p>
     * 
     * @param a the value from which {@code b} is to be subtracted
     * @param b the value to be subtracted from {@code a}
     * @return the result of subtracting {@code b} from {@code a}
     */
    @Override
    public double apply(double a, double b) {
        return a - b;
    }
}
