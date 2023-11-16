package com.jman.form_management_project.service.implementation;

import com.jman.form_management_project.common.MyResponse;
import com.jman.form_management_project.entity.FormDO;
import com.jman.form_management_project.entity.FormVersionDO;
import com.jman.form_management_project.repository.FormVersionRepository;
import com.jman.form_management_project.service.FormVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FormVersionServiceImpl implements FormVersionService {
    FormVersionRepository formVersionRepository;

    @Autowired
    public FormVersionServiceImpl(FormVersionRepository formVersionRepository) {
        this.formVersionRepository = formVersionRepository;
    }

    @Override
    public MyResponse deleteFormVersion(int id) {
        FormVersionDO formVersionDO = formVersionRepository.findById(id).get();
        formVersionDO.setArchived(true);
        formVersionRepository.save(formVersionDO);
        MyResponse response = new MyResponse();
        String message="Form version deleted successfully";
        response.setStatus(200);
        response.setMessage(message);
        return response;
    }

    @Override
    public MyResponse updateVersionName(int id, String versionName) {
        FormVersionDO formVersionDO = formVersionRepository.findById(id).get();
        if(formVersionDO != null)
        {
            formVersionDO.setFormVersionName(versionName);
            formVersionRepository.save(formVersionDO);
        }
        MyResponse response = new MyResponse();
        String message="Form version updated successfully";
        response.setStatus(200);
        response.setMessage(message);
        return response;
    }
}
