package com.picsauditing.service.security.API;

public interface Subject {

    Object getSessionVariable(String key);

    void setSessionVariable(String key, Object value);

    String getUsername();

    Integer getUserID();

}
