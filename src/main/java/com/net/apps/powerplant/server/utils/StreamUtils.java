package com.net.apps.powerplant.server.utils;


import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamUtils {
    public static <T> Stream<T> stream(final Collection<T> col) {
        return Optional.ofNullable(col).map(Collection::stream).orElse(emptyStream());
    }

    public static <T> Stream<T> stream(final T[] array) {
        return Optional.ofNullable(array).map(Arrays::stream).orElse(emptyStream());
    }

    public static <T> Stream<T> emptyStream() {
        return Stream.of();
    }
}