package com.wangfengbabe.learning;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangfeng on 17/05/2017.
 */
public class MockAccountManager implements AccountManager {

  private Map<String, Account> accounts = new HashMap<String, Account>();

  public void addAccount(String userId, Account account) {
    this.accounts.put(userId, account);

  }

  @Override
  public Account findAccountForUser(String userId) {
    return this.accounts.get(userId);
  }

  @Override
  public void updateAccount(Account account) {
    //TODO
  }
}
