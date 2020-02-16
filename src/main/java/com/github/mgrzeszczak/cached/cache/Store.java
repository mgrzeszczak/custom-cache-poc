package com.github.mgrzeszczak.cached.cache;

interface Store {

    void put(Object[] key, Object value);

    Value get(Object[] key);

}
