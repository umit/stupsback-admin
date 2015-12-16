package org.zalando.stups.stupsback.admin.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Christian Lohmann
 */
public interface LikesRepository extends PagingAndSortingRepository<Likes, Long>{
}
