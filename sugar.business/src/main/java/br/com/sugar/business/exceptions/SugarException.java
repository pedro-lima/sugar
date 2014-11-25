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

public class SugarException extends Exception {

	private static final long serialVersionUID = -6970011401131583947L;

	public SugarException() {
		super();
	}

	public SugarException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SugarException(String message, Throwable cause) {
		super(message, cause);
	}

	public SugarException(String message) {
		super(message);
	}

	public SugarException(Throwable cause) {
		super(cause);
	}

}
