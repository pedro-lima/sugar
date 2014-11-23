package br.com.sugar.model.entities.links;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import br.com.sugar.model.entities.users.Profile;

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
 * Class responsible for representing a link added by a user.
 * 
 * @author Pedro Lima
 * @category model
 */
@Entity
public class ProfileLink implements Serializable {

	/**
	 * The serialVersionUID is a universal version identifier for a Serializable
	 * class.
	 */
	private static final long serialVersionUID = 962639759300338152L;

	/**
	 * Property that represents the id.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Property that represents a user's comment.
	 */
	@NotNull
	@Max(255)
	@Column(length = 255)
	private String comment;

	/**
	 * Property that represents the creation date of this object.
	 */
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate = new Date();

	/**
	 * Property that represents the update date of this object.
	 */
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date updatedDate = new Date();

	/**
	 * Property that represents the profile of who added this link.
	 */
	@ManyToOne
	private Profile profile;

	/**
	 * Property that represents the address of a internet site.
	 */
	@ManyToOne
	private Link link;

	/**
	 * Property that represents the collection of tags added to a link.
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE })
	@JoinTable(name = "ProfileLink_Tag", joinColumns = @JoinColumn(name = "profile_link_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private List<Tag> tags;

	/**
	 * Constructor of the class
	 */
	public ProfileLink() {
		super();
	}

	/**
	 * Constructor of the class
	 * 
	 * @param comment
	 *            Value that represents a user's comment.
	 * @param createdDate
	 *            Value that represents the creation date of this object.
	 * @param updatedDate
	 *            Value that represents the update date of this object.
	 * @param profile
	 *            Value that represents the user's profile.
	 * @param link
	 *            Value that represents the address of a internet link.
	 * @param tags
	 *            Value that represents the collection of tags added to a
	 *            profile link.
	 */
	public ProfileLink(String comment, Date createdDate, Date updatedDate,
			Profile profile, Link link, List<Tag> tags) {
		super();
		this.comment = comment;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.profile = profile;
		this.link = link;
		this.tags = tags;
	}

	/**
	 * Returns the object's id.
	 * 
	 * @return Value that represents the id.
	 */
	public Long getId() {
		return this.id;
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
	 * Returns the object's comment.
	 * 
	 * @return Value that represents a user's comment.
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * Set the object's comment.
	 * 
	 * @param comment
	 *            Value that represents a user's comment.
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Returns the object's createdDate.
	 * 
	 * @return Value that represents the creation date of this object.
	 */
	public Date getCreatedDate() {
		return this.createdDate;
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
		return this.updatedDate;
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
	 * Returns the object's profile.
	 * 
	 * @return Value that represents the profile of who added this link.
	 */
	public Profile getProfile() {
		return this.profile;
	}

	/**
	 * Set the object's profile.
	 * 
	 * @param profile
	 *            Value that represents the profile of who added this link.
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * Returns the object's link.
	 * 
	 * @return Value that represents the address of a internet site.
	 */
	public Link getLink() {
		return this.link;
	}

	/**
	 * Set the object's link.
	 * 
	 * @param link
	 *            Value that represents the address of a internet site.
	 */
	public void setLink(Link link) {
		this.link = link;
	}

	/**
	 * Returns the object's tags.
	 * 
	 * @return Value that represents the collection of tags added to a link.
	 */
	public List<Tag> getTags() {
		if (this.tags == null) {
			this.setTags(new ArrayList<Tag>());
		}
		return this.tags;
	}

	/**
	 * Set the object's tags.
	 * 
	 * @param tags
	 *            Value that represents the collection of tags added to a link.
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * Method that will be executed before the object be saved into the
	 * database.
	 */
	@PreUpdate
	private void preUpdate() {
		this.setUpdatedDate(new Date());
	}

	/**
	 * Calculates the hash of the object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
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
		ProfileLink other = (ProfileLink) obj;
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
		StringBuilder builder = new StringBuilder("ProfileLink [id=" + id
				+ ", comment=" + comment + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate);
		if (this.getProfile() != null) {
			builder.append(", profile=" + profile.getId());
		}
		if (this.getLink() != null) {
			builder.append(", link=" + link.getId());
		}
		if (this.getTags().size() > 0) {
			builder.append(", tags= { ");
			for (int i = 0; i < this.getTags().size(); i++) {
				builder.append(this.getTags().get(i).getId());
				if (i != this.getTags().size() - 1) {
					builder.append(", ");
				}
			}
			builder.append(" }");
		}
		builder.append(" ]");
		return builder.toString();
	}

}
