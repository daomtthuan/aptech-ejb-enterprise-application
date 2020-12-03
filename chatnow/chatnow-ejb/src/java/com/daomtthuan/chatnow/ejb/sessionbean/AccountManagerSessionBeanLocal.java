package com.daomtthuan.chatnow.ejb.sessionbean;

import com.daomtthuan.chatnow.ejb.entity.Account;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AccountManagerSessionBeanLocal {

  List<Account> select();

  Account select(Long id);

  String create(final String username, final String password, final String name);

  String edit(final Long id, String name, Boolean status);

  String remove(Long id);

}

