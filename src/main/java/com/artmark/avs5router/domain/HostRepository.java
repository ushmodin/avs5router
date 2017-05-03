package com.artmark.avs5router.domain;

import com.artmark.avs5router.domain.model.Host;
import com.artmark.avs5router.domain.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by nikolay on 20.03.17.
 */
@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
	@Cacheable("hosts")
	@Query("select d.host from Depot d where d.globalStation.guid = ?1")
	Optional<Host> getHostByDepotUid(String uid);
}
