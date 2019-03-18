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

# HashMap排序

    public class HashMapSort {
    public static void main(String args[]) {
        HashMap<Integer, User> hashMap = new HashMap<>();

        User user = new User();
        user.setName("张三");
        user.setAge(21);

        hashMap.put(1, user);

        User user2 = new User();
        user2.setName("李四");
        user2.setAge(24);

        hashMap.put(2, user2);

        User user3 = new User();
        user3.setName("王五");
        user3.setAge(23);

        hashMap.put(3, user3);

        System.out.println("排序前" + hashMap);
        HashMap<Integer, User> sortHashMap = sortHashMap(hashMap);
        System.out.println("排序后" + sortHashMap);
    }

    //根据hashmap中user的age属性的倒序排序 并保持 key_value 结构
    private static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> hashMap) {
        //通过hashmap的有序子类 来进行排序  linkedHashMap 是链表的有序结构
        //创建一个有序的hashmap的数据结构
        LinkedHashMap<Integer, User> newHashMap = new LinkedHashMap<>();

        //凡是要对集合的排序首先想到的是集合的工具类进行排序
        //将map的数据结构转换成list结构
        // 把hashmap的键值对拿出来 转到集合里面
        Set<Map.Entry<Integer, User>> entries = hashMap.entrySet();
        //把set集合转成list集合
        ArrayList<Map.Entry<Integer, User>> list = new ArrayList<>(entries);
        //参2 比较器
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                //默认排序o1 -o2;
                //反序
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });
        //将排好序的list转换成linkHashMap  set->list 转换不可逆
        //遍历取出来 放到linkHashMap中
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, User> entry = list.get(i);
            newHashMap.put(entry.getKey(), entry.getValue());
        }
        return newHashMap;
    }
}
