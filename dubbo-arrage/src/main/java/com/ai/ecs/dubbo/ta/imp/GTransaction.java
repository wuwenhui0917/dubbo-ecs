package com.ai.ecs.dubbo.ta.imp;

import com.ai.ecs.dubbo.ta.Transaction;
import io.seata.core.exception.TransactionException;
import io.seata.rm.RMClient;
import io.seata.tm.TMClient;
import io.seata.tm.api.GlobalTransaction;
import io.seata.tm.api.GlobalTransactionContext;
import io.seata.tm.api.TransactionalTemplate;
import io.seata.tm.api.transaction.TransactionInfo;

import javax.transaction.InvalidTransactionException;
import javax.transaction.TransactionRequiredException;
import javax.transaction.TransactionRolledbackException;

/**
 * Copyright asiainfo.com
 *
 * @author wuwh6
 */
public class GTransaction extends AbstractTransaction {

    private String appId;
    private String txgroup;
    GlobalTransaction tx;
    TransactionInfo transactionInfo = new TransactionInfo();

    private final TransactionalTemplate transactionalTemplate = new TransactionalTemplate();

    public GTransaction(String appId,String txgroup){
       this.appId = appId;
       this.txgroup=txgroup;

    }


    @Override
    public void begin() throws InvalidTransactionException {
        TMClient.init(appId, txgroup);
        RMClient.init(appId, appId);
        tx= GlobalTransactionContext.getCurrentOrCreate();
        transactionInfo.setTimeOut(this.getTimeOut());
        transactionInfo.setName(this.getTransactionName());
        try {
            tx.begin(transactionInfo.getTimeOut(), transactionInfo.getName());
        } catch (TransactionException e) {

           new InvalidTransactionException("transaction："+this.getTransactionName()+" error");
        }
    }

    @Override
    public void commit() throws TransactionRequiredException {
        try {
            tx.commit();
        } catch (TransactionException e) {
            new TransactionRequiredException("事务提交失败");
        }

    }

    @Override
    public void rollback() throws TransactionRolledbackException {
        try {
            tx.rollback();
        } catch (TransactionException e) {
            new TransactionRolledbackException();
        }

    }
}
