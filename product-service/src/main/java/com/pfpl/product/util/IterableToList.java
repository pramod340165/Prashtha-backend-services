package com.pfpl.product.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IterableToList {
    public static <T> List<T> convertIterableToListUsingStreams(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                            .collect(Collectors.toList());
    }
}
