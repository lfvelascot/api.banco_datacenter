package co.edu.usbbog.bdd.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.bdd.model.Auditoria;
import co.edu.usbbog.bdd.repository.IAuditoria;

@RestController
@RequestMapping("/auditoria")
public class AuditoriaController {

	@Autowired
	IAuditoria ia;
	
	@PostMapping("/create") //localhost:3001/ciudad/create
	public void insertTransaccion(@RequestBody Auditoria a) {
		ia.save(a);
	}
	
	@GetMapping("/all")
	public List<Auditoria>findAllTransacciones() {
		return ia.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Auditoria> findTransaccion(@PathVariable("id") long id) {
		return ia.findById(id);
	}
	
	@GetMapping("/count")
	public long coundTransaccion() {
		return ia.count();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTransaccion(@PathVariable("id") long id) {
		ia.deleteById(id);
	}
	
	@PutMapping("/update")
	public void updateTransaccion(@RequestBody Auditoria a) {
		ia.save(a);
	}
	
}
