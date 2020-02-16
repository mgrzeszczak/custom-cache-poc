package com.github.mgrzeszczak.cached.cache;

class StoreFactory {

    public Store create() {
        return new MemoryStore();
    }

}
