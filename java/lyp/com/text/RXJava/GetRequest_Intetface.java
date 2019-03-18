package lyp.com.text.RXJava;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lyp on 2019/3/6.
 */

public interface GetRequest_Intetface {
    //通过注解+ Obsetvable<> 的方式实现
    /*注入里传入部分url地址
    * Retrofit把网络请求分成两部分 一部分放在对象里 一部分放在接口里
    * 如果接口里的url是完整的地址 那么对象里的地址可以忽略
    * 采用Observalse<> 接口
    * getCall是接受网络请求的数据方式*/
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20world")
    Observable<Translation> getCall();

}
