package com.artmark.avs5router.domain;

import com.artmark.avs5router.domain.model.GlobalStation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nikolay on 23.11.17.
 */
public interface GlobalStationRepository extends JpaRepository<GlobalStation, Long> {
}
