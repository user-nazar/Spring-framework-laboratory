package ua.lviv.iot.machinery.spring.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.machinery.spring.manager.Machinery;

@RequestMapping("/machinery")
@RestController
public class MachineryController {
	private static Map<Integer, Machinery> machineryHashMap = new HashMap<>();
	private static AtomicInteger idCounter = new AtomicInteger();

	@GetMapping
	public List<Machinery> getMachinery() {
		return new LinkedList<>(machineryHashMap.values());
	}

	@GetMapping(path = "/{id}")
	ResponseEntity<Object> getMachinery(final @PathVariable("id") Integer machineryId) {

		Machinery machinery = machineryHashMap.get(machineryId);

		ResponseEntity<Object> response = machinery == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(machinery, HttpStatus.OK);

		return response;
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public Machinery createMachinery(final @RequestBody Machinery machinery) {

		machinery.setId(idCounter.incrementAndGet());

		machineryHashMap.put(machinery.getId(), machinery);

		return machinery;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteMachinery(final @PathVariable("id") Integer machineryId) {
		HttpStatus status = machineryHashMap.remove(machineryId) == null ? HttpStatus.NOT_FOUND

				: HttpStatus.OK;
		return ResponseEntity.status(status).build();
	}

	@PutMapping(path = "/{id}")

	public ResponseEntity<Object> updateMachinery(final @PathVariable("id") Integer machineryId,
			final @RequestBody Machinery machinery) {

		machinery.setId(machineryId);

		ResponseEntity<Object> response = machineryHashMap.put(machineryId, machinery) == null
				? new ResponseEntity<>(HttpStatus.NOT_FOUND)

				: new ResponseEntity<>(machinery, HttpStatus.OK);

		return response;
	}
}