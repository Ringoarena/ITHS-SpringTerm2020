package model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalTime;

@XmlRootElement
public class CurrentTime {
    private String time;

    public CurrentTime() {
        this.time = LocalTime.now().toString();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
