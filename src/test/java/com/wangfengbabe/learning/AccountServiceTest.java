package com.wangfengbabe.learning;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by wangfeng on 17/05/2017.
 */
public class AccountServiceTest {

  @Test
  public void testTransferOk() {
    MockAccountManager mockAccountManager = new MockAccountManager();
    Account sender = new Account("1", 100);
    Account benificiary = new Account("2", 200);
    mockAccountManager.addAccount("1", sender);
    mockAccountManager.addAccount("2", benificiary);
    AccountService accountService = new AccountService();
    accountService.setAccountManager(mockAccountManager);
    accountService.transfer("2", "1", 50);
    assertEquals(150, sender.getBalance());
    assertEquals(150, benificiary.getBalance());
  }

}