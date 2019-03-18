package lyp.com.text.MVC;

/**
 * Created by lyp on 2019/3/6.
 */

public class Contributor {
    public String login;
    public int contributions;

    @Override
    public String toString() {
        return login + ", " + contributions;
    }

}
