package edu.cornell.ncrn.ced2ar.model.dao;


import edu.cornell.ncrn.ced2ar.model.Field;
import javax.transaction.Transactional;

@Transactional
public interface FieldDao extends BaseRepository<Field, String> {
	
}
