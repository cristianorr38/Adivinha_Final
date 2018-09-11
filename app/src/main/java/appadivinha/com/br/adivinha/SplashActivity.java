package appadivinha.com.br.adivinha;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(SplashActivity.this, 2000);
    }

    public void run(){
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
