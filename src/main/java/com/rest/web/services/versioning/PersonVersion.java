package com.rest.web.services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersion {
	
	/* URI versioning*/ /*twitter*/
	@GetMapping("/person/v1")
	public PersonV1 personV1() {
		return new PersonV1("Vikas Pal");
	}

	@GetMapping("/person/v2")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Vikas", "Pal"));
	}

	/* requestParam versioning*/ /*amazon*/
	@GetMapping(value = "/person", params = "Version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Vikas Pal");
	}

	@GetMapping(value="/person", params = "Version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Vikas", "Pal"));
	}
	
	/* header versioning*/	/*microsoft*/
	@GetMapping(value = "/person", headers="X-api-Version=1")
	public PersonV1 headerV1() {
		return new PersonV1("Vikas Pal");
	}

	@GetMapping(value="/person", headers="X-api-Version=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Vikas", "Pal"));
	}
	
	/* MIME versioning*/ /*github*/
	@GetMapping(value = "/person", produces="application/v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Vikas Pal");
	}

	@GetMapping(value="/person", produces="application/v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Vikas", "Pal"));
	}
}
