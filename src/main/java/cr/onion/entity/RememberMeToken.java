package cr.onion.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author Beldon
 */
@Document(collection = "remember_me_token")
public class RememberMeToken extends BaseEntity{
    private String account;
    private String tokenValue;
    private Date created;
    private Date updated;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getUpdated() {
        return updated;
    }
}
