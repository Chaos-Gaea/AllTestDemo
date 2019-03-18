package lyp.com.text.IntentServiceTest;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import lyp.com.text.Inject.MainActivity;

/**
 * Created by lyp on 2019/3/4.
 */

public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

//    /*空参构造 系统创建的intentService 也要在清单文件中注册  系统默认调用的空参构造方法  否则启动不起来*/
//   /*通过this 或者super调用 父类的构造函数 */
    public MyIntentService() {
        this("MyIntentService");
    }

    /*用于处理这个线程的名称 */
    public MyIntentService(String name) {
        super(name);
    }

    /*回调方法  用来处理intent请求   这个方法是在子线程执行的*/
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("0000", "onHandleIntent: " + Thread.currentThread().getName());
        String url = intent.getStringExtra("url");
        Log.e("tag", "开始下载" + url);
        SystemClock.sleep(5000);
        Log.d("00000", "执行完任务了");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("tag", "onDestroy:");
    }
}
