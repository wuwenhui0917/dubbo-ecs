package com.ai.ecs.dubbo.ta;

/**
 * Copyright asiainfo.com
 *
 * @author wuwh6
 */
public enum TransactionType {
    LOCAL("DB"),XA("XA"),GT("GT"),TCC("TCC"),SAGA("SAGA");

    private String name;

    private TransactionType(String name){
        this.name = name;
    }


}
