package edu.cornell.ncrn.ced2ar.model.dao;

import java.util.List;

import edu.cornell.ncrn.ced2ar.model.Profile;
import edu.cornell.ncrn.ced2ar.model.ProfileField;

public interface ProfileFieldDao extends BaseRepository<ProfileField, Integer> {
	
	List<ProfileField> findByProfileId(String Id);
	List<ProfileField> findByProfileIdAndFieldId(String profileId, String fieldId);
	
}
