package api.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="albums")
public class Albums {
    private int total;
    private Item[] items;

    public Albums() {}

    public Albums(int total, Item[] items) {
        this.total = total;
        this.items = items;
    }

    @XmlElement
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    @XmlElement
    public Item[] getItems() {
        return items;
    }
    public void setItems(Item[] items) {
        this.items = items;
    }
}
