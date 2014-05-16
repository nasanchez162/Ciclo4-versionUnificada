package co.edu.uniandes.csw.item.master.logic.ejb;

import co.edu.uniandes.csw.item.master.logic.api.IItemMasterLogicService;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Default
@Stateless
@LocalBean
public class ItemMasterLogicService extends _ItemMasterLogicService implements IItemMasterLogicService {

}