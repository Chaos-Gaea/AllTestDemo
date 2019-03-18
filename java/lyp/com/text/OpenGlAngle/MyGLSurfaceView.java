package lyp.com.text.OpenGlAngle;


import java.io.IOException;
import java.io.InputStream;

import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;


import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.MotionEvent;




/**
 * Created by lyp on 2019/3/6.
 */

public class MyGLSurfaceView extends GLSurfaceView {
    private final float suo = 180.0f/320;//角度缩放比例
    private SceneRenderer mRenderer;//场景渲染器
    private float shangY;//上次的触控位置Y坐标
    private float shangX;//上次的触控位置Y坐标
    private int lightAngle=90;//灯的当前角度

    public MyGLSurfaceView(Context context) {
        super(context);

        mRenderer = new SceneRenderer(context,lightAngle);   //创建场景渲染器
        setRenderer(mRenderer);             //设置渲染器
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);//设置渲染模式为主动渲染
    }

    //触摸事件回调方法
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float y = e.getY();
        float x = e.getX();
        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dy = y - shangY;//计算触控笔Y位移
                float dx = x - shangX;//计算触控笔Y位移
                mRenderer.cylinder.mAngleX += dy * suo;//设置沿x轴旋转角度
                mRenderer.cylinder.mAngleZ += dx * suo;//设置沿z轴旋转角度
                requestRender();//重绘画面
        }
        shangY = y;//记录触控笔位置
        shangX = x;//记录触控笔位置
        return true;
    }



    //初始化白色灯
    private void initLight(GL10 gl)
    {
        gl.glEnable(GL10.GL_LIGHTING);//允许光照
        gl.glEnable(GL10.GL_LIGHT1);//打开1号灯

        //环境光设置
        float[] ambientParams={0.2f,0.2f,0.2f,1.0f};//光参数 RGBA
        gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_AMBIENT, ambientParams,0);

        //散射光设置
        float[] diffuseParams={1f,1f,1f,1.0f};//光参数 RGBA
        gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_DIFFUSE, diffuseParams,0);

        //反射光设置
        float[] specularParams={1f,1f,1f,1.0f};//光参数 RGBA
        gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_SPECULAR, specularParams,0);
    }

    //关闭灯
    private void closeLight(GL10 gl)
    {
        gl.glDisable(GL10.GL_LIGHT1);
        gl.glDisable(GL10.GL_LIGHTING);
    }

    //初始化材质
    private void initMaterial(GL10 gl)
    {
        //环境光
        float ambientMaterial[] = {248f/255f, 242f/255f, 144f/255f, 1.0f};
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT, ambientMaterial,0);
        //散射光
        float diffuseMaterial[] = {248f/255f, 242f/255f, 144f/255f, 1.0f};
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, diffuseMaterial,0);
        //高光材质
        float specularMaterial[] = {248f/255f, 242f/255f, 144f/255f, 1.0f};
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, specularMaterial,0);
        gl.glMaterialf(GL10.GL_FRONT_AND_BACK, GL10.GL_SHININESS, 100.0f);
    }

    //初始化纹理
    public int initTexture(GL10 gl,int drawableId)//textureId
    {
        //生成纹理ID
        int[] textures = new int[1];
        gl.glGenTextures(1, textures, 0);
        int currTextureId=textures[0];
        gl.glBindTexture(GL10.GL_TEXTURE_2D, currTextureId);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,GL10.GL_LINEAR_MIPMAP_NEAREST);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D,GL10.GL_TEXTURE_MAG_FILTER,GL10.GL_LINEAR_MIPMAP_LINEAR);
        ((GL11)gl).glTexParameterf(GL10.GL_TEXTURE_2D, GL11.GL_GENERATE_MIPMAP, GL10.GL_TRUE);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S,GL10.GL_REPEAT);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T,GL10.GL_REPEAT);



        InputStream is = this.getResources().openRawResource(drawableId);
        Bitmap bitmapTmp;
        try
        {
            bitmapTmp = BitmapFactory.decodeStream(is);
        }
        finally
        {
            try
            {
                is.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmapTmp, 0);
        bitmapTmp.recycle();

        return currTextureId;
    }
}
