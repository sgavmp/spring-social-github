package org.springframework.social.github.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubStatsParticipation {
	private List<Integer> all;
	private List<Integer> owner;
	
	@JsonProperty("all")
	public List<Integer> getAll() {
		return all;
	}
	public void setAll(List<Integer> all) {
		this.all = all;
	}
	@JsonProperty("owner")
	public List<Integer> getOwner() {
		return owner;
	}
	public void setOwner(List<Integer> owner) {
		this.owner = owner;
	}
	
	
}
