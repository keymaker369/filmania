package org.seke.filmania.domain;

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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USER", catalog = "filmania")
@NamedQueries({ @NamedQuery(name = User.GET_USER_BY_ID, query = "Select u from User u where u.id= :id ") })
public class User implements UserDetails {
	
	public static final String GET_USER_BY_ID = "User.getUserById";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;
	
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
	private boolean credintialsNonExpired;
	
	@Column(name = "ENABLED")
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Comment> comments = new HashSet<Comment>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Movie> movies = new HashSet<Movie>(0);
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", catalog = "filmania", 
						joinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, 
						inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) })
	private Set<Role> roles = new HashSet<Role>(0);

	public User() {
	}

	public User(String username, String password, String email, Boolean accountnonexpired, Boolean accountnonlocked, Boolean credintialsnonexpired, Boolean enabled, Set<Comment> comments,
			Set<Movie> movies, Set<Role> roles) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.accountNonExpired = accountnonexpired;
		this.accountNonLocked = accountnonlocked;
		this.credintialsNonExpired = credintialsnonexpired;
		this.enabled = enabled;
		this.comments = comments;
		this.movies = movies;
		this.roles = roles;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountnonexpired) {
		this.accountNonExpired = accountnonexpired;
	}

	
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountnonlocked) {
		this.accountNonLocked = accountnonlocked;
	}

	
	public boolean isCredentialsNonExpired() {
		return credintialsNonExpired;
	}

	public void setCredintialsNonExpired(Boolean credintialsnonexpired) {
		this.credintialsNonExpired = credintialsnonexpired;
	}

	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
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

	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new LinkedList<GrantedAuthority>();
		for (Role role : roles) {
			authorities.add(new GrantedAuthorityImpl(role.getName()));
		}
		return authorities;
	}

}
