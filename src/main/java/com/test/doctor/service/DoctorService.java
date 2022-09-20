package com.test.doctor.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.doctor.Doctors.Doctor;
import com.test.doctor.exception.DetailsNotFoundException;
import com.test.doctor.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	public DoctorRepository docRepo;
	
	
	
	public List<Doctor> getAllDoctors()
	{
		List<Doctor> doctors=new ArrayList<>();
		docRepo.findAll().forEach(doctors::add);
		Collections.sort(doctors);
		return  doctors;
	}
	
	public void addDoctor(Doctor doctor)
    {
		Doctor existingDoctor = docRepo.findById(doctor.getId()).orElse(null);
        if (existingDoctor == null)
        {
        	docRepo.save(doctor);
           
        }
        else
            throw new DetailsNotFoundException("ID already exists in Database!! Updation Failed");
                
    }
	
	public void UpdateDoctor(Integer id, Double salary) {
		// TODO Auto-generated method stub

		Doctor existingDoctor = docRepo.findById(id).get();

		if (existingDoctor != null) {
			existingDoctor.setSalary(salary);
			docRepo.save(existingDoctor);
		}
	}

}
