package de.hpfsc.web;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
  String greetServer(String name) throws IllegalArgumentException;
  public void saveOrUpdate(AcademicWikiModel book) throws Exception;
	
	public void delete(AcademicWikiModel book) throws Exception;
	
	public AcademicWikiModel find(long id);
	
	public List<AcademicWikiModel> findAllEntries();
}
