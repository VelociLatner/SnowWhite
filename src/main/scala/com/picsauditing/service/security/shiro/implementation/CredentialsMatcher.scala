package com.picsauditing.service.security.shiro.implementation

import org.apache.shiro.authc.credential.{HashedCredentialsMatcher => ShiroMatcher}
import org.apache.shiro.crypto.hash.Sha1Hash

class CredentialsMatcher extends ShiroMatcher {
  setHashAlgorithmName(Sha1Hash.ALGORITHM_NAME)
}
