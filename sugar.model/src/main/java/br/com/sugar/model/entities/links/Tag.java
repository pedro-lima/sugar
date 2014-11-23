package br.com.sugar.model.entities.links;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
 * Class responsible for representing the characteristics of a tag.
 * 
 * @author Pedro Lima
 * @category model
 */
@Entity
public class Tag implements Serializable {

	/**
	 * The serialVersionUID is a universal version identifier for a Serializable
	 * class.
	 */
	private static final long serialVersionUID = -7792157536390180611L;

	/**
	 * Property that represents the id.
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Property that represents the name of this link.
	 */
	@Column(length = 100)
	@Size(min = 1, max = 100)
	private String name;

	/**
	 * Constructor of the class
	 */
	public Tag() {
		super();
	}

	/**
	 * Constructor of the class
	 */
	public Tag(String name) {
		super();
		this.name = name;
	}

	/**
	 * Returns the tag's id.
	 * 
	 * @return Value that represents the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the tag's id.
	 * 
	 * @param id
	 *            Value that represents the id.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the tag's name.
	 * 
	 * @return Value that represents the name of this link.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the tag's name.
	 * 
	 * @param name
	 *            Value that represents the name of this link.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Calculates the hash of the object.
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
		Tag other = (Tag) obj;
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
		return "Tag [id=" + id + ", name=" + name + "]";
	}

}
