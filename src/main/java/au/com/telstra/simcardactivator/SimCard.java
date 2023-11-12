package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimCard {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String iccid;
    private String customerEmail;
    private boolean active;

    public SimCard() {
    }

    public SimCard(String iccid, String customerEmail, boolean active) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.active = active;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "SimCard {iccid=" + iccid + ", customerEmail=" + customerEmail + ", active=" + active + "}";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
