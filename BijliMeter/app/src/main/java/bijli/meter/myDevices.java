package bijli.meter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class myDevices extends Activity {
    private Button addDevice;
    private Button Device;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_devices);

        addDevice = (Button)findViewById(R.id.addDevice);
        Device = (Button)findViewById(R.id.device1);

        addDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(myDevices.this,AddDevice.class);
                startActivity(intent);
            }
        });
    }
}
