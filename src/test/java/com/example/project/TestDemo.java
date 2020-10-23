package com.example.project;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.MAC;

/**
 * Created by hp on 5/10/2020.
 */
public class TestDemo {
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "0,    1,   0",
            "1,    2,   2",
            "02,  50, 100",
            "1,  100, 100",
            "1,  111, 111"
    })
    void multiply(Double first, Double second, Double expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.multiply(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @Test
    void exceptionTesting() {
        Calculator calculator = new Calculator();
//        Exception exception = assertThrows(ArithmeticException.class, () ->
//                calculator.divide(1, 0));
        assertEquals(Double.NEGATIVE_INFINITY, calculator.divide(-1, 0));
    }

    @TestFactory
    @DisabledOnOs({LINUX, MAC})
    public DynamicContainer dependentAssertions() {
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        Calculator calculator = new Calculator();
        calculator.firstName = "lala";
        calculator.lastName = "s3eed";
        Calculator calculator2 = new Calculator();
        calculator2.firstName = "llasai";
        calculator2.lastName = "atrash";
        List<Calculator> cals = new ArrayList();
        cals.add(calculator);
        cals.add(calculator2);
        assumeTrue(null == System.getenv("ENV"),
                () -> "Aborting test: not on developer workstation");
        assertEquals(2, cals.size());
        return DynamicContainer.dynamicContainer("cals",
                cals.stream().map(cal -> {
                    return DynamicTest.dynamicTest("dynamic test",
                            () -> {
                                System.out.println("hasan");
                                assertTrue(cal.firstName.startsWith("l"));
                            });

//                // Executed only if the previous assertion is valid.
//                assertAll("cal: " + (cals.indexOf(cal) + 1) + ", first name:" + cal.firstName,
//                        () -> assertTrue(cal.firstName.startsWith("l")),
//                        () -> assertTrue(cal.firstName.endsWith("a"))
//                );

                })
        );

//        assertAll("properties",
//                () -> {
//                    String firstName = "lala";
//                    assertNotNull(firstName);
//
//                    // Executed only if the previous assertion is valid.
//                    assertAll("first name",
//                            () -> assertTrue(firstName.startsWith("J")),
//                            () -> assertTrue(firstName.endsWith("e"))
//                    );
//                },
//                () -> {
//                    // Grouped assertion, so processed independently
//                    // of results of first name assertions.
//                    String lastName = "lole";
//                    assertNotNull(lastName);
//
//                    // Executed only if the previous assertion is valid.
//                    assertAll("last name",
//                            () -> assertTrue(lastName.startsWith("D")),
//                            () -> assertTrue(lastName.endsWith("e"))
//                    );
//                }
//        );
    }

}
