package com.jman.form_management_project.repository;

import com.jman.form_management_project.entity.FormVersionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormVersionRepository extends JpaRepository<FormVersionDO,Integer> {
    boolean existsByFormVersionNameAndForm_FormId(String formVersionName,int formId);
}
