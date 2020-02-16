package com.github.mgrzeszczak.cached.cache;

import lombok.Value;

import java.util.Arrays;

@Value
public class Key {

    private final Object[] args;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return Arrays.equals(args, key.args);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(args);
    }
}
