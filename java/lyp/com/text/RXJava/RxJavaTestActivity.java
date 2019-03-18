package lyp.com.text.RXJava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lyp.com.text.R;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lyp on 2019/3/6.
 */

public class RxJavaTestActivity extends AppCompatActivity{

    private static final String TAG = "RxJavaTestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava_activity);

        //采用interval() 延迟发送
        /*参1 第一次延迟时间 参2 时间间隔  参3 时间单位*/
//        io.reactivex.Observable.interval(2,1, TimeUnit.SECONDS)
//
//                .doOnNext(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long integer) throws Exception {
//                        Log.e("tag","第"+integer+"次轮询" );
//
//                    }
//                }).subscribe(new Observer<Long>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Long value) {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "onError: "+"对error向供应");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e(TAG, "onComplete: "+"对complete响应" );
//            }
//        });


        Retrofit mRetrofit = new Retrofit.Builder()
                //设置网络请求url
                .baseUrl("http://fy.iciba.com")
                //使用GSon解析
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //创建网络请求的实例
        GetRequest_Intetface mGetRequest_intetface = mRetrofit.create(GetRequest_Intetface.class);

        //Obsetvable<> 进行网络请求封装
        io.reactivex.Observable<Translation> call = mGetRequest_intetface.getCall();

        //进行网络请求
        call.subscribeOn(Schedulers.io())//在IO线程中请求网络
                .observeOn(AndroidSchedulers.mainThread())  //回到主线程 处理请求结果
                .subscribe(new Observer<Translation>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("tag", "onSubscribe: "+"开始采用subscribe链接" );
                    }

                    @Override
                    public void onNext(Translation value) {
                        value.show();
                        System.out.println( value.toString());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tag", "onError: "+"请求失败");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("tag", "onComplete: "+"请求完成" );
                    }
                });


    }



}
