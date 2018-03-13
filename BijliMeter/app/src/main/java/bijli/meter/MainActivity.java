package bijli.meter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();
    }

    private class LogoLauncher extends Thread{

        public void run(){
            try{
                sleep(3000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            Intent intent=new Intent(MainActivity.this,LoginSignup.class);
            startActivity(intent);
            MainActivity.this.finish();
        }

    }
}
