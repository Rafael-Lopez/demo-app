package domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "config")
@XmlAccessorType(XmlAccessType.FIELD)
public class Config {
    @XmlElement
    private Subdomains subdomains;
    @XmlElement
    private Cookies cookies;

    public Subdomains getSubdomains() {
        return subdomains;
    }

    public void setSubdomains(Subdomains subdomains) {
        this.subdomains = subdomains;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public void setCookies(Cookies cookies) {
        this.cookies = cookies;
    }
}
