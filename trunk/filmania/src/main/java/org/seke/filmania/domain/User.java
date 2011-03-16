package org.seke.filmania.domain;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USER")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "ID")
	long id;
	@Column(name = "USERNAME")
	String username;
	@Column(name = "PASSWORD")
	String password;
	@Column(name = "EMAIL")
	String email;
	@ManyToMany
	private List<Role> roles;
	@OneToMany
	List<Movie> addedMovies;
	@OneToMany
	List<Comment> comments;
	@OneToMany
	List<Rating> ratings;
	@Column(name = "ACCOUNTNONEXPIRED")
	private boolean accountNonExpired;
	@Column(name = "ACCOUNTNONLOCKED")
	private boolean accountNonLocked;
	@Column(name = "CREDINTIALSNONEXPIRED")
	private boolean credentialsNonExpired;
	@Column(name = "ENABLED")
	private boolean enabled;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Movie> getAddedMovies() {
		return addedMovies;
	}

	public void setAddedMovies(List<Movie> addedMovies) {
		this.addedMovies = addedMovies;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new LinkedList<GrantedAuthority>();
		for (Role role : roles) {
			authorities.add(new GrantedAuthorityImpl(role.getName()));
		}
		return authorities;
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

}
