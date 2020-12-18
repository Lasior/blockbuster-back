package com.formacion.blockbuster.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.formacion.blockbuster.entity.Cliente;
import com.formacion.blockbuster.entity.Rol;
import com.formacion.blockbuster.repository.ClienteRepository;
import com.formacion.blockbuster.repository.RolRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	ClienteRepository cliente;

	@Autowired
	RolRepository rol;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Cliente c = cliente.findByUsername(username).get(0);

		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails user = new User(c.getUsername(), c.getPassword(), roles);
		
		/*for (GrantedAuthority grantedAuthority : getAuthorities(c.getRoles())) {
			System.out.println(grantedAuthority);
		}*/

		return user;
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Collection<Rol> roles) {
		return getGrantedAuthorities(getPrivileges(roles));
	}

	private List<String> getPrivileges(Collection<Rol> roles) {
		List<String> rols = new ArrayList<String>();
		for (Rol rol : roles) {
			rols.add(rol.getRol().toString());
		}
		return rols;
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(privilege));
		}
		return authorities;
	}

}
