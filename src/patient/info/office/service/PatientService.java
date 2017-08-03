package patient.info.office.service;

import java.util.List;

import patient.info.office.entity.Patient;

public interface PatientService {

	List<Patient> getPatients();

	void savePatient(Patient thePatient);

	Patient getPatient(int theId);

	void deletePatient(int theId);

	List<Patient> searchPatients(String theSearchName);
}
