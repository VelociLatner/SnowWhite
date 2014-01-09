package com.picsauditing.service.security.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

public class CacheProvider implements CacheManager {

    private HazelcastInstance instance = Hazelcast.newHazelcastInstance();

    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return new HazelCastCache<K, V>(instance.getMap(name));
    }

}
