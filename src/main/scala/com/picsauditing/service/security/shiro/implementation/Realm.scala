package com.picsauditing.service.security.shiro.implementation

import org.apache.shiro.realm.jdbc.JdbcRealm
import javax.sql.DataSource
import org.apache.shiro.authc.credential.{CredentialsMatcher => ShiroCredMatcher}
import org.apache.shiro.cache.CacheManager

class Realm(

             cacheManager: CacheManager,
             credentialMatcher: ShiroCredMatcher,
             db: DataSource,
             authorizeCacheName: String = "dev-auth-ize-cache",
             authenticateCacheName: String = "dev-auth-ent-cache"

               ) extends JdbcRealm {

  setDataSource(db)
  setSaltStyle(JdbcRealm.SaltStyle.COLUMN)

  setCredentialsMatcher(credentialMatcher)
  setCacheManager(cacheManager)

  setAuthorizationCacheName(authorizeCacheName)
  setAuthorizationCachingEnabled(true)
  setAuthenticationCacheName(authenticateCacheName)
  setAuthenticationCachingEnabled(true)

}
