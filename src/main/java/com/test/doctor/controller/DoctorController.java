package com.test.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.doctor.Doctors.Doctor;
import com.test.doctor.exception.DetailsNotFoundException;
import com.test.doctor.service.DoctorService;

@RestController
public class DoctorController {
	
	
	@Autowired
	public DoctorService docservice;
	

	@RequestMapping("/sortdoctor")
	public List<Doctor> getAllDoctors()
	{
		List<Doctor> doctor=docservice.getAllDoctors();
		
		if(doctor.size()<=0)
			throw new DetailsNotFoundException("Sorry Doctors are not Present in Database.Database is Empty");
		return doctor;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/doctor")
	public void addDoctor(@RequestBody Doctor doctor)
	{
		docservice.addDoctor(doctor);
	}
	
	
	
	@RequestMapping(method =RequestMethod.PUT , value="/doctor/{id}/salary/{salary}" )
	public void updateDoctor(@PathVariable Integer id, @PathVariable Double salary)
	{
		docservice.UpdateDoctor(id, salary);
		
	}


}
