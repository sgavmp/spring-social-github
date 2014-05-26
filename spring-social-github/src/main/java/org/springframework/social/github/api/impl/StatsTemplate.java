/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.github.api.impl;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.social.github.api.GitHubCommit;
import org.springframework.social.github.api.GitHubDownload;
import org.springframework.social.github.api.GitHubHook;
import org.springframework.social.github.api.GitHubIssue;
import org.springframework.social.github.api.GitHubRepo;
import org.springframework.social.github.api.GitHubStatsCommitActivity;
import org.springframework.social.github.api.GitHubStatsParticipation;
import org.springframework.social.github.api.GitHubUser;
import org.springframework.social.github.api.RepoOperations;
import org.springframework.social.github.api.StatsOperations;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * Repository template implementation.
 * </p>
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Greg Turnquist
 */
public class StatsTemplate extends AbstractGitHubOperations implements StatsOperations {
	private final RestTemplate restTemplate;
	
	/**
	 * @param restTemplate
	 * @param isAuthorizedForUser
	 */
	public StatsTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	public List<GitHubStatsCommitActivity> getCommitActivity(String user,
			String repo) {
		return asList(restTemplate.getForObject(buildRepoUri("/commit_activity"), GitHubStatsCommitActivity[].class, user, repo));
	}

	public GitHubStatsParticipation getParticipation(String user,
			String repo) {
		return restTemplate.getForObject(buildRepoUri("/participation"), GitHubStatsParticipation.class, user, repo);
	}

	private String buildRepoUri(String path) {
		return buildUri("repos/{user}/{repo}/stats/" + path);
	}
}
