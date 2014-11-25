package br.com.sugar.business.services.tag;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sugar.repository.daos.tag.TagRepository;

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
public class TagServiceImp implements TagService {

	private static final long serialVersionUID = 6242024671104079731L;

	private final Logger log = LoggerFactory.getLogger(TagServiceImp.class);

	@Autowired
	private TagRepository repository;

	public TagServiceImp() {
		super();
	}

	public Logger getLog() {
		return log;
	}

	public TagRepository getRepository() {
		return repository;
	}

}
