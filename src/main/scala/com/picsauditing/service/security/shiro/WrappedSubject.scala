package com.picsauditing.service.security.shiro

import com.picsauditing.service.security.API.Subject
import org.apache.shiro.subject.{Subject => ShiroSubject}

class WrappedSubject(subject: ShiroSubject) extends Subject {

}
