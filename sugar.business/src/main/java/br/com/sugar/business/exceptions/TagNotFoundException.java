package br.com.sugar.business.exceptions;

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

public class TagNotFoundException extends NoSearchResultException {
	
	private static final long serialVersionUID = -3433440445210014694L;

	public TagNotFoundException() {
		super();
	}

	public TagNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TagNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TagNotFoundException(String message) {
		super(message);
	}

	public TagNotFoundException(Throwable cause) {
		super(cause);
	}

}
