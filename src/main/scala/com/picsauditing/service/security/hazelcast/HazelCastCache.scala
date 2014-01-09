package com.picsauditing.service.security.hazelcast

import org.apache.shiro.cache.Cache
import java.util

class HazelCastCache[K, V] extends Cache[K, V] {

  def clear() = ???

  def get(key: K): V = ???

  def put(key: K, value: V): V = ???

  def remove(key: K): V = ???

  def size(): Int = ???

  def keys(): util.Set[K] = ???

  def values(): util.Collection[V] = ???

}
