package de.hpfsc.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hpfsc.web.AcademicWikiDao;
import de.hpfsc.web.AcademicWikiModel;
import de.hpfsc.web.AcademicWikiService;
public class AcademicWikiServiceImpl extends RemoteServiceServlet implements AcademicWikiService {

	@Autowired
	private AcademicWikiDao academicWikiDao;
	public void saveOrUpdate(AcademicWikiModel book) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void delete(AcademicWikiModel book) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public AcademicWikiModel find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AcademicWikiModel> findAllEntries() {
		//return 	academicWikiDao.findAll();
		return new ArrayList<>();
	}

}
