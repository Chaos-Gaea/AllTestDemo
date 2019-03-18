package lyp.com.text.Inject;

import lyp.com.text.Inject.ViewInject;

/**
 * Created by lyp on 2019/2/27.
 */

public class User {


    @ViewInject(age= 23,name= "张三")
    private  String name;
    private int age;

    private String eat(String eat){
        System.out.println("eat"+eat);

        return eat+"真好吃";
    }


    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
