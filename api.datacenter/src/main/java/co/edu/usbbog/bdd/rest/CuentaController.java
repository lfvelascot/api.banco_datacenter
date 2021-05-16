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
import co.edu.usbbog.bdd.model.Cuenta;
import co.edu.usbbog.bdd.repository.ICuenta;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
	@Autowired
	private ICuenta ic;

	
	//GET POST PUT DELETE ---> 200 = OK, 400, 404
	

	@PostMapping("/create") //localhost:3001/ciudad/create
	public void insertCuenta(@RequestBody Cuenta c) {
		ic.save(c);
	}
	
	@GetMapping("/all")
	public List<Cuenta>findAllCuentas() {
		return ic.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Cuenta> findCuenta(@PathVariable("id") long id) {
		return ic.findById(id);
	}
	
	@GetMapping("/count")
	public long coundCuenta() {
		return ic.count();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCuenta(@PathVariable("id") long id) {
		ic.deleteById(id);
	}
	
	@PutMapping("/update")
	public void updateCuenta(@RequestBody Cuenta c) {
		ic.save(c);
	}
}
