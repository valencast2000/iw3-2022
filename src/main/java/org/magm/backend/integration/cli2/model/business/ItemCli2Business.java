package org.magm.backend.integration.cli2.model.business;

import lombok.extern.slf4j.Slf4j;
import org.magm.backend.integration.cli2.model.ItemCli2;
import org.magm.backend.integration.cli2.model.persistence.ItemCli2Repository;
import org.magm.backend.model.business.BusinessException;
import org.magm.backend.model.business.FoundException;
import org.magm.backend.model.business.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ItemCli2Business implements IItemCli2Business{

    @Autowired(required = false)
    private ItemCli2Repository detalleDAO;


    @Override
    public ItemCli2 load(long id) throws NotFoundException, BusinessException {
        Optional<ItemCli2> r;
        try{
            r=detalleDAO.findById(id);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }
        if(r.isEmpty()) {
            throw NotFoundException.builder().message("No se encuentra el item id=" + id).build();
        }
        return r.get();
    }

    
    @Override
    public ItemCli2 add(ItemCli2 item) throws FoundException, BusinessException {
        try {
            load(item.getId());
            throw FoundException.builder().message("Se encontró el detalle id=" + item.getId()).build();
        } catch (NotFoundException e) {}
        try {
            return detalleDAO.save(item);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw BusinessException.builder().ex(e).build();
        }

        
    }
}