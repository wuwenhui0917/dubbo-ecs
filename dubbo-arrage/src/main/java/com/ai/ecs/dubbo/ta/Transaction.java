package com.ai.ecs.dubbo.ta;

import javax.transaction.InvalidTransactionException;
import javax.transaction.TransactionRequiredException;
import javax.transaction.TransactionRolledbackException;

/**
 * Copyright asiainfo.com
 * 事务抽象
 * @author wuwh6
 */
public interface Transaction  {

    /**
     *
     * @throws InvalidTransactionException
     */
    void begin() throws InvalidTransactionException;

    /**
     *
     * @throws TransactionRequiredException
     */
    void commit() throws TransactionRequiredException;

    /**
     *
     * @throws TransactionRolledbackException
     */
    void rollback() throws TransactionRolledbackException;

    /**
     * 事务超时时间
      * @return
     */
    int getTimeOut();

    /**
     * 获取事务名称
     * @return
     */
    String getTransactionName();
}
