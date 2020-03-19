package com.ai.ecs.dubbo.ta.imp;

import javax.transaction.InvalidTransactionException;
import javax.transaction.TransactionRequiredException;
import javax.transaction.TransactionRolledbackException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Copyright asiainfo.com
 *
 * @author wuwh6
 */
public class LocalTransaction extends AbstractTransaction {

    private Connection currentConnection =null;

    public LocalTransaction(Connection connection){
        this.currentConnection = connection;

    }
    @Override
    public void begin() throws InvalidTransactionException {
        if(this.currentConnection!=null){
            try {
                currentConnection.setAutoCommit(false);
            } catch (SQLException e) {
                throw new InvalidTransactionException();
            }
        }
    }

    @Override
    public void commit() throws TransactionRequiredException {
        if(this.currentConnection!=null){
            try {
                currentConnection.commit();
            } catch (SQLException e) {
                throw new TransactionRequiredException();
            }
        }

    }

    @Override
    public void rollback() throws TransactionRolledbackException {
        if(this.currentConnection!=null){
            try {
                this.currentConnection.rollback();
            } catch (SQLException e) {
                throw new TransactionRolledbackException();
            }
        }
    }
}
