package com.ai.ecs.dubbo.ta.imp;

import javax.transaction.InvalidTransactionException;
import javax.transaction.TransactionRequiredException;
import javax.transaction.TransactionRolledbackException;
import java.sql.Connection;

/**
 * Copyright asiainfo.com
 *
 * @author wuwh6
 */
public class LocalTransaction extends AbstractTransaction {

    private Connection currentConnection =null;

    public LocalTransaction(Connection connection){

    }
    @Override
    public void begin() throws InvalidTransactionException {

    }

    @Override
    public void commit() throws TransactionRequiredException {

    }

    @Override
    public void rollback() throws TransactionRolledbackException {

    }
}
