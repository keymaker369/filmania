package org.seke.filmania.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@NamedQueries({ @NamedQuery(name = User.GET_USER_BY_ID, 
							query = "Select u " +
									"from User u " +
									"where u.id= :id "),
				
				@NamedQuery(name = User.GET_All_USERS, 
							query = "Select u " +
									"from User u"),
									
				@NamedQuery(name = User.GET_USER_BY_USERNAME, 
							query = "Select u " +
									"from User u " +
									"where u.username= :username"),
				@NamedQuery(name = User.DELETE_USER_BY_USERNAME, 
						query = "delete " +
								"from User u " +
								"where u.username= :username")})

@Entity
@Table(name = "USER")
public class User implements UserDetails {

	public static enum Role {
		MEMBER, ADMIN;
		
		public static List<Role> retrieveAll() {
			List<Role> roles = new ArrayList<Role>();
			roles.add(MEMBER);
			roles.add(ADMIN);
			return roles;
		}
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8168229513942647693L;

	public static final String GET_USER_BY_ID = "User.getUserById";

	public static final String GET_All_USERS = "User.getAllUsers";

	public static final String GET_USER_BY_USERNAME = "User.getUserByUsername";

	public static final String DELETE_USER_BY_USERNAME = "User.deleteUserByUsername";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "USERNAME", length = 20)
	private String username;

	@Column(name = "PASSWORD", length = 20)
	private String password;

	@Column(name = "EMAIL", length = 20)
	private String email;

	@Column(name = "ACCOUNTNONEXPIRED")
	private boolean accountNonExpired;

	@Column(name = "ACCOUNTNONLOCKED")
	private boolean accountNonLocked;

	@Column(name = "CREDINTIALSNONEXPIRED")
	private boolean credentialsNonExpired;

	@Column(name = "ENABLED")
	private boolean enabled;

	@Column(name ="ROLE")
	private Role role;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Comment> comments = new HashSet<Comment>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Movie> movies = new HashSet<Movie>(0);

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new LinkedList<GrantedAuthority>();
		
		if (role == Role.MEMBER) {
			authorities.add(new GrantedAuthorityImpl(role.toString()));
		}
		
		if (role == Role.ADMIN) {
			authorities.add(new GrantedAuthorityImpl(Role.MEMBER.toString()));
			authorities.add(new GrantedAuthorityImpl(role.toString()));
		}
		
		return authorities;
	}

}
