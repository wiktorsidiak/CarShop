package com.sidiak.CarShop.service.User;

import com.sidiak.CarShop.model.User.User;
import com.sidiak.CarShop.model.User.UserRole;
import com.sidiak.CarShop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiсeImpl implements UserServiсe {

	@Autowired
	UserRepo userRepo;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UserServiсeImpl(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder) {

		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User saveUser(User user) {
		User createdUser = new User();
		user.setUsername(user.getUsername());
		user.setEmail(user.getEmail());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(createdUser);
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
