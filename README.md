# AllTestDemo
复习测试演示 
其中包括：回调，自定义注解,intentService,工厂模式，观察者模式，代理模式，适配器模式,单利模式,OpenGL，viewUtils,Rxjava,StaticTest是一个经典案例
# CallBackTest
回调
# Incentence
工厂模式
# Inject
自定义注解
# IntentServiceTest
自定义MyIntentService类继承IntentService 
	
	public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

    	/*空参构造 系统创建的intentService 也要在清单文件中注册  系统默认调用的空参构造方法  否则启动不起来*/
   		/*通过this 或者super调用 父类的构造函数 */
   
	 
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
	
测试类
	
	public class IntentServiceActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_service);

        Intent service = new Intent(this,MyIntentService.class);

        service.putExtra("url","http://www.github.com");
        startService(service);
    }
	}
# NetWork
代理模式
# Observable
观察者模式
# OpenGl OpenGLANgle
图片渲染 3D模型
# Rxjava
响应式编程 解耦
# Singleton
单利模式
# View
自定义view
# Window
适配器模式

# StaticTest
经典题   常量 静态变量 静态方法  静态代码块 加载顺序 
	public class StaticTest {

    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
}



