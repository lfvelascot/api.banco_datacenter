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
	
	//GET POST PUT DELETE ---> 200 = OK, 400, 404
	

	@PostMapping("/create") //localhost:3001/TipoTransaccion/create
	public void insertTipoTransaccion(@RequestBody TipoTransaccion tt) {
		itt.save(tt);
	}
	
	@GetMapping("/all")
	public List<TipoTransaccion>findAllTipoTransacciones() {
		return itt.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<TipoTransaccion> findTipoTransaccion(@PathVariable("id") long id) {
		return itt.findById(id);
	}
	
	@GetMapping("/count")
	public long coundTipoTransacciones() {
		return itt.count();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTipoTransaccion(@PathVariable("id") long id) {
		itt.deleteById(id);
	}
	
	@PutMapping("/update")
	public void updateTipoTransaccion(@RequestBody TipoTransaccion tt) {
		itt.save(tt);
	}
}
