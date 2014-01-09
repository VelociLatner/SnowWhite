package com.picsauditing.service.security.shiro

import com.typesafe.config.ConfigFactory
import java.io.File


class HOCONConfiguration(fileName: String) {

  private val config = ConfigFactory.parseFile(new File(fileName))

}
