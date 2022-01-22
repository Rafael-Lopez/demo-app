package domain;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType (XmlAccessType.FIELD)
public class Cookies {
    @XmlElement(name = "cookie")
    private List<Cookie> cookies;

    public List<Cookie> getCookies() {
        return cookies;
    }

    public void setCookies(List<Cookie> cookies) {
        this.cookies = cookies;
    }
}
