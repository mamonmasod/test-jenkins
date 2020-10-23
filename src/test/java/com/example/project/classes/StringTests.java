package com.example.project.classes;

import com.example.project.interfaces.ComparableContract;
import com.example.project.interfaces.EqualsContract;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by hp on 5/11/2020.
 */

class StringTests implements ComparableContract<String>, EqualsContract<String> {

    @TestFactory
    public List<DynamicTest> dynamicTestsWithInvalidReturnType() {
        return Arrays.asList(DynamicTest.dynamicTest("hasan", () -> assertEquals(true, true)));
    }

    @Override
    public String createValue() {
        return "banana";
    }

    @Override
    public String createSmallerValue() {
        return "apple"; // 'a' < 'b' in "banana"
    }

    @Override
    public String createNotEqualValue() {
        return "cherry";
    }

}
