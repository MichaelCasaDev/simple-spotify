package player;

import search.Item;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
public class Player {
    private int timestamp;
    private int progress_ms;
    private boolean is_playing;
    private Item item;
    private Device device;

    public Player() {}

    public Player(int timestamp, int progress_ms, boolean is_playing, Item item, Device device) {
        this.timestamp = timestamp;
        this.progress_ms = progress_ms;
        this.is_playing = is_playing;
        this.item = item;
        this.device = device;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getProgress_ms() {
        return progress_ms;
    }

    public void setProgress_ms(int progress_ms) {
        this.progress_ms = progress_ms;
    }

    public boolean isIs_playing() {
        return is_playing;
    }

    public void setIs_playing(boolean is_playing) {
        this.is_playing = is_playing;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
