package com.wangfengbabe.learning;

/**
 * Created by wangfeng on 17/05/2017.
 */
public interface AccountManager {

  Account findAccountForUser(String userId);

  void updateAccount(Account account);

}
