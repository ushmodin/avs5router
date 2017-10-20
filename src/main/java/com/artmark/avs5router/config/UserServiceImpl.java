package com.artmark.avs5router.config;

import com.artmark.avs5router.domain.UserRepository;
import com.artmark.avs5router.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Реализация сервиса авторизации
 *
 * @author V.Skorykh
 * @since 03.07.2014 17:05
 */
@Component
@Transactional(readOnly = true)
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found: " + username);
		}
		return user;
	}

}
