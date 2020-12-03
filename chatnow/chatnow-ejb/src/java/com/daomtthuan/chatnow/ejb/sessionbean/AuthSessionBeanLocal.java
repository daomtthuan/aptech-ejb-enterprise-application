package com.daomtthuan.chatnow.ejb.sessionbean;

import com.daomtthuan.chatnow.ejb.entity.Account;
import javax.ejb.Local;

@Local
public interface AuthSessionBeanLocal {

  String login(final String username, final String password);

  String logount();

  Boolean isLoggedIn();

  Account getAccount();

  Boolean isAdmin();

}

