package lyp.com.text.NetWork;

/**
 * Created by lyp on 2019/3/3.
 */

public class ProxyDemo {
    public static void main(String[] args) {
        new Proxy(new Real()).browse();		//有参构造，实例化代理，执行代理的方法。
    }

}
