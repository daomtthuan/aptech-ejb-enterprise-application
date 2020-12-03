package com.daomtthuan.chatnow.ejb.facade;

import com.daomtthuan.chatnow.ejb.entity.Account;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AccountFacadeLocal {

  Account create(Account account);

  void edit(Account account);

  void remove(Account account);

  Account find(Object id);

  List<Account> findAll();

  List<Account> findRange(int[] range);

  int count();

  Account findByUsername(final String username);

}
