package patient.info.office.dao;

import java.util.List;

import patient.info.office.entity.Patient;

public interface PatientDAO {

	public List<Patient> getPatients();

	public void savePatient(Patient thePatient);

	public Patient getPatient(int theId);

	public void deletePatient(int theId);

	public List<Patient> searchPatients(String theSearchName);	
}
