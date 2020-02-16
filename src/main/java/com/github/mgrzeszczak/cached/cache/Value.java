package com.github.mgrzeszczak.cached.cache;

import java.time.Instant;

@lombok.Value
public class Value {

    private final Object value;
    private final Instant timestamp;

}
