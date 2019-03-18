package lyp.com.text.Window;

/**
 * Created by lyp on 2019/3/3.
 */

public class AdapterDemo {
    public static void main(String[] args){
        /*调用父类接口 执行方法  其他方法没有结果*/

        Window window = new WindowRea();
        window.open();
        window.close();
        window.activited();
        System.out.println();
        window.iconfied();
        System.out.println();
        window.deiconfied();
    }
}
