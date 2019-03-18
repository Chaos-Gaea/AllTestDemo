package lyp.com.text.Window;

/**
 * Created by lyp on 2019/3/3.
 */

public class WindowRea extends WindowAdapter {
    //实例体继承抽象类 重写需要的方法

    @Override
    public void open() {
        System.out.println("窗户打开");
    }

    @Override
    public void close() {
        System.out.println("窗户关闭");
    }
}
