
package com.student;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {

    App calc = new App();

    @Test
    public void testAddition() {
        assertEquals(15, calc.add(10, 5));
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, calc.subtract(10, 5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(50, calc.multiply(10, 5));
    }
}
