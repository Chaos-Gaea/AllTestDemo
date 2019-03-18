package lyp.com.text.Singleton;

/**
 * Created by lyp on 2019/3/3.
 */

public class Singleton {
    //构造器私有化 -->外界无法实例化    创建用static修饰的类对象
    //可以用类名直接调用   --->创建getInstance() 方法 -->instance
    //是静态属性 so方法要用static修饰

   private static Singleton instance =  new Singleton();

   private Singleton(){

   }

   public static Singleton getInstance(){
     return instance;
   }

   public void print(){
       System.out.println("单例模式!");
   }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();//访问类中的静态方法，取得类中的静态实例
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();
        s1.print();								//输出信息
        s2.print();
        s3.print();

    }


}
