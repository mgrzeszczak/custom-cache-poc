package com.github.mgrzeszczak.cached.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@RequiredArgsConstructor
@Slf4j
class CachedAspect {

    private final StoreFactory storeFactory;

    private Map<String, Store> storeMap = new ConcurrentHashMap<>();

    @Around("@annotation(cached)")
    public Object around(ProceedingJoinPoint pjp, Cached cached) throws Throwable {
        MethodSignature methodSignature = ((MethodSignature) pjp.getSignature());
        String cacheName = createCacheName(methodSignature);
        Store store = storeMap.computeIfAbsent(cacheName, name -> storeFactory.create());
        Object[] key = pjp.getArgs();
        Value value = store.get(key);
        if (value != null && Instant.now().isBefore(value.getTimestamp().plusSeconds(cached.refreshSeconds()))) {
            log.info("cached");
            return value.getValue();
        } else {
            log.info("evaluated");
            Object result = pjp.proceed();
            store.put(key, result);
            return result;
        }
    }

    private String createCacheName(MethodSignature methodSignature) {
        String declaringClassName = methodSignature.getMethod().getDeclaringClass().getName();
        String methodName = methodSignature.getMethod().getName();
        return declaringClassName + "_" + methodName;
    }

}
