package com.picsauditing.service.security.shiro

import com.picsauditing.service.security.API.{Configuration, Subject, SecurityContext}
import com.picsauditing.service.security.exception.LoginException
import org.apache.shiro.cache.CacheManager

class SecurityService(cacheProvider: CacheManager, config: Configuration) extends SecurityContext {


  def logout() = ???

  def getSubject: Option[Subject] = ???

  def login(username: String, password: String): Either[Subject, LoginException] = ???
}
