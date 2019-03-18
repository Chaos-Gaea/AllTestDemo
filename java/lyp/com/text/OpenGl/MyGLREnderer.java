package lyp.com.text.OpenGl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by lyp on 2019/3/6.
 */

public class MyGLREnderer implements GLSurfaceView.Renderer {
    @Override

    /*onSurfaceCreated()：在Surface被创建时回调，用来配置 View 的 OpenGL ES 环境，只会被回调一次；
    onDrawFrame()：在绘制每一帧的时候回调；
    onSurfaceChanged()：在每次Surface尺寸变化时回调，例如当设备的屏幕方向发生改变时。*/
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //设置背景颜色
        GLES20.glClearColor(0.0f,0.0f,0.0f,1.0f);


    }
        /*glClearColor()-设置清空屏幕用的颜色，接收四个参数分别是：红色、绿色、蓝色和透明度分量，0表示透明，1.0f相反；
        * glClear()-清空屏幕，清空屏幕后调用glClearColor(）中设置的颜色填充屏幕    ；
        glViewport()-设置视图的尺寸，这就告诉了OpenGL可以用来渲染surface的大小。*/
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
       //利用glviewport() 设置屏幕空间的大小 在onSuraceChange中回调
        GLES20.glViewport(20,20,width,height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        //重绘背景颜色
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
}
