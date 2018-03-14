package bijli.meter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDevice extends AppCompatActivity {
    private EditText DeviceName;
    private EditText Room;
    private Button Add;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);

        DeviceName=(EditText)findViewById(R.id.deviceName);
        Room = (EditText)findViewById(R.id.room);
        Add=(Button)findViewById(R.id.addButton);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference(firebaseAuth.getUid());

        progressDialog = new ProgressDialog(this);


        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    progressDialog.setMessage("Adding");
                    progressDialog.show();
                    sendDeviceData();
                    progressDialog.dismiss();
                    Toast.makeText(AddDevice.this,"Device Added",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(AddDevice.this,myDevices.class);
                    startActivity(intent);
                    finish();

                }
                else {
                    Toast.makeText(AddDevice.this,"input requirred",Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(AddDevice.this,AddDevice.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean validate(){
        String device=DeviceName.getText().toString();
        String room=Room.getText().toString();

        if(device.isEmpty() || room.isEmpty())
            return false;
        else
            return true;
    }

    private void sendDeviceData(){
        String deviceName = DeviceName.getText().toString();
        String room=Room.getText().toString();
        databaseUser =FirebaseDatabase.getInstance().getReference("devices");
        String ID = databaseUser.push().getKey();
        CreateDevice createDevice=new CreateDevice(ID,deviceName,room);
        databaseUser.child(ID).setValue(createDevice);
    }
}
