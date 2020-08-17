package com.sarkariblackboard.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Activity extends BaseEntity{

    private String userAgent;
    private String ip;
    private String expires;
    @OneToOne
    @JsonBackReference
    private User user;
    private String requestMethod;
    private String url;

    private Long totalVisitors;

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public Long getTotalVisitors() {
        return totalVisitors;
    }

    public void setTotalVisitors(Long totalVisitors) {
        this.totalVisitors = totalVisitors;
    }


}

@MappedSuperclass
 abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    @PrePersist
    public void setCreated() {
        this.created = new Date();
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdated() {
        if (lastUpdated == null)
            return created;
        return lastUpdated;
    }

    @PreUpdate
    public void setLastUpdated() {
        this.lastUpdated = new Date();
    }

    public Date getTime() {
        if (this.lastUpdated != null)
            return this.lastUpdated;
        return this.created;
    }

    public String getReadableDateTime(Date date) {
        if (date == null) return "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(date);
    }

    public String getReadableDayMonth(Date date) {
        if (date == null) return "";
        return new SimpleDateFormat("dd MMMM").format(date);
    }

    public String getReadableDateWithoutTime(Date date) {
        if (date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM, dd yyyy");
        return sdf.format(date);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", created=" + created +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
