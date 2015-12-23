package org.zalando.stups.stupsback.admin.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Christian Lohmann
 */
@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@ToString(exclude = "ratings")
public class Issue extends AbstractPersistable<Long> {

    private Integer ghIssueNumber;

    private String title;

    private String description;

    @OneToMany(mappedBy = "issue", cascade= CascadeType.ALL)
    private List<Rating> ratings = new ArrayList<>();
}
