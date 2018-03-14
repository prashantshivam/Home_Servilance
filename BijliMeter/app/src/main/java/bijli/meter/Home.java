package bijli.meter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends Activity {
    private Button LogoutButton;
    private FirebaseAuth firebaseAuth;
    private ImageButton Mydevice;
    private ImageButton Home;
    private ImageButton Expenses;
    private ImageButton Profile;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();
        LogoutButton = (Button)findViewById(R.id.logout);
        Mydevice = (ImageButton)findViewById(R.id.myDevices);
        Home = (ImageButton)findViewById(R.id.home);
        Expenses=(ImageButton)findViewById(R.id.expenses);
        Profile=(ImageButton)findViewById(R.id.profile);

        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                Intent intent=new Intent(Home.this,LoginSignup.class);
                startActivity(intent);
            }
        });

        Mydevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,myDevices.class);
                startActivity(intent);
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,Home.class);
                startActivity(intent);
            }
        });

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,Profile.class);
                startActivity(intent);
            }
        });
    }
}
