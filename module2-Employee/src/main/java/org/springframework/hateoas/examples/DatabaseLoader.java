/*
 * Copyright 2017 the original author or authors.
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
package org.springframework.hateoas.examples;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
class DatabaseLoader {
	@Bean
	CommandLineRunner init(EmployeeRepository repository) {

		return args -> {
			repository.save(new Employee("Andy", "Tagne", "Student", "andy@gmail.com", "", "0644444444"));
			repository.save(new Employee("Yannis", "Boughali", "Student", "yannis@gmail.com", "yannisboughali.com", "0600000000"));
		};
	}

}
