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

	@PostMapping("/create") 
	public void insertCuenta(@RequestBody Cuenta c) {
		ic.save(c);
	}
	
	@GetMapping("/all")
	public List<Cuenta>findAllCuentas() {
		List<Cuenta> l = ic.findAll();
		if (l.isEmpty() || l.equals(null)) {
			throw new RuntimeException("No hay cuentas registradas");
		} else {
			return l;
		}
	}
	
	@GetMapping("/find/{id}")
	public Optional<Cuenta> findCuenta(@PathVariable("id") long id) {
		Optional<Cuenta> cu =  ic.findById(id);
		if (!cu.equals(null)) {
			return cu;
		} else {
            throw new RuntimeException("Cuenta identificada con el ID: "+id+" no encontrado");
		}
	}
	
	@GetMapping("/count")
	public long coundCuenta() {
		long c =  ic.count();
		if (c != 0) {
			return c;
		} else {
            throw new RuntimeException("No hay cuentas registradas");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCuenta(@PathVariable("id") long id) {
		Optional<Cuenta> cu =  ic.findById(id);
		if (!cu.equals(null)) {
			ic.deleteById(id);
		} else {
            throw new RuntimeException("Cuenta identificada con el ID: "+id+" no encontrado");
		}
	}
	
	@PutMapping("/update")
	public void updateCuenta(@RequestBody Cuenta c) {
		Optional<Cuenta> cu =  ic.findById(c.getNum());
		if (!cu.equals(null)) {
			ic.save(c);
		} else {
            throw new RuntimeException("Cuenta identificada con el ID: "+c.getNum()+" no encontrado");
		}
		
	}
}
