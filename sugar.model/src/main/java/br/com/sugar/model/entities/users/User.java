package br.com.sugar.model.entities.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

/*
 * Copyright 2014 Pedro Lima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Class responsible for representing the characteristics of a user.
 * 
 * @author Pedro Lima
 * @category model
 */
@Entity
public class User implements Serializable {

	/**
	 * The serialVersionUID is a universal version identifier for a Serializable
	 * class.
	 */
	private static final long serialVersionUID = 8419156014046185166L;

	/**
	 * Property that represents the id.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Property that represents the login.
	 */
	@Column(length = 50, unique = true)
	@Size(min = 5, max = 50)
	private String login;

	/**
	 * Property that represents the password.
	 */
	@Column(length = 100)
	@Size(min = 5, max = 100)
	private String password;

	/**
	 * Property that represents if the user is active.
	 */
	private boolean activated = true;

	/**
	 * Property that represents the profile of a user.
	 */
	@OneToOne
	private Profile profile;

	/**
	 * Constructor of the class
	 */
	public User() {
		super();
	}

	/**
	 * Constructor of the class
	 * 
	 * @param login
	 *            Value that represents the login.
	 * @param password
	 *            Value that represents the password.
	 * @param activated
	 *            Value that represents if the user is active.
	 * @param profile
	 *            Value that represents the profile of a user.
	 */
	public User(String login, String password, boolean activated,
			Profile profile) {
		super();
		this.setLogin(login);
		this.setPassword(password);
		this.setActivated(activated);
		this.setProfile(profile);
	}

	/**
	 * Returns the user's id.
	 * 
	 * @return Value that represents the id.
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Set the user's id.
	 * 
	 * @param id
	 *            Value that represents the id.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the user's login.
	 * 
	 * @return Value that represents the login.
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Set the user's login.
	 * 
	 * @param login
	 *            Value that represents the login.
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Returns the user's password.
	 * 
	 * @return Value that represents the password.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Set the user's password.
	 * 
	 * @param password
	 *            Value that represents the password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the user's activated.
	 * 
	 * @return Value that represents if the user is active.
	 */
	public boolean isActivated() {
		return this.activated;
	}

	/**
	 * Set the user's activated.
	 * 
	 * @param activated
	 *            Value that represents if the user is active.
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	/**
	 * Return the user's profile.
	 * 
	 * @return Value that represents the profile of a user.
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * Set the user's profile.
	 * 
	 * @param profile
	 *            Value that represents the profile of a user.
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * Calculates the hash of the object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}

	/**
	 * Checks if the given object corresponds with this object
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (this.getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else {
			if (!this.getId().equals(other.getId())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns a textual representation of the object
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("User [id=" + this.getId()
				+ ", login=" + this.getLogin() + ", password="
				+ this.getPassword() + ", activated=" + this.isActivated());
		if (this.getProfile() != null) {
			builder.append(", profile=" + this.getProfile().getId());
		}
		builder.append("]");
		return builder.toString();
	}
}
