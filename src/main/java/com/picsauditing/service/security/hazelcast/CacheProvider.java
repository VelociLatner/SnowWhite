package com.picsauditing.service.security.hazelcast;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

public class CacheProvider implements CacheManager {

    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return new HazelCastCache<K, V>(name);
    }

}
