package lyp.com.text.NetWork;

/**
 * Created by lyp on 2019/3/3.
 */

public class Proxy implements NetWork {

    private  NetWork netWork;

    public Proxy(NetWork netWork) {
        this.netWork = netWork;
    }

    public void Check(){
        System.out.println("代理检查用户是否合法");
    }

    @Override
    public void browse() {
        Check();
        netWork.browse();
    }
}
