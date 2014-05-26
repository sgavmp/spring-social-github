package org.springframework.social.github.api;

import java.util.List;

public interface StatsOperations {
	
	List<GitHubStatsCommitActivity> getCommitActivity(String user, String repo);
	GitHubStatsParticipation getParticipation(String user, String repo);

}
