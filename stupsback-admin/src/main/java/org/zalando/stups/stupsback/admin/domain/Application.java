package org.zalando.stups.stupsback.admin.domain;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author jbellmann
 *
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Application extends AbstractPersistable<Long> {

	private String name;

	private String partone;

	private String parttwo;

}
