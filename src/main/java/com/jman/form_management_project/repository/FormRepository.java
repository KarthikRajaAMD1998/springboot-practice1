package com.jman.form_management_project.repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jman.form_management_project.entity.FormDO;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<FormDO,Integer > {

    FormDO findByInternalName(String internalName);
}
