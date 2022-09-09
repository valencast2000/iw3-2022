package org.magm.backend.integration.cli2.model.persistence;

import java.util.List;
import java.util.Optional;

import org.magm.backend.integration.cli2.model.FacturaCli2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaCli2Repository extends JpaRepository<FacturaCli2, Long> {
	
	Optional<FacturaCli2> findOneByNumero(Long numero);
	
	@Query(value="SELECT * FROM cli2_facturas WHERE anulada=0", nativeQuery = true)
	public List<FacturaCli2> FindAllFacturaCli2Anulada();

}