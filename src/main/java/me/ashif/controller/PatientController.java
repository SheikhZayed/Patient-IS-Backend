package me.ashif.controller;

import me.ashif.model.PatientModel;
import me.ashif.response.Error;
import me.ashif.response.Success;
import me.ashif.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by asif on 31/1/17.
 */

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private Success successService;
    @Autowired
    private Error errorService;

    @RequestMapping(value = "patient",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Object addPatient(PatientModel patientModel, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            errorService.setCode(-1);
            errorService.setMessage("Improper data passed as parameter");
            errorService.setCause("validation of some fields failed");
            return errorService;
        }
        else
        patientService.savePatientInfo(patientModel);
        successService.setCode(1);
        successService.setMessage("Save complete");
        return successService;
    }

    @RequestMapping("/patients")
    @CrossOrigin
    public Object getPatientList(){
        ArrayList<PatientModel> patientList = (ArrayList<PatientModel>) patientService.getPatientsList();
        if (patientList.size() == 0){
            errorService.setCode(-1);
            errorService.setMessage("No Data Found");
            errorService.setCause("Try Adding some data to DB");
            return errorService;
        }
        else
            return patientList;
    }

    @RequestMapping(value = "/patient/{id}",method = RequestMethod.DELETE)
    @CrossOrigin
    public Object deletePatient(@PathVariable("id") int id){
        patientService.deletePatient(id);
        successService.setCode(1);
        successService.setMessage("Delete Success");
        return successService;
    }

    @RequestMapping(value = "/patient/{id}",method = RequestMethod.PUT)
    @CrossOrigin
    @ResponseBody
    public Object updatePatient(PatientModel patientModel,@PathVariable("id") int id,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            errorService.setCode(-1);
            errorService.setMessage("Improper data passed as parameter");
            errorService.setCause("validation of some fields failed");
            return errorService;
        }
        else
        patientService.updatePatient(patientModel,id);
        successService.setCode(1);
        successService.setMessage("Update complete");
        return successService;
    }
}
