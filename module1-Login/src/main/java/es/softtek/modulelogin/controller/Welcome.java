package es.softtek.modulelogin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

	@RequestMapping("welcome")
	public String helloWorld(@RequestParam(value="name", defaultValue="M.Van Elsuve") String name) {
		return "Bonjour" +name+ " tu as maintenant accès à notre API. Andy, Sébastien, Yannis";

	}
}
