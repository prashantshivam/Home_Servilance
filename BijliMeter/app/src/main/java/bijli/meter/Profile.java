package bijli.meter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Profile extends Activity {
    private ImageButton EditProfileButton;
    private Button ChangePasswordButton;
    private Button MyDevicesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditProfileButton=(ImageButton)findViewById(R.id.editProfile);
        ChangePasswordButton=(Button)findViewById(R.id.changePassword);
        MyDevicesButton=(Button)findViewById(R.id.myDevices);

        EditProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Profile.this,EditProfile.class);
                startActivity(intent);
            }
        });

        ChangePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Profile.this,ChangePassword.class);
                startActivity(intent);
            }
        });

        MyDevicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Profile.this,myDevices.class);
                startActivity(intent);
            }
        });
    }
}
