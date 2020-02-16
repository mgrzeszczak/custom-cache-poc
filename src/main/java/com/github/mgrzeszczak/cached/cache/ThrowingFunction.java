package com.github.mgrzeszczak.cached.cache;

@FunctionalInterface
public interface ThrowingFunction<A,B> {

    B compute(A a) throws Throwable;

}
