package com.picsauditing.service.security.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.IMap;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import java.util.Collection;
import java.util.Set;

public class HazelCastCache<K, V> implements Cache<K, V> {

    final private IMap<K, V> map;

    public HazelCastCache(String name) {
        map = Hazelcast.newHazelcastInstance().getMap(name);
    }

    public V get(K key) throws CacheException { return map.get(key); }

    public V put(K key, V value) throws CacheException {
        map.put(key, value);
        return value;
    }

    public V remove(K key) throws CacheException {
        V value = map.get(key);
        map.remove(key);
        return value;
    }

    public void clear() throws CacheException {
        map.clear();
    }

    public int size() {
        return map.size();
    }

    public Set<K> keys() {
        return map.keySet();
    }

    public Collection<V> values() {
        return map.values();
    }
}
