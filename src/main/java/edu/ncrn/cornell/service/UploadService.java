package edu.ncrn.cornell.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.common.hash.Hashing;
import edu.ncrn.cornell.model.dao.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ncrn.cornell.model.Schema;
import edu.ncrn.cornell.model.Field;
import edu.ncrn.cornell.util.XMLHandle;
import org.springframework.stereotype.Service;


/**
 * Class to handle the upload mechanisms of new codebooks:
 * Upon upload, cascade new data into the field_inst and field indices tables
 * Also check for new schemas.
 * @author kylebrumsted
 *
 */

@Service
public class UploadService {
	
	//Autowired DAOs
	@Autowired
	private FieldInstDao fieldInstDao;
	@Autowired
	private FieldIndicyDao fieldIndicyDao;
	@Autowired
	private FieldDao fieldDao;
    @Autowired
    private RawDocDao rawDocDao;
	@Autowired
	private SchemaDao schemaDao;
	@Autowired
	private MappingDao mappingDao;
	
	//Other private members
	private static final String DEFAULT_SCHEMA_VERSION = "2.5";

    private Optional<Boolean> uploadIsValid = Optional.empty();

    private Optional<Boolean> importSucceded = Optional.empty();


    /**
	 * hook function to be called by UploadController for a new XML codebook
	 * @param f
	 * @return
	 */
	public void newUpload(File f){
		//Convert file to string
		String xmlString = "";
		try{
			xmlString = FileUtils.readFileToString(f);
		}catch (IOException e) {
			//TODO: return to controller with message.
			e.printStackTrace();
		}
		
		//Validate
		//TODO: clean namespaces for new documents
		List<Schema> schemas = schemaDao.findById_Version(DEFAULT_SCHEMA_VERSION);
		Schema schema = schemas.get(0);
		String schemaURL = schema.getUrl();
		XMLHandle xhandle = new XMLHandle(xmlString, schemaURL);
		if(!xhandle.isValid()) {
            uploadIsValid = Optional.of(false);
            //TODO: delete file and redirect with error message
            return;
        }

        //if file is valid, proceed:

        // Note, we use a hash value of the input xml rather than normalized xml;
        // This is meant to be a simple check rather than a rigorous constraint.
        final String xmlHash = Hashing.sha256()
            .hashString(xmlString, StandardCharsets.UTF_8).toString();

        System.out.println("xmlHash is " + xmlHash);


        // persist rawdoc in database, so that we have it on record
        // TODO

		// parse the rawdoc into fields
		importSucceded = Optional.of(updateFieldInsts(xhandle));

	}
	
	/**
	 * fills SQL tables from XML codebook
	 * @param xhdl
	 * @return
	 */
	private boolean updateFieldInsts(XMLHandle xhdl){
		List<Field> fields = fieldDao.findAll();
		/*
		 * iterate over fields
		 * get mapping for each one
		 * eval xpath on codebook and get value(s) at each xpath location
		 * insert into fieldInst table
		 * convert xpath to refer to specific value
		 * 	  (i.e. /codeBook/dataDsc/var/varlabl -> /codeBook/dataDscr/var[@name='age']/labl
		 * insert as index into fieldIndicy table
		 * 
		 */
		
		
		return false;
	}
	
	
}
