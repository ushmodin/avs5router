package com.artmark.avs5router.domain.model;

import javax.persistence.*;

/**
 * Created by nikolay on 20.03.17.
 */
@Entity
@Table(name = "depots")
public class Depot implements Identity {
	@Id
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "host_id")
	private Host host;
	@ManyToOne
	@JoinColumn(name = "global_station_id")
	private GlobalStation globalStation;

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

	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public GlobalStation getGlobalStation() {
		return globalStation;
	}

	public void setGlobalStation(GlobalStation globalStation) {
		this.globalStation = globalStation;
	}
}
