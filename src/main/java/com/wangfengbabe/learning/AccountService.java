package com.wangfengbabe.learning;

/**
 * Created by wangfeng on 17/05/2017.
 */
public class AccountService {

  private AccountManager accountManager;

  public void transfer(String senderId, String benificiaryId, long amount) {
    Account sender = this.accountManager.findAccountForUser(senderId);
    Account benificiary = this.accountManager.findAccountForUser(benificiaryId);
    sender.debit(amount);
    benificiary.credit(amount);
    this.accountManager.updateAccount(sender);
    this.accountManager.updateAccount(benificiary);

  }

  public AccountManager getAccountManager() {
    return accountManager;
  }

  public void setAccountManager(AccountManager accountManager) {
    this.accountManager = accountManager;
  }
}
