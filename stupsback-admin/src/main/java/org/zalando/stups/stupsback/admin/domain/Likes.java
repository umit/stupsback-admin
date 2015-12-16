package org.zalando.stups.stupsback.admin.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Christian Lohmann
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Likes extends AbstractPersistable<Long> {

    private String user;

    @ManyToOne
    private Rating rating;

}
