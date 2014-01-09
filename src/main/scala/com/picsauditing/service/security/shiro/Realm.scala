package com.picsauditing.service.security.shiro

import org.apache.shiro.realm.jdbc.JdbcRealm
import javax.sql.DataSource
import org.apache.shiro.authc.credential.CredentialsMatcher
import org.apache.shiro.cache.CacheManager

class Realm(cacheManager: CacheManager, credentialMatcher: CredentialsMatcher, db: DataSource) extends JdbcRealm {
  setDataSource(db)
  setCredentialsMatcher(credentialMatcher)
  setCacheManager(cacheManager)
}
