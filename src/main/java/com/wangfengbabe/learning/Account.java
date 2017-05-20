package com.wangfengbabe.learning;

/**
 * Created by wangfeng on 17/05/2017.
 */
public class Account {

  private String accountId;
  private long balance;

  public Account(String accountId, long balance) {
    this.accountId = accountId;
    this.balance = balance;
  }

  public void debit(long amount) {
    this.balance -= amount;
  }

  public void credit(long amount) {
    this.balance += amount;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public long getBalance() {
    return balance;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }
}
