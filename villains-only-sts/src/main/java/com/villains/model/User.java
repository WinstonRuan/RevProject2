package com.villains.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Chaos
 *
 */

@Entity
@Table(name="villain_user")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	@Column(name="f_name")
	private String firstName;

	@Column(name="l_name")
	private String lastName;

	@Column(name="user_email")
	private String email;
	
	@Column(name="user_password")
	private String password;

	@Column(name="lair_city")
	private String lairCity;

	@Column(name="lair_country")
	private String lairCountry;

	@Column
	private String profilePic;
	
	public User() {
		
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param lairCity
	 * @param lairCountry
	 * @param profilePic
	 */
	public User( String firstName, String lastName, String email,String password, String lairCity, String lairCountry, String profilePic) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.lairCity = lairCity;
		this.lairCountry = lairCountry;
		this.profilePic = profilePic;
	}

	public User(int userId, String firstName, String lastName, String email,String password, String lairCity, String lairCountry,String profilePic) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.lairCity = lairCity;
		this.lairCountry = lairCountry;
		this.profilePic = profilePic;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String Password) {
		this.password = Password;
	}

	public String getLairCity() {
		return lairCity;
	}

	public void setLairCity(String lairCity) {
		this.lairCity = lairCity;
	}

	public String getLairCountry() {
		return lairCountry;
	}

	public void setLairCountry(String lairCountry) {
		this.lairCountry = lairCountry;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", lairCity=" + lairCity + ", lairCountry=" + lairCountry +", profilePic=" + profilePic + "]";
	}
	
	

}
