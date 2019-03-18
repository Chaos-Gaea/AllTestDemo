package lyp.com.text.IntentServiceTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import lyp.com.text.R;

/**
 * Created by lyp on 2019/3/4.
 */

public class IntentServiceActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_service);

        Intent service = new Intent(this,MyIntentService.class);

        service.putExtra("url","http://www.github.com");
        startService(service);
    }
}
