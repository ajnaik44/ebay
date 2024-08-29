package com.ebay.calculator.ebay;

/**
 * Interface for performing mathematical operations.
 * <p>
 * The {@code OperationService} interface defines the contract for implementing different mathematical
 * operations. Each operation should provide a way to apply itself to two numeric values and should
 * be associated with a specific {@link Operation} type.
 * </p>
 */
public interface OperationService {

    /**
     * Returns the type of operation this service performs.
     *
     * @return the {@link Operation} type of this service
     */
    Operation getOperationType();

    /**
     * Applies the operation to the given operands.
     *
     * @param a the first operand
     * @param b the second operand
     * @return the result of applying the operation to the operands
     */
    double apply(double a, double b);
}
