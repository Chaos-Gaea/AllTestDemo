package lyp.com.text.Incetence;

/**
 * Created by lyp on 2019/3/3.
 */

public class Factory  {

    public static Fruit getInstance(String fruitString)
        
        if (fruitString.equals("apple")){
            return new Apple();
        }else if (fruitString.equals("orange")){
            return new Orange();
        }else{
        return null;
        }
    }

}
