package bijli.meter;

/**
 * Created by prashant on 14/3/18.
 */

public class CreateDevice {
    private String ID;
    private String Device;
    private String Room;

    public  CreateDevice(String ID, String Device, String Room){
        this.ID=ID;
        this.Device=Device;
        this.Room=Room;
    }

    public String getID() {
        return ID;
    }

    public String getDevice() {
        return Device;
    }

    public String getRoom() {
        return Room;
    }
}
