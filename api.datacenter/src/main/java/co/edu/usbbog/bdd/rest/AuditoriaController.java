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

	@PostMapping("/create")
	public void insertTransaccion(@RequestBody Auditoria a) {
		ia.save(a);
	}

	@GetMapping("/all")
	public List<Auditoria> findAllTransacciones() {
		List<Auditoria> l = ia.findAll();
		if (l.isEmpty() || l.equals(null)) {
			throw new RuntimeException("No hay auditorias registradas");
		} else {
			return l;
		}
	}

	@GetMapping("/find/{id}")
	public Optional<Auditoria> findTransaccion(@PathVariable("id") long id) {
		Optional<Auditoria> t = ia.findById(id);
		if (!t.equals(null)) {
			return t;
		} else {
			throw new RuntimeException("Auditoria identificada con el ID: " + id + " no encontrado");
		}
	}

	@GetMapping("/count")
	public long coundTransaccion() {
		long c = ia.count();
		if (c == 0) {
			return c;
		} else {
			throw new RuntimeException("No hay auditorias registradas");
		}
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTransaccion(@PathVariable("id") long id) {
		Optional<Auditoria> t = ia.findById(id);
		if (!t.equals(null)) {
			ia.deleteById(id);
		} else {
			throw new RuntimeException("Tramsaccion identificada con el ID: " + id + " no encontrado");
		}
	}

	@PutMapping("/update")
	public void updateTransaccion(@RequestBody Auditoria a) {
		Optional<Auditoria> t = ia.findById(a.getId());
		if (!t.equals(null)) {
			ia.save(a);
		} else {
			throw new RuntimeException("Tramsaccion identificada con el ID: " + a.getId() + " no encontrado");
		}
	}
}
