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

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Application5Test {

    private static int size1 = 6;
    private static int exp1 = 4;
    private static int size2 = 8;
    private static int exp2 = 92;

    public Application5Test() {
    }

    public static Stream<Arguments> provideSizeSource() {
        return Stream.of(
                arguments(size1, exp1),
                arguments(size2, exp2)
        );
    }

    @DisplayName("N-Queens 문제 테스트")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSizeSource")
    public void chessTests(int size, int exp) {
        int actual = Application5.solution(size);
        Assertions.assertEquals(exp, actual);
    }
}
