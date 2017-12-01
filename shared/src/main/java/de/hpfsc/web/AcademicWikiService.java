package de.hpfsc.web;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hpfsc.web.AcademicWikiModel;
@RemoteServiceRelativePath("academicwiki")
public interface AcademicWikiService extends RemoteService {
	public void saveOrUpdate(AcademicWikiModel book) throws Exception;
	
	public void delete(AcademicWikiModel book) throws Exception;
	
	public AcademicWikiModel find(long id);
	
	public List<AcademicWikiModel> findAllEntries();

}
