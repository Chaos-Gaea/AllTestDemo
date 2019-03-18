package lyp.com.text.Observable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by lyp on 2019/3/4.
 */

public class HousePriceObserver implements Observer {


    private  String name;

    public HousePriceObserver(String name) {
        //
        super();
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Float){
            System.out.println(this.name + "观察到的价格更该为");
            System.out.println(((Float) arg).floatValue());
        }
    }


    public static void main(String[] args){
        House house = new House(10000);
        //创建观察者
        HousePriceObserver h1 = new HousePriceObserver("购房者A");
        HousePriceObserver h2 = new HousePriceObserver("购房者B");
        HousePriceObserver h3 = new HousePriceObserver("购房者C");
        //添加购房者
        house.addObserver(h1);
        house.addObserver(h2);
        house.addObserver(h3);
        System.out.println(house);
        house.setPrice(60000);
        System.out.println(house);

    }
}
