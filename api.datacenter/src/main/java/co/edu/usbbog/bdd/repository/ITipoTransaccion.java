package co.edu.usbbog.bdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.usbbog.bdd.model.TipoTransaccion;

public interface ITipoTransaccion extends JpaRepository<TipoTransaccion, Long>{

}
