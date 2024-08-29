package com.ebay.calculator.ebay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EbayApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
    private Calculator calculator;

    @Test
    public void testBasicOperations() {
        assertEquals(5, calculator.calculate(Operation.ADD, 2, 3));
        assertEquals(1, calculator.calculate(Operation.SUBTRACT, 3, 2));
        assertEquals(6, calculator.calculate(Operation.MULTIPLY, 2, 3));
        assertEquals(2, calculator.calculate(Operation.DIVIDE, 6, 3));
    }

    @Test
    public void testChainingOperations() {
        double result = calculator.chain(5)
                                  .apply(Operation.ADD, 3)
                                  .apply(Operation.MULTIPLY, 2)
                                  .getResult();
        assertEquals(16, result);
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 5, 0);
        });
    }

    @Test
    public void testUnsupportedOperation() {
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(null, 5, 3);  // Example of an unsupported operation
        });
    }
    
}
