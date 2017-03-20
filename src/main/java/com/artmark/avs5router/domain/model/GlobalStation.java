package com.artmark.avs5router.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nikolay on 20.03.17.
 */
@Entity
@Table(name = "global_stations")
public class GlobalStation implements Identity {
	@Id
	private Long id;
	private String name;
	private String guid;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}
}
