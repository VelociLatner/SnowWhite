package com.picsauditing.service.security.shiro.implementation

import org.apache.shiro.authc.credential.{CredentialsMatcher => ShiroMatcher}
import org.apache.shiro.authc.{AuthenticationInfo, AuthenticationToken}

class CredentialsMatcher extends ShiroMatcher {
  def doCredentialsMatch(token: AuthenticationToken, info: AuthenticationInfo): Boolean = {

  }
}
