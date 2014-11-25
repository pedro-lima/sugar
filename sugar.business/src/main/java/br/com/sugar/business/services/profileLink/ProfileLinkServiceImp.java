package br.com.sugar.business.services.profileLink;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sugar.repository.daos.profileLink.ProfileLinkRepository;

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

@Service
@Transactional
public class ProfileLinkServiceImp implements ProfileLinkService {

	private static final long serialVersionUID = 5556606567930354130L;

	private final Logger log = LoggerFactory
			.getLogger(ProfileLinkServiceImp.class);

	@Autowired
	private ProfileLinkRepository repository;

	public ProfileLinkServiceImp() {
		super();
	}

	public Logger getLog() {
		return log;
	}

	public ProfileLinkRepository getRepository() {
		return repository;
	}

}
