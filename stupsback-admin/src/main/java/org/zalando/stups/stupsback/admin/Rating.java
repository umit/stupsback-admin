package org.zalando.stups.stupsback.admin;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Rating extends AbstractPersistable<Long> {

    private String comment;
    private Integer stars;
    private String email;
    private String meta;
    private String appId;

    private Rating() {
        super();
    }

    public Rating(final String comment, final Integer stars, final String email, final String meta,
            final String appId) {
        super();
        this.comment = comment;
        this.stars = stars;
        this.email = email;
        this.meta = meta;
        this.appId = appId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(final Integer stars) {
        this.stars = stars;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(final String meta) {
        this.meta = meta;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(final String appId) {
        this.appId = appId;
    }

}
