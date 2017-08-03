// This class Implements Patient DAO

package patient.info.office.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import patient.info.office.entity.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Patient> getPatients() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Patient> theQuery = 
				currentSession.createQuery("from Patient order by lastName", Patient.class);
				
		List<Patient> patients = theQuery.getResultList();
		
		return patients;
	}

	@Override
	public void savePatient(Patient thePatient) {
		Session currentSession = sessionFactory.getCurrentSession();		
		currentSession.saveOrUpdate(thePatient);		
	}

	@Override
	public Patient getPatient(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Patient thePatient = currentSession.get(Patient.class, theId);
		return thePatient;
	}

	@Override
	public void deletePatient(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Patient where patientID =:patientID");
		theQuery.setParameter("patientID", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public List<Patient> searchPatients(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery("from Patient where "
					+ "lower(firstName) like :theName or "
					+ "lower(lastName) like :theName", Patient.class);
			
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			theQuery = currentSession.createQuery("from Patient order by lastName", Patient.class);
		}
		
		List<Patient> patients = theQuery.getResultList();
		
		return patients;	
	}

}
