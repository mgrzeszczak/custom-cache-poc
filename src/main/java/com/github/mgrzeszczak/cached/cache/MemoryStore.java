package com.github.mgrzeszczak.cached.cache;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

class MemoryStore implements Store {

    private final ConcurrentHashMap<Key, Value> map = new ConcurrentHashMap<>();

    @Override
    public void put(Object[] key, Object value) {
        map.put(new Key(key), new Value(value, Instant.now()));
    }

    @Override
    public Value get(Object[] key) {
        return map.get(new Key(key));
    }

}
