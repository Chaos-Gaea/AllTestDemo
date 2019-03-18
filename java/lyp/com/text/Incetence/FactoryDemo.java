package lyp.com.text.Incetence;

/**
 * Created by lyp on 2019/3/3.
 */

public class FactoryDemo {
    public static void main(String[] args) {
        Fruit fruit = null;
        fruit = Factory.getInstance("orange");
        fruit.eat();
    }

}
