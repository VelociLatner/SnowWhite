package com.picsauditing.service.security.shiro

import com.picsauditing.service.security.API.SecurityContext
import com.picsauditing.service.security.exception.LoginException
import org.apache.shiro.SecurityUtils
import org.apache.shiro.mgt.{DefaultSecurityManager, SecurityManager}
import org.apache.shiro.authc.UsernamePasswordToken
import javax.sql.DataSource
import com.picsauditing.service.security.hazelcast.CacheProvider
import com.picsauditing.service.security.shiro.implementation.{Realm, CredentialsMatcher}

class SecurityService(service: SecurityManager) extends SecurityContext {

  SecurityUtils.setSecurityManager(service)

  def logout() = SecurityUtils.getSubject.logout()

  def setSessionVariable(key: String, value: scala.Any) = SecurityUtils.getSubject.getSession.setAttribute(key, value)

  def getSessionVariable(key: String): AnyRef = SecurityUtils.getSubject.getSession.getAttribute(key)

  def getUsername: String = ???

  def getUserID: Integer = ???

  def login(username: String, password: String) = try {
    service.login(SecurityUtils.getSubject, new UsernamePasswordToken(username, password))
  } catch {
    case e: Throwable => throw new LoginException(e)
  }

  def touchSession() = SecurityUtils.getSubject.getSession.touch()

  def isLoggedIn: Boolean = SecurityUtils.getSubject.isAuthenticated

}

class ConfiguredSecurityService(db: DataSource, authenticationCacheName: String, authorizationCacheName: String) extends SecurityService(
  {
    val cacheManager = new CacheProvider
    val credentialMatcher = new CredentialsMatcher
    val realm = new Realm( cacheManager,  credentialMatcher,  db,  authorizationCacheName,  authenticationCacheName )
    new DefaultSecurityManager(realm)
  }
)

