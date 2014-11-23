package br.com.sugar.model.entities.users;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.sugar.model.entities.links.ProfileLink;

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
 * Class responsible for representing the characteristics of a user's profile.
 * 
 * @author Pedro Lima
 * @category model
 */
@Entity
public class Profile implements Serializable {

	/**
	 * The serialVersionUID is a universal version identifier for a Serializable
	 * class.
	 */
	private static final long serialVersionUID = -3918497571403221968L;

	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Property that represents the users's full name.
	 */
	private String fullName;

	/**
	 * Property that represents the users's email.
	 */
	private String email;

	/**
	 * Property that represents the users's biography.
	 */
	private String biography;

	/**
	 * Property that represents the users's home page.
	 */
	private String homePage;

	/**
	 * Property that represents the creation date of this profile.
	 */
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;

	/**
	 * Property that represents the update date of this profile.
	 */
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date updatedDate;

	/**
	 * Property that contains all links added by a profile.
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")
	private List<ProfileLink> links;

	/**
	 * Constructor of the class
	 */
	public Profile() {
		super();
	}

	/**
	 * Constructor of the class
	 * 
	 * @param fullName
	 *            Value that represents the users's full name.
	 * @param email
	 *            Value that represents the users's email.
	 * @param biografy
	 *            Value that represents the users's biografy.
	 * @param homePage
	 *            Value that represents the users's home page.
	 * @param createdDate
	 *            Value that represents the creation date of this profile.
	 * @param updatedDate
	 *            Value that represents the update date of this profile.
	 * @param links
	 *            Value that contains all links added by a profile.
	 */
	public Profile(String fullName, String email, String biography,
			String homePage, Date createdDate, Date updatedDate,
			List<ProfileLink> links) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.biography = biography;
		this.homePage = homePage;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.links = links;
	}

	/**
	 * Returns the object's id.
	 * 
	 * @return Value that represents the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the object's id.
	 * 
	 * @param id
	 *            Value that represents the id.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the object's full name.
	 * 
	 * @return Value that represents the users's full name.
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Set the object's full name.
	 * 
	 * @param fullName
	 *            Value that represents the users's full name.
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Returns the object's email.
	 * 
	 * @return Value that represents the users's email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the object's email.
	 * 
	 * @param email
	 *            Value that represents the users's email.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the object's biography.
	 * 
	 * @return Value that represents the users's biography.
	 */
	public String getBiography() {
		return biography;
	}

	/**
	 * Set the object's biography.
	 * 
	 * @param biografy
	 *            Value that represents the users's biography.
	 */
	public void setBiography(String biography) {
		this.biography = biography;
	}

	/**
	 * Returns the object's homePage.
	 * 
	 * @return Value that represents the users's home page.
	 */
	public String getHomePage() {
		return homePage;
	}

	/**
	 * Set the object's homePage.
	 * 
	 * @param homePage
	 *            Value that represents the users's home page.
	 */
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	/**
	 * Returns the object's createdDate.
	 * 
	 * @return Value that represents the creation date of this object.
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Set the object's createdDate.
	 * 
	 * @param createdDate
	 *            Value that represents the creation date of this object.
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Returns the object's updatedDate.
	 * 
	 * @return Value that represents the update date of this object.
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Returns the object's updatedDate.
	 * 
	 * @param updatedDate
	 *            Value that represents the update date of this object.
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * 
	 * @return
	 */
	public List<ProfileLink> getLinks() {
		return links;
	}

	public void setLinks(List<ProfileLink> links) {
		this.links = links;
	}

	/**
	 * Calculates the hash of the object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * Checks if the given object corresponds with this object
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * Returns a textual representation of the object
	 */
	@Override
	public String toString() {
		return "Profile [id=" + id + ", fullName=" + fullName + ", email="
				+ email + ", biography=" + biography + ", homePage=" + homePage
				+ ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}

}
