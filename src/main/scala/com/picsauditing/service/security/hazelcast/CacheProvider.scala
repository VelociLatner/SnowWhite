package com.picsauditing.service.security.hazelcast

import org.apache.shiro.cache.{Cache, CacheManager}

class CacheProvider extends CacheManager {

  def getCache[K, V](name: String): Cache[K, V] = ???

}
