package api.player;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "device")
public class Device {
    private String id;

    public Device() {}

    public Device(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
