package co.edu.usbbog.bdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.usbbog.bdd.model.Ciudad;

public interface ICiudad extends JpaRepository<Ciudad, Long> {

}
