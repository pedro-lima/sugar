package br.com.sugar.business.services.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sugar.model.entities.users.User;
import br.com.sugar.repository.daos.user.UserRepository;

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
 * Service class for managing users.
 * 
 * @author Pedro Lima
 *
 */
@Service
@Transactional
public class UserServiceImp implements UserService {

	private static final long serialVersionUID = 7993451515020058758L;

	private final Logger log = LoggerFactory.getLogger(UserServiceImp.class);

	@Autowired
	private UserRepository repository;

	public UserServiceImp() {
		super();
	}

	public UserRepository getRepository() {
		return repository;
	}

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	public Logger getLog() {
		return log;
	}
	
	@Override
	public void save(User user) {
		this.getRepository().save(user);
	}

	@Override
	public Iterable<User> findAll() {		
		return this.getRepository().findAll();
	}

}
