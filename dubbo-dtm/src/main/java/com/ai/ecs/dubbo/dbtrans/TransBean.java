package com.ai.ecs.dubbo.dbtrans;

/**
 * Created by wuwenhui on 2018/6/28.
 * since
 * 事务对象
 * @version 1.0
 */
public class TransBean<T> {

    private String transId;
    private T transData;
    private String transMoudle;
    private String createDate;
    private String serverName;

}
