package br.com.sugar.model.entities.links;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

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
 * Class responsible for representing the characteristics of a link.
 * 
 * @author Pedro Lima
 * @category model
 */
@Entity
public class Link implements Serializable {

	/**
	 * The serialVersionUID is a universal version identifier for a Serializable
	 * class.
	 */
	private static final long serialVersionUID = 6403480284557776733L;

	/**
	 * Property that represents the id.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Property that represents a web address.
	 */
	@Lob
	@Column(length = 500, nullable = false)
	@Max(500)
	@URL
	@Size(min = 5, max = 500)
	private String url;

	/**
	 * Property that represents how many times a link has been registered in the
	 * system. This Value was created by performance issues.
	 */
	@Column(nullable = false)
	private Long count = 0L;

	/**
	 * Property that represents a collection of users who have added the link
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "link")
	private List<ProfileLink> links;

	/**
	 * Constructor of the class
	 */
	public Link() {
		super();
	}

	/**
	 * Constructor of the class
	 * 
	 * @param url
	 *            Value that represents the address of a link.
	 * @param links
	 *            Value that represents a collection of users who have added a
	 *            link
	 */
	public Link(String url, List<ProfileLink> links) {
		super();
		this.url = url;
		this.links = links;
		if (links != null && links.size() > 0) {
			this.count = new Long(links.size());
		} else {
			this.count = 0L;
		}
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
	 * Returns the object's url.
	 * 
	 * @return Value that represents a web address.
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Set the object's url.
	 * 
	 * @param url
	 *            Value that represents a web address.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Returns the object's count.
	 * 
	 * @return Value that represents how many times a link has been registered
	 *         in the system.
	 */
	public Long getCount() {
		return this.count;
	}

	/**
	 * Set the object's count.
	 * 
	 * @param count
	 *            Value that represents how many times a link has been
	 *            registered in the system.
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * Returns the object's links.
	 * 
	 * @return Value that represents a collection of users who have added the
	 *         link
	 */
	public List<ProfileLink> getLinks() {
		if (this.links == null) {
			this.setLinks(new ArrayList<ProfileLink>());
		}
		return this.links;
	}

	/**
	 * Set the object's links.
	 * 
	 * @param links
	 *            Value that represents a collection of users who have added the
	 *            link
	 */
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
		Link other = (Link) obj;
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
		StringBuilder builder = new StringBuilder("Link [id=" + id + ", url="
				+ url + ", count=" + count);
		if (this.getLinks().size() > 0) {
			builder.append(", links= { ");
			for (int i = 0; i < this.getLinks().size(); i++) {
				builder.append(this.getLinks().get(i).getId());
				if (i != this.getLinks().size() - 1) {
					builder.append(", ");
				}
			}
			builder.append(" }");
		}
		builder.append(" ]");
		return builder.toString();
	}

}
