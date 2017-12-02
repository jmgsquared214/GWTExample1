package de.hpfsc.web;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("academicdao")
@Transactional
public class AcademicWikiDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void persist(AcademicWikiModel entity) {
	}

	public void remove(Long entity) {
		Session session = this.sessionFactory.getCurrentSession();
		AcademicWikiModel model = new AcademicWikiModel();
		 model = (AcademicWikiModel)session.load(AcademicWikiModel.class,entity);
		session.delete(model);
	}

	public AcademicWikiModel merge(AcademicWikiModel entity) {
		return null;
	}

	public void refresh(AcademicWikiModel entity) {
	}

	public AcademicWikiModel findById(Long id) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<de.hpfsc.web.AcademicWikiModel> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<de.hpfsc.web.AcademicWikiModel> personsList = session.createQuery("from AcademicWikiModel").list();
		return personsList;
	}
	
	public void saveOrUpdate(AcademicWikiModel entity) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
	}
}