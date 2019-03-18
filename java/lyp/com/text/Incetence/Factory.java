package lyp.com.text.Incetence;

/**
 * Created by lyp on 2019/3/3.
 */

public class Factory  {

    public static Fruit getInstance(String fruitString){
        Fruit fruit = null;

        if (fruitString.equals("apple")){
            fruit = new Apple();
        }

        if (fruitString.equals(  "orange")){
             fruit = new Orange();
        }

        return fruit;
    }

}
