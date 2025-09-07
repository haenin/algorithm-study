package com.haenin.chap03.section01.graph_search;

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

public class Application4Test {
    private static String input1, input2;
    private static String output1,output2;
    @BeforeAll
    public static void set() {

        /* 예시1 */
        input1 = "4 5 1\n" +
                "1 2\n" +
                "1 3\n" +
                "1 4\n" +
                "2 4\n" +
                "3 4";
        output1 = "1 2 4 3 \n" +
                "1 2 3 4 ";
        input2 = "7 6 1\n" +
                "1 2\n" +
                "2 3\n" +
                "1 5\n" +
                "5 2\n" +
                "5 6\n" +
                "3 4";
        output2 = "1 2 3 4 5 6 \n" +
                "1 2 5 3 6 4 ";

    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1),
                arguments(input2, output2)
        );
    }
    @DisplayName("BFSDFS")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void BFSDFStest(String input, String output) throws Exception {
        String result = Application4.solution(input);
        Assertions.assertEquals(output, result);
    }
}

