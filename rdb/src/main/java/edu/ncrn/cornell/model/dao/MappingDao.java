package edu.cornell.ncrn.ced2ar.model.dao;

import java.util.List;

import edu.cornell.ncrn.ced2ar.model.Mapping;
import edu.cornell.ncrn.ced2ar.model.MappingPK;

public interface MappingDao extends BaseRepository<Mapping, MappingPK> {
	
	List<Mapping> findById_FieldId(String field_id);
}
