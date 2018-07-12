package edu.cornell.ncrn.ced2ar.model.testing;
/**
 * @author Brandon Elam Barker
 * @date 8/12/2016
 */


import edu.cornell.ncrn.ced2ar.model.dao.FieldDao;
import edu.cornell.ncrn.ced2ar.model.dao.MappingDao;
import edu.cornell.ncrn.ced2ar.model.dao.ProfileDao;
import edu.cornell.ncrn.ced2ar.model.dao.SchemaDao;
import edu.cornell.ncrn.ced2ar.model.Field;
import edu.cornell.ncrn.ced2ar.model.Mapping;
import edu.cornell.ncrn.ced2ar.model.MappingPK;
import edu.cornell.ncrn.ced2ar.model.Schema;
import edu.cornell.ncrn.ced2ar.model.SchemaPK;
import edu.cornell.ncrn.ced2ar.model.testing.DBChecker;
import org.junit.gen5.api.Test;
//TODO: might need to be import org.junit.Test;

import java.util.List;
import static org.junit.gen5.api.Assertions.assertEquals;


public class DBTester extends DBChecker {

    @Test
    public void mappingsIterate() {
        List<Mapping> mappings = mappingDao.findAll();


        long nullSchemaEntries = mappings.stream().map(m -> m.getSchema() == null)
                .filter(b -> b).count();
        assertEquals(0L, nullSchemaEntries);


        long nullFieldEntries = mappings.stream().map(m -> m.getField() == null)
                .filter(b -> b).count();
        assertEquals(0L, nullFieldEntries);


    }
}
