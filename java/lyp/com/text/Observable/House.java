package lyp.com.text.Observable;

import java.util.Observable;

/**
 * Created by lyp on 2019/3/4.
 */

public class House extends Observable{


    public float getPrice() {
        return price;
    }



    public void setPrice(float price) {
        /*设置变化点*/
        super.setChanged();
        /*通知所有观察者价格发生改变   传参数*/
        super.notifyObservers(price);
        this.price = price;
    }

    private  float price;

    public House(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "房子的价格为" +
                "price=" + price
                ;
    }
}
