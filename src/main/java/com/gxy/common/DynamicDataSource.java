package com.gxy.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    /** mysql数据库标识 */
    public static final String mysqlDataSource = "mysqlDataSource";
    /** oracle数据库标识 */
    public static final String oracleDataSource = "oracleDataSource";
    /** postgresql数据库标识 */
    public static final String postgresqlDataSource = "postgresqlDataSource";
    /** sqlserver数据库标识 */
    public static final String sqlserverDataSource = "sqlserverDataSource";
    /** 当前线程的上下文 */
    public static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 设置数据源类型
     *
     * @param customerBDType 用户数据类型
     */
    public static void setCustomerDBType(String customerBDType) {
        contextHolder.set(customerBDType);
    }

    /**
     * 获取数据源类型
     *
     * @return
     */
    public static String getCustomerDBType() {
        return contextHolder.get();
    }

    /**
     * 移除数据源类型
     */
    public static void clearCustomerDBType() {
        contextHolder.remove();
    }

    protected Object determineCurrentLookupKey() {
        return getCustomerDBType();
    }
}
