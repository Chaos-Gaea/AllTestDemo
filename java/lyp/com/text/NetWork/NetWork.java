package lyp.com.text.NetWork;

/**
 * Created by lyp on 2019/3/3.
 */

public interface NetWork {
    //用户只关心上网，代理处理如何上网，
    //定义一个上网接口，用户和代理都实现该接口，分别做自己要做的事情，
    void browse();
}
