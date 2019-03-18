package lyp.com.text.OpenGl;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by lyp on 2019/3/6.
 */

public class MySurfaceView extends GLSurfaceView {

    private final MyGLREnderer mGlrEnderer;

    public MySurfaceView(Context context) {
        super(context);

        //创建一个OpenGl ES 2.0
        setEGLContextClientVersion(2);

        mGlrEnderer = new MyGLREnderer();


        setRenderer(mGlrEnderer);

        this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

    }
}
