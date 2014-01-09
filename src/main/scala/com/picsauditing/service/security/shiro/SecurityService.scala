package com.picsauditing.service.security.shiro

import com.picsauditing.service.security.API.{Subject, SecurityContext}
import com.picsauditing.service.security.exception.LoginException
import org.apache.shiro.SecurityUtils
import org.apache.shiro.mgt.SecurityManager
import org.apache.shiro.authc.UsernamePasswordToken

class SecurityService(service: SecurityManager) extends SecurityContext {

  SecurityUtils.setSecurityManager(service)

  def logout() = SecurityUtils.getSubject.logout()

  def getSubject: Option[Subject] = optional(wrapped(SecurityUtils.getSubject))

  def login(username: String, password: String): Either[LoginException, Subject] = {
    try {
      Right(
        wrapped(
          service.login(SecurityUtils.getSubject, new UsernamePasswordToken(username, password))
        )
    )} catch {
      case e: Throwable => Left(new LoginException(e))
    }
  }

  private def wrapped(s: org.apache.shiro.subject.Subject) = new WrappedSubject(s)
  private def optional[A](f: => A) = try { Some(f) } catch { case _: Throwable => None }
}
