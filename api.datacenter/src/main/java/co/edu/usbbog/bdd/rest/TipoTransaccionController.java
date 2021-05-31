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
import co.edu.usbbog.bdd.model.TipoTransaccion;
import co.edu.usbbog.bdd.repository.ITipoTransaccion;

@RestController
@RequestMapping("/tipotransaccion")
public class TipoTransaccionController {
	@Autowired
	private ITipoTransaccion itt;
	
	@PostMapping("/create") 
	public void insertTipoTransaccion(@RequestBody TipoTransaccion tt) {
		itt.save(tt);
	}
	
	@GetMapping("/all")
	public List<TipoTransaccion>findAllTipoTransacciones() {
		List<TipoTransaccion> l = itt.findAll();
		if (l.isEmpty() || l.equals(null)) {
			throw new RuntimeException("No hay tipos de transacciones registradas");
		} else {
			return l;
		}
	}
	
	@GetMapping("/find/{id}")
	public Optional<TipoTransaccion> findTipoTransaccion(@PathVariable("id") long id) {
		Optional<TipoTransaccion> tt = itt.findById(id);
		if (!tt.equals(null)) {
			return tt;
		}else {
            throw new RuntimeException("Tipo de Tramsaccion identificada con el ID: "+id+" no encontrado");
		}
	}
	
	@GetMapping("/count")
	public long coundTipoTransacciones() {
		long c =  itt.count();
		if (c != 0) {
			return c;
		} else {
            throw new RuntimeException("No hay tipos de transacciones registradas");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTipoTransaccion(@PathVariable("id") long id) {
		Optional<TipoTransaccion> tt = itt.findById(id);
		if (!tt.equals(null)) {
			itt.deleteById(id);
		}else {
            throw new RuntimeException("Tipo de Tramsaccion identificada con el ID: "+id+" no encontrado");
		}
	}
	
	@PutMapping("/update")
	public void updateTipoTransaccion(@RequestBody TipoTransaccion tt) {
		Optional<TipoTransaccion> t = itt.findById(tt.getId());
		if (!t.equals(null)) {
			itt.save(tt);
		}else {
            throw new RuntimeException("Tipo de Tramsaccion identificada con el ID: "+tt.getId()+" no encontrado");
		}
	}
}
