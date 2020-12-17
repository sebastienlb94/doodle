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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
class EmployeeController {

	private final EmployeeRepository repository;

	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/votes")
	ResponseEntity<CollectionModel<EntityModel<Vote>>> findAll() {

		List<EntityModel<Vote>> employeeResources = StreamSupport.stream(repository.findAll().spliterator(), false)
				.map(vote -> EntityModel.of(vote,
						linkTo(methodOn(EmployeeController.class).findOne(vote.getId())).withSelfRel()
								.andAffordance(afford(methodOn(EmployeeController.class).updateEmployee(null, vote.getId())))
								.andAffordance(afford(methodOn(EmployeeController.class).deleteEmployee(vote.getId()))),
						linkTo(methodOn(EmployeeController.class).findAll()).withRel("employees")))
				.collect(Collectors.toList());

		return ResponseEntity.ok(CollectionModel.of( //
				employeeResources, //
				linkTo(methodOn(EmployeeController.class).findAll()).withSelfRel()
						.andAffordance(afford(methodOn(EmployeeController.class).newEmployee(null)))));
	}

	@PostMapping("/votes")
	ResponseEntity<?> newEmployee(@RequestBody Vote vote) {

		Vote savedVote = repository.save(vote);

		return EntityModel.of(savedVote,
				linkTo(methodOn(EmployeeController.class).findOne(savedVote.getId())).withSelfRel()
						.andAffordance(afford(methodOn(EmployeeController.class).updateEmployee(null, savedVote.getId())))
						.andAffordance(afford(methodOn(EmployeeController.class).deleteEmployee(savedVote.getId()))),
				linkTo(methodOn(EmployeeController.class).findAll()).withRel("employees")).getLink(IanaLinkRelations.SELF)
						.map(Link::getHref) //
						.map(href -> {
							try {
								return new URI(href);
							} catch (URISyntaxException e) {
								throw new RuntimeException(e);
							}
						}) //
						.map(uri -> ResponseEntity.noContent().location(uri).build())
						.orElse(ResponseEntity.badRequest().body("Unable to create " + vote));
	}

	@GetMapping("/votes/{id}")
	ResponseEntity<EntityModel<Vote>> findOne(@PathVariable long id) {

		return repository.findById(id)
				.map(vote -> EntityModel.of(vote,
						linkTo(methodOn(EmployeeController.class).findOne(vote.getId())).withSelfRel()
								.andAffordance(afford(methodOn(EmployeeController.class).updateEmployee(null, vote.getId())))
								.andAffordance(afford(methodOn(EmployeeController.class).deleteEmployee(vote.getId()))),
						linkTo(methodOn(EmployeeController.class).findAll()).withRel("employees")))
				.map(ResponseEntity::ok) //
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/votes/{id}")
	ResponseEntity<?> updateEmployee(@RequestBody Vote vote, @PathVariable long id) {

		Vote voteToUpdate = vote;
		voteToUpdate.setId(id);

		Vote updatedVote = repository.save(voteToUpdate);

		return EntityModel.of(updatedVote,
				linkTo(methodOn(EmployeeController.class).findOne(updatedVote.getId())).withSelfRel()
						.andAffordance(afford(methodOn(EmployeeController.class).updateEmployee(null, updatedVote.getId())))
						.andAffordance(afford(methodOn(EmployeeController.class).deleteEmployee(updatedVote.getId()))),
				linkTo(methodOn(EmployeeController.class).findAll()).withRel("employees")).getLink(IanaLinkRelations.SELF)
						.map(Link::getHref).map(href -> {
							try {
								return new URI(href);
							} catch (URISyntaxException e) {
								throw new RuntimeException(e);
							}
						}) //
						.map(uri -> ResponseEntity.noContent().location(uri).build()) //
						.orElse(ResponseEntity.badRequest().body("Unable to update " + voteToUpdate));
	}

	@DeleteMapping("/votes/{id}")
	ResponseEntity<?> deleteEmployee(@PathVariable long id) {

		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}
