package co.edu.usbbog.bdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.usbbog.bdd.model.Auditoria;

public interface IAuditoria extends JpaRepository<Auditoria, Long>{

}
