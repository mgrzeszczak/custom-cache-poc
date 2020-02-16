package com.github.mgrzeszczak.cached.test;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class Initializer {

    private final TestComponent testComponent;

    @PostConstruct
    @SneakyThrows
    public void postConstruct() {
        testComponent.test();
        testComponent.test();
        Thread.sleep(10_000L);
        testComponent.test();
        testComponent.test();
        testComponent.test();
    }

}
