package com.github.mgrzeszczak.cached.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class CachedConfiguration {

    @Bean
    public CachedAspect cachedAspect(StoreFactory storeFactory) {
        return new CachedAspect(storeFactory);
    }

    @Bean
    public StoreFactory storeFactory() {
        return new StoreFactory();
    }

}
