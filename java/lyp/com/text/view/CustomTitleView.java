package lyp.com.text.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import android.support.annotation.Nullable;
import android.util.AttributeSet;

import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import java.util.HashSet;
import java.util.Random;

import lyp.com.text.R;


/**
 * Created by lyp on 2019/3/2.
 */

public class CustomTitleView extends View {


    private TypedArray mTypedArray;
    private String mTitleText;
    private int mColor;
    private int mDimensionPixelSize;
    private Paint mPaint;
    private Rect mRect;
    private int mWidthMode;
    private int mHeightMode;
    private int mWidthSize;
    private int heightSize;


    public CustomTitleView(Context context) {
        this(context,null);
    }

    public CustomTitleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomTitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /*
        * 获取我们自定义的样式属性
        * */
        mTypedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int indexCount = mTypedArray.getIndexCount();

        for (int i=0; i< indexCount; i++){
            int index = mTypedArray.getIndex(i);
            switch (index){
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = mTypedArray.getString(index);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    mColor = mTypedArray.getColor(index, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    mDimensionPixelSize = mTypedArray.getDimensionPixelSize(index,
                            (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
                    break;
            }
        }
        mTypedArray.recycle();
        /*获得绘制文本的宽和高*/
        mPaint = new Paint();
        mPaint.setTextSize(mDimensionPixelSize);
        mPaint.setColor(mColor);

        mRect = new Rect();
        mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mRect);


        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitleText = randomText();
                postInvalidate();
            }
        });

    }

    private String randomText() {

        Random random = new Random();
        //创建一个hashSet 拼接长度为4的 有序四位数
        HashSet<Integer> integers = new HashSet<>();
        while(integers.size() < 4 ){
            int randomInt = random.nextInt(10);
            integers.add(randomInt);
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i: integers){
            sb.append(""+i);
        }
        return sb.toString();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        mWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        mHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width;
        int height;
        //计算矩形的宽
        if (mWidthMode == MeasureSpec.EXACTLY){
            width = mWidthSize;
        }else{
            mPaint.setTextSize(mDimensionPixelSize);
            mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mRect);
            //矩形的宽
            float textwidth = mRect.width();
            int desired = (int) (getPaddingLeft() + textwidth + getPaddingRight());
            width = desired;
        }

        //计算矩形的高
        if(mHeightMode == MeasureSpec.EXACTLY){
            height = heightSize;
        }else{
            mPaint.setTextSize(mDimensionPixelSize);
            float textHeight = mRect.height();
            int  desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desired;
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //颜色 和四边形的(left  top  right bottom)
        mPaint.setColor(Color.YELLOW);
        /*
        *
        * */
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);


        mPaint.setColor(mColor);
        canvas.drawText(mTitleText,getWidth()/2-mRect.width()/2,
                    getHeight()/2 + mRect.height()/2,mPaint);

    }


}
