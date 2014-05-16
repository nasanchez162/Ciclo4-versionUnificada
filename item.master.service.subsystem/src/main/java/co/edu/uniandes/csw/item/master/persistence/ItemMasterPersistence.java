package co.edu.uniandes.csw.item.master.persistence;

import javax.ejb.Stateless;

import co.edu.uniandes.csw.item.master.persistence.api.IItemMasterPersistence;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Default;

@Default
@Stateless 
@LocalBean
public class ItemMasterPersistence extends _ItemMasterPersistence  implements IItemMasterPersistence {

}