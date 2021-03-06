package com.jyothi.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jyothi.shared.AutowiringRemoteServiceServlet;
import com.jyothi.shared.FieldVerifier;
import com.jyothi.web.AcademicWikiDao;
import com.jyothi.web.AcademicWikiModel;
import com.jyothi.web.AcademicWikiService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
@Service
public class AcademicWikiServiceImpl extends AutowiringRemoteServiceServlet implements
    AcademicWikiService {
	
	@Autowired
	private AcademicWikiDao academicWikiDao;
  public String greetServer(String input) throws IllegalArgumentException {
    // Verify that the input is valid.
    if (!FieldVerifier.isValidName(input)) {
      // If the input is not valid, throw an IllegalArgumentException back to
      // the client.
      throw new IllegalArgumentException(
          "Name must be at least 4 characters long");
    }

    String serverInfo = getServletContext().getServerInfo();
    String userAgent = getThreadLocalRequest().getHeader("User-Agent");

    // Escape data from the client to avoid cross-site script vulnerabilities.
    input = escapeHtml(input);
    userAgent = escapeHtml(userAgent);

    return "Hello, " + input + "!<br><br>I am running " + serverInfo
        + ".<br><br>It looks like you are using:<br>" + userAgent;
  }

  /**
   * Escape an html string. Escaping data received from the client helps to
   * prevent cross-site script vulnerabilities.
   *
   * @param html the html string to escape
   * @return the escaped string
   */
  private String escapeHtml(String html) {
    if (html == null) {
      return null;
    }
    return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
        ">", "&gt;");
  }
  
  public void saveOrUpdate(AcademicWikiModel book) throws Exception {
	  academicWikiDao.saveOrUpdate(book);
		
	}

	public void delete(Long book) throws Exception {
		// TODO Auto-generated method stub
		academicWikiDao.remove(book);
	}

	public AcademicWikiModel find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AcademicWikiModel> findAllEntries() {
		WebApplicationContext ctx =
	            WebApplicationContextUtils.getWebApplicationContext(getServletContext());

		AcademicWikiDao dao = (AcademicWikiDao)ctx.getBean(AcademicWikiDao.class);
		 
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
