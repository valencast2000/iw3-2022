package org.magm.backend.integration.cli2.model.business;

import java.util.List;

import org.magm.backend.integration.cli2.model.FacturaCli2;
import org.magm.backend.model.business.BusinessException;
import org.magm.backend.model.business.FoundException;
import org.magm.backend.model.business.NotFoundException;

public interface IFacturaCli2Business {
	public FacturaCli2 load(long numero) throws NotFoundException, BusinessException;
	
	public List<FacturaCli2> list() throws BusinessException;
	
	public List<FacturaCli2> listNoAnulada() throws BusinessException;

	public FacturaCli2 add(FacturaCli2 facturaCli2) throws FoundException, BusinessException;

	public FacturaCli2 update(FacturaCli2 facturaCli2) throws NotFoundException, BusinessException;
	
	public FacturaCli2 anularFacturaCli2(long numero) throws NotFoundException, BusinessException;
	
	public FacturaCli2 desanularFacturaCli2(long numero) throws NotFoundException, BusinessException;

	public void delete(long numero) throws NotFoundException, BusinessException;

}
