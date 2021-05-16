package co.edu.usbbog.bdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.usbbog.bdd.model.Cuenta;

public interface ICuenta extends JpaRepository<Cuenta, Long>{

}
