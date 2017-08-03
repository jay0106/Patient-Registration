// This class is a controller class for Patient 

package patient.info.office.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import patient.info.office.entity.Patient;
import patient.info.office.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping("/list")
	public String listPatients(Model theModel) {
		
		// get the patients from the patient service
		List<Patient> thePatients = patientService.getPatients();
		
		theModel.addAttribute("patients", thePatients);
		return "list-patients";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Patient thePatient = new Patient();
		theModel.addAttribute("patient", thePatient);
		return "patient-form";
	}
	
	@PostMapping("/savePatient")
	public String savePatient(@Valid @ModelAttribute("patient") 
				Patient thePatient, BindingResult theBindingResult) {
		
		// there are errors submitting the form
		if (theBindingResult.hasErrors()) {
			return "patient-form";
		}
		patientService.savePatient(thePatient);
		return "redirect:/patient/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("patientID") int theId,
									Model theModel) {
		// get the patient from the service
		Patient thePatient = patientService.getPatient(theId);
		
		// set patient as a model attribute to pre-populate the form
		theModel.addAttribute("patient", thePatient);
		
		// send over to form
		return "patient-form";
	}
	
	@GetMapping("/delete") 
	public String deletePatient(@RequestParam("patientID") int theId,
								Model theModel) {		
		// delete the patient 
		patientService.deletePatient(theId);	
		
		return "redirect:/patient/list";
	}
	
	@PostMapping("/search")
	public String searchpatients(
			@RequestParam("theSearchName") String theSearchName, Model theModel) {
		
		// search patient from the service
		List<Patient> thePatients = patientService.searchPatients(theSearchName);
		
		// add patients to the model
		theModel.addAttribute("patients", thePatients);
		
		return "list-patients";
	}
	
}
