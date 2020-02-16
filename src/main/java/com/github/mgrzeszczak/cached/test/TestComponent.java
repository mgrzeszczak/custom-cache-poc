package com.github.mgrzeszczak.cached.test;

import com.github.mgrzeszczak.cached.cache.Cached;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {

    @Cached(refreshSeconds = 10)
    @SneakyThrows
    public int test() {
        Thread.sleep(1000L);
        return 1;
    }

}
