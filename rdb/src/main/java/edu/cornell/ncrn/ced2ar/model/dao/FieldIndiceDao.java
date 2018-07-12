package edu.cornell.ncrn.ced2ar.model.dao;

import java.util.List;

import edu.cornell.ncrn.ced2ar.model.FieldIndice;
import edu.cornell.ncrn.ced2ar.model.FieldIndicePK;

public interface FieldIndiceDao extends BaseRepository<FieldIndice, FieldIndicePK> {
	public List<FieldIndice> findById_FieldInstId(Long id);
}
