package com.ai.ecs.dubbo.ta.imp;

import com.ai.ecs.dubbo.ta.Transaction;

/**
 * Copyright asiainfo.com
 *
 * @author wuwh6
 */
public abstract class AbstractTransaction implements Transaction {

    @Override
    public int getTimeOut() {
        return 60000;
    }

    @Override
    public String getTransactionName() {
        return "transaction"+Thread.currentThread().getId();
    }
}
