package me.ashif.service;

import me.ashif.model.PatientModel;
import me.ashif.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asif on 31/1/17.
 */

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public void savePatientInfo(PatientModel patientModel){
        patientRepository.save(patientModel);
    }

    public List<PatientModel> getPatientsList(){
        return (List<PatientModel>) patientRepository.findAll();
    }

    public void deletePatient(Integer id){
        PatientModel model = patientRepository.findOne(id);
        patientRepository.delete(model);
    }

    /**
     *  PurchaseModel model = purchaseRepository.findOne(id);
     *  model = p;
     *  purchaseRepository.save(p);
     */

    public void updatePatient(PatientModel patientModel,Integer id){
        PatientModel model = patientRepository.findOne(id);
        model = patientModel;
        patientRepository.save(patientModel);
    }
}
