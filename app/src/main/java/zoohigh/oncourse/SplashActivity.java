package zoohigh.oncourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    private final int duration = 1500;

    @Override
    public void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent I =  new Intent(SplashActivity.this, CourseAddActivity.class);
                SplashActivity.this.startActivity(I);
                SplashActivity.this.finish();
            }
        },duration);

    }

}
