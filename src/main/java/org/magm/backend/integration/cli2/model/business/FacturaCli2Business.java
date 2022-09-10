package org.magm.backend.integration.cli2.model.business;

import java.util.List;
import java.util.Optional;

import org.magm.backend.integration.cli2.model.FacturaCli2;
import org.magm.backend.integration.cli2.model.persistence.FacturaCli2Repository;
import org.magm.backend.model.business.BusinessException;
import org.magm.backend.model.business.FoundException;
import org.magm.backend.model.business.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FacturaCli2Business implements IFacturaCli2Business {

	@Autowired
	private FacturaCli2Repository facturaCli2DAO;
	
	
	@Override
	public FacturaCli2 load(long numero) throws NotFoundException, BusinessException {
		Optional<FacturaCli2> r;
		try {
			r=facturaCli2DAO.findOneByNumero(numero);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
		if(r.isEmpty()) {
			throw NotFoundException.builder().message("No se encuentra la factura numero=" + numero).build();
		}
			
		return r.get();
	}

	
	@Override
	public List<FacturaCli2> list() throws BusinessException {
		try {
			return facturaCli2DAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
	}

	
	@Override
	public List<FacturaCli2> listNoAnulada() throws BusinessException {
		try {
			return facturaCli2DAO.FindAllFacturaCli2NoAnulada();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
	}

	
	@Override
	public FacturaCli2 add(FacturaCli2 facturaCli2) throws FoundException, BusinessException {
		try {
			load(facturaCli2.getNumero());
			throw FoundException.builder().message("Se encontró la factura de numero=" + facturaCli2.getNumero()).build();
		} catch (NotFoundException e) {}
		
		try {
			return facturaCli2DAO.save(facturaCli2);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
	}

	
	@Override
	public FacturaCli2 update(FacturaCli2 facturaCli2) throws NotFoundException, BusinessException {
		try {
			load(facturaCli2.getNumero());
			return facturaCli2DAO.save(facturaCli2);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
	}

	public FacturaCli2 anularFacturaCli2(long numero) throws NotFoundException, BusinessException {
		try {
			FacturaCli2 facturaCli2 = load(numero);
			facturaCli2.setAnulada(true);
			return facturaCli2DAO.save(facturaCli2);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
		
	}
	
	@Override
	public void delete(long numero) throws NotFoundException, BusinessException {
		FacturaCli2 r;
		r = load(numero);
		try {
			 facturaCli2DAO.deleteById(r.getId());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
		
	}

}
