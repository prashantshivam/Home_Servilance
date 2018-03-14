package bijli.meter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class myDevices extends Activity {
    private Button addDevice;
    private Button Device;
    ListView listView;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    CreateDevice createDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_devices);

        listView=(ListView)findViewById(R.id.listview);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        createDevice = new CreateDevice();
        arrayList=new ArrayList<>();
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        databaseReference=firebaseDatabase.getReference().child("devices");

        addDevice = (Button)findViewById(R.id.addDevice);
        Device = (Button)findViewById(R.id.device1);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){

                    String device = ds.child("device").getValue().toString();
                    String room = ds.child("room").getValue().toString();

                    Log.d("device", device);
                    Log.d("room", room);

                    arrayList.add(device + room);
                }
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(myListClickListener);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        addDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(myDevices.this,AddDevice.class);
                startActivity(intent);
            }
        });
    }

    private AdapterView.OnItemClickListener myListClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Intent intent = new Intent(myDevices.this, DeviceData.class);
            startActivity(intent);

        }
    };
}
