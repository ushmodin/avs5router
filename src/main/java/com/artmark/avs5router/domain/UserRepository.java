package com.artmark.avs5router.domain;

import com.artmark.avs5router.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ushmodin N.
 * @since 10.04.2017 14:37
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
