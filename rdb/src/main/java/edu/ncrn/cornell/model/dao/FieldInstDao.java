package edu.cornell.ncrn.ced2ar.model.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.cornell.ncrn.ced2ar.model.FieldInst;

public interface FieldInstDao extends JpaRepository<FieldInst, Long> {
	public List<FieldInst> findByRawDocIdAndFieldId(String rawDocId, String fieldId);
	public List<FieldInst> findByRawDocIdAndCanonicalXpath(String rawDocId, String canonicalXpath);
	public List<FieldInst> findByRawDocIdAndValue(String rawDocId, String value);
	public List<FieldInst> findByFieldId(String fieldId);
	public Page<FieldInst> findByFieldId(String fieldId, Pageable pageAble);
	public List<FieldInst> findByFieldIdAndRawDocIdIn(String fieldId, List<String> rawDocIdList);
	public Page<FieldInst> findByFieldIdAndRawDocIdIn(String fieldId, List<String> rawDocIdList, Pageable pageable);
	public List<FieldInst> findByCanonicalXpath(String canonicalXpth);
}
