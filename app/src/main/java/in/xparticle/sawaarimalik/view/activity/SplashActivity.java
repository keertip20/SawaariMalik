package in.xparticle.sawaarimalik.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import in.xparticle.sawaarimalik.R;
import in.xparticle.sawaarimalik.utils.AppSession;

public class SplashActivity extends AppCompatActivity {

    AppSession mAppSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mAppSession = new AppSession(this);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if(mAppSession.isLogin()){
                    Intent intent=new Intent(SplashActivity.this,DashboardActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                }

            }
        }, 3000);
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
//                startActivity(intent);
//            }
//        }, 3000);
    }
}