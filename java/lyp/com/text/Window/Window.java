package lyp.com.text.Window;

/**
 * Created by lyp on 2019/3/3.
 */

public interface Window {
    /*适配器模式
    * 主接口有太多的方法 如果直接实现 必须覆写全部的方法 如果只想操作其中几个
    * 就需要适配器进行适配*/
    void open();
    void close();
    void activited();
    void iconfied();
    void deiconfied();

}
