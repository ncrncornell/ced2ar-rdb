package edu.cornell.ncrn.ced2ar.model.dao;


import java.util.List;

import edu.cornell.ncrn.ced2ar.model.Schema;
import edu.cornell.ncrn.ced2ar.model.SchemaPK;

public interface SchemaDao extends BaseRepository<Schema, SchemaPK> {
	public List<Schema> findById_Version(String version);
}
