package br.rafael;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String template = "Help, %s!";
	private final AtomicLong count = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greenting greenting(
			@RequestParam(value = "name", defaultValue = "World")
			String name) {
		return new Greenting(count.incrementAndGet(), String.format(template, name));
	}

}
