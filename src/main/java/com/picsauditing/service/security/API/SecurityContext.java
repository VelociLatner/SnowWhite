package com.picsauditing.service.security.API;

import com.picsauditing.service.security.exception.LoginException;
import scala.Option;
import scala.util.Either;

public interface SecurityContext {

    Option<Subject> getSubject();

    Either<Subject, LoginException> login(String username, String password);
    void logout();
}
