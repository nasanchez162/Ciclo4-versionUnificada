 
package co.edu.uniandes.csw.item.master.logic.api;

import co.edu.uniandes.csw.item.master.logic.dto.ItemMasterDTO;

public interface _IItemMasterLogicService {

	public ItemMasterDTO createMasterItem(ItemMasterDTO detail);
    public void updateMasterItem(ItemMasterDTO detail);
	public void deleteMasterItem(Long id); 
	public ItemMasterDTO getMasterItem(Long id);
        
}