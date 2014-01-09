package com.picsauditing.service.security.shiro

import com.picsauditing.service.security.API.Subject
import org.apache.shiro.subject.{Subject => ShiroSubject}

class WrappedSubject(subject: ShiroSubject) extends Subject {

  def setSessionVariable(key: String, value: scala.Any) = subject.getSession.setAttribute(key, value)

  def getSessionVariable(key: String): AnyRef = subject.getSession.getAttribute(key)

  def getUsername: String = ???

  def getUserID: Integer = ???
}
