package com.sidiak.CarShop.service.User;

import com.sidiak.CarShop.model.User.User;
import com.sidiak.CarShop.model.User.UserRole;
import com.sidiak.CarShop.repository.UserRepo;
import com.sidiak.CarShop.repository.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserServiсe {

	@Autowired
	UserRepo userRepo;

	@Autowired
	UserRoleRepo userRoleRepo;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;

	}

	@Override
	public User saveUser(User user) {
		user.setEmail(user.getEmail());
		user.setUsername(user.getUsername());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		user.setRoles(new HashSet<>(userRoleRepo.findAll()));

		return userRepo.save(user);
	}

	@Override
	public void deleteUser(User userId) {
		userRepo.delete(userId);
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (UserRole role: user.getRoles()){
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}
