package com.springboot.exam.portal.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;
	// Properties
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String userName;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userContactNumber;
	private Boolean userIsEnabled = true; 
	private String userProfile;
	private String rawPassword;
	private Integer attemptedQuiz;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();
	// Constructor
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String userName, String userPassword, String userFirstName, String userLastName,
			String userEmail, String userContactNumber, Boolean userIsEnabled,String userProfile,Set<UserRole> userRoles,Integer attemptedQuiz) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userContactNumber = userContactNumber;
		this.userIsEnabled = userIsEnabled;
		this.userProfile = userProfile;
		this.userRoles = userRoles;
		this.attemptedQuiz = attemptedQuiz;
	}

	// Getter And Setter
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContactNumber() {
		return userContactNumber;
	}

	public void setUserContactNumber(String userContactNumber) {
		this.userContactNumber = userContactNumber;
	}

	public Boolean getUserIsEnabled() {
		return userIsEnabled;
	}

	public void setUserIsEnabled(Boolean userIsEnabled) {
		this.userIsEnabled = userIsEnabled;
	}
	
	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public String getRawPassword() {
		return rawPassword;
	}

	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}

	public Integer getAttemptedQuiz() {
		return attemptedQuiz;
	}

	public void setAttemptedQuiz(Integer attemptedQuiz) {
		this.attemptedQuiz = attemptedQuiz;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userContactNumber=" + userContactNumber + ", userIsEnabled=" + userIsEnabled + ", userProfile="
				+ userProfile + ", rawPassword=" + rawPassword + ", attemptedQuiz=" + attemptedQuiz + ", userRoles="
				+ userRoles + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<Authority> set = new HashSet<>();
		this.userRoles.forEach(userRoles->{
			set.add(new Authority(userRoles.getRole().getRoleName()));
		});
		return set;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getUserPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return getUserIsEnabled();
	}
	

}
