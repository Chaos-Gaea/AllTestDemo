package lyp.com.text.CallBackTest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import lyp.com.text.R;

/**
 * Created by lyp on 2019/3/3.
 */

public class CallBackTestActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callback_activity);

        OpenClose openClose = new OpenClose();

        openClose.setStateChangeListener(new StateChangeListener() {
            @Override
            public void stateChange(boolean stateChange) {
                if (stateChange){
                    System.out.println("开");
                }else{
                    System.out.println("关");
                }
            }
        });
    }


    public class OpenClose {

        //持有一个接口对象
        StateChangeListener mStateChangeListener = null;

        //提供注册监听的方法
        public void setStateChangeListener(StateChangeListener mStateChangeListener){
            this.mStateChangeListener = mStateChangeListener;
            IsClick(false);
        }

        public void IsClick(boolean b) {
            //通过接口对象传控件状态
            mStateChangeListener.stateChange(b);
        }
    }



}
