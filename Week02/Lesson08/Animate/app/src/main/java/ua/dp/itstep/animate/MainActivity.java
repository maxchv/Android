package ua.dp.itstep.animate;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageBart;
    ImageView imageHomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageBart = (ImageView) findViewById(R.id.imageBart);
        imageHomer = (ImageView) findViewById(R.id.imageHomer);

        imageBart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                imageBart.animate()
                         .setDuration(2000)
                         .alpha(0)
                        .setInterpolator(new CycleInterpolator(3))
                          .setListener(new Animator.AnimatorListener() {
                              @Override
                              public void onAnimationStart(Animator animation) {

                              }

                              @Override
                              public void onAnimationEnd(Animator animation) {
                                  Toast.makeText(MainActivity.this, "onAnimationEnd", Toast.LENGTH_SHORT).show();
                              }

                              @Override
                              public void onAnimationCancel(Animator animation) {

                              }

                              @Override
                              public void onAnimationRepeat(Animator animation) {

                              }
                          });
                imageHomer.animate()
                        .setDuration(2000)
                        .alpha(1)
                        .setStartDelay(1000);
            }
        });
    }
}
