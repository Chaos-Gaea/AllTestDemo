package lyp.com.text.Inject;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lyp on 2019/2/27.
 */


@Target(ElementType.FIELD)//用于限制当前自定义注解的作用对象
//@Retention(RetentionPolicy.CLASS)//注解会被编译到字节码中 但是当虚拟机去编译这个字节码的时候注解就会被清除
//@Retention(RetentionPolicy.SOURCE)//注解会只会在源码中出现 当源码被编译成字节码时 注解就会被清除
@Retention(RetentionPolicy.RUNTIME)//该注解会被一直保留到被加载到虚拟机中

public @interface ViewInject {
    int age();

    String name();
}
