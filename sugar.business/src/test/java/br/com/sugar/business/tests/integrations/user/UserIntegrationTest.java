package br.com.sugar.business.tests.integrations.user;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sugar.business.services.user.UserService;
import br.com.sugar.model.entities.users.User;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserIntegrationTest {
	@Autowired
	private UserService service;

	@Test
	public void save() {
		User user = new User();
		user.setLogin(nextValue());
		user.setPassword(nextValue());
		user.setActivated(true);

		service.save(user);
		Assert.assertNotNull(user.getId());
	}

	public String nextValue() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

}
