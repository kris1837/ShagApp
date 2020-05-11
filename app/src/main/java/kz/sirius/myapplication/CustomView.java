package kz.sirius.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

public class CustomView extends LinearLayout {

    interface CustomViewListener {
        void onClickListener();
    }

    private boolean mShowText;
    private int mState;
    private int mBackgound;

    EditText uiLogin;
    EditText uiPassword;
    Button uiBtn;

    private CustomViewListener customViewListener;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    private void init(Context context, @Nullable AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomView,
                0, 0);

        try {
            mShowText = a.getBoolean(R.styleable.CustomView_showText, false);
            mBackgound = a.getColor(R.styleable.CustomView_colorBg, 0);
            mState = a.getInt(R.styleable.CustomView_state, 1);
        } finally {
            a.recycle();
        }


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.widget_custom_view, this, true);

        uiLogin = view.findViewById(R.id.uiLogin);
        uiLogin.setText("root");
        uiPassword = view.findViewById(R.id.uiPassword);
        uiPassword.setText("12345");
        uiBtn = view.findViewById(R.id.uiBtn);

        uiBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customViewListener != null) {
                    customViewListener.onClickListener();
                }
            }
        });
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float[] circleLocations = {200f, 300f, 400f};
        float yLocation = 320f;
        float circleRadiusInPX = 50f;
        Paint chosenCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        chosenCirclePaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        chosenCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        for (int i = 0; i < 3; ++i) {
            canvas.drawCircle(circleLocations[i], yLocation, circleRadiusInPX, chosenCirclePaint);
        }
    }

}

