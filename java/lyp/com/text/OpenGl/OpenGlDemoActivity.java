package lyp.com.text.OpenGl;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import lyp.com.text.R;

/**
 * Created by lyp on 2019/3/6.
 */

public class OpenGlDemoActivity extends AppCompatActivity {

     GLSurfaceView mGlSurfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.opengl_activity);

        setTitle("OpenGlSample");
        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.

        mGlSurfaceView = new MySurfaceView(this);

        setContentView(mGlSurfaceView);



    }
}
