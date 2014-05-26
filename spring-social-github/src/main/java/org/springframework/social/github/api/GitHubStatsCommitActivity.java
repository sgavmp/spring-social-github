package org.springframework.social.github.api;

import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubStatsCommitActivity implements Comparable<GitHubStatsCommitActivity> {
	
	private List<Integer> days;
	private Integer total;
	private Long week;
	
	@JsonProperty("days")
	public List<Integer> getDays() {
		return days;
	}
	public void setDays(List<Integer> days) {
		this.days = days;
	}
	@JsonProperty("total")
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@JsonProperty("week")
	public Long getWeek() {
		return week;
	}
	public void setWeek(Long week) {
		this.week = week;
	}
	public int compareTo(GitHubStatsCommitActivity o) {
		return this.week.compareTo(o.getWeek());
	}

}
