package org.zalando.stups.stupsback.admin.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Christian Lohmann
 */
public interface IssueRepository extends PagingAndSortingRepository<Issue, Long> {
}
