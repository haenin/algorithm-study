package com.haenin.chap06.section01.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Application5Test {
    private static String input1;
    private static Integer output1;
    private static String input2;
    private static Integer output2;

    @BeforeAll
    public static void set() {

        /* 예시1 */
        input1 = "6\n" +
                "10\n" +
                "20\n" +
                "15\n" +
                "25\n" +
                "10\n" +
                "20";
        output1 = 75;

        /* 예시2 */
        input2 = "4\n" +
                "30\n" +
                "10\n" +
                "20\n" +
                "40";
        output2 = 90;
    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2)
        );
    }
    @DisplayName("dp5")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void dp5test(String input, Integer output) throws Exception {
        Integer result = Application5.solution(input);
        Assertions.assertEquals(output, result);
    }
}

