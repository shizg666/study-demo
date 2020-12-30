package com.shizg.study.demo.muit.datasource.dynamic;
/**   
* @Title: ContextDatasourceTypeHolder 
* @Description: 当前处理的数据源类型Holder
* @author
* @date 2017/8/8 14:40
* @version V1.0   
*/

/**
 * JDK1.7开始引入
 * 对于实现AutoCloseable接口的类的实例，将其放到try后面（我们称之为：带资源的try语句），在try结束的时候，会自动将这些资源关闭（调用close方法）。
 *
 * 带资源的try语句的3个关键点：
 * 1、由带资源的try语句管理的资源必须是实现了AutoCloseable接口的类的对象。
 * 2、在try代码中声明的资源被隐式声明为fianl。
 * 3、通过使用分号分隔每个声明可以管理多个资源
 */
public class ContextDatasourceTypeHolder implements AutoCloseable{

    private static ThreadLocal<String> datasourceTypeHolder = new ThreadLocal<String>();

    /**
     * 甚至当前操作的数据源类型
     * @param dataSourceType
     * @author
     */
    public static void setDatasourceType(String dataSourceType) {
        datasourceTypeHolder.set(dataSourceType);
    }

    public ContextDatasourceTypeHolder(String key) {
        datasourceTypeHolder.set(key);
    }
    /**
     * 获取当前操作的数据源类型
     * @return
     * @author
     */
    public static String getDatasourceType() {
        return datasourceTypeHolder.get();
    }

    /**
     * 清除当前操作的数据源类型，使用默认的了
     * @author
     */
    public static void clearDatasourceType() {
        datasourceTypeHolder.remove();
    }

    @Override
    public void close() throws Exception {
        datasourceTypeHolder.remove();
    }
}
