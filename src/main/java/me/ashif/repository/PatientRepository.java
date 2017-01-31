package me.ashif.repository;

import me.ashif.model.PatientModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by asif on 31/1/17.
 */

@Repository
public interface PatientRepository extends CrudRepository<PatientModel,Integer>{
}
