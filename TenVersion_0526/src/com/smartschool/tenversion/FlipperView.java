package com.smartschool.tenversion;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class FlipperView extends Activity  implements View.OnTouchListener {
 
    ViewFlipper flipper;
     
     float xAtDown;
     float xAtUp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flipper);

		flipper = (ViewFlipper) findViewById(R.id.view_flipper);
		flipper.setOnTouchListener(this);

		// �������� ȭ���ϳ� �߰�
		TextView tv = new TextView(this);
		tv.setText("View 4\nDynamically added");
		tv.setTextColor(Color.CYAN);
		flipper.addView(tv);
	}

	public boolean onTouch(View v, MotionEvent event) {
		if (v != flipper)
			return false;

		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			xAtDown = event.getX(); // ó�� ��ġ ��ġ ����
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			xAtUp = event.getX(); // ��ġ �� ��ġ ����

			if (xAtUp < xAtDown) {
				left();

				flipper.showNext();
			} else if (xAtUp > xAtDown) {
				right();
				flipper.showPrevious();
			}
		}
		return true;
	}

	  private void left(){
	    flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.push_left_in));
	    flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.push_left_out));
	  }
	  private void right(){
	    flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.push_right_in));
	    flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.push_right_out));
	  }
	}


