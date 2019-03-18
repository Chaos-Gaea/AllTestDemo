package lyp.com.text.Inject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lyp.com.text.Inject.User;
import lyp.com.text.Inject.ViewInject;
import lyp.com.text.R;

public class MainActivity extends AppCompatActivity {

    private Field mDeclaredField;
    private Field mDeclaredFieldAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取user类中 name字段上自定义的注解 然后将该值的age通过反射设置User对象的age属性 将name设置User的name属性

        User user = new User();

        /*
        * 获取user的字节码文件
        * */
        Class clazz = User.class;

        /*将字节码中的name获取到
        * */
        /*
        * 只能获取声明为public的字段
        * */
        //clazz.getField(name)
        //clazz.getFields()

        try {
            mDeclaredField = clazz.getDeclaredField("name");
            mDeclaredFieldAge = clazz.getDeclaredField("age");
            ViewInject viewInject = mDeclaredField.getAnnotation(ViewInject.class);


            if (viewInject != null){
               /*
               * 获取自定义注解上的参数

               * */
                int age = viewInject.age();
                String name = viewInject.name();

                System.out.println("name"+name+"age"+age);

                /*通过反射将这两个值设置给user对象*/
                /*允许暴力反射*/
                mDeclaredField.setAccessible(true);
                mDeclaredFieldAge.setAccessible(true);
                /*给user对象的declaredfiled的值设置为name*/
                mDeclaredField.set(user,name);
                mDeclaredFieldAge.set(user,age);

                System.out.println(user.toString());
            }else{
                System.out.println("字段上没有自定义注解");
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //通过反射获得user的eat方法

        try {
            Method method = clazz.getDeclaredMethod("eat", String.class);

            method.setAccessible(true);//必须加上这句话
            /*暴力反射调用该方法*/

            Object result = method.invoke(user, "牛肉拉面");

            System.out.println(result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
