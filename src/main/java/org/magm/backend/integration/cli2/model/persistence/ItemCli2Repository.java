package org.magm.backend.integration.cli2.model.persistence;

import org.magm.backend.integration.cli2.model.ItemCli2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCli2Repository extends JpaRepository<ItemCli2, Long>{

}
