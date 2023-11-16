package com.jman.form_management_project.service;

import com.jman.form_management_project.entity.FormDO;
import com.jman.form_management_project.payload.request.FormCreate;
import org.springframework.stereotype.Service;
import com.jman.form_management_project.common.MyResponse;
@Service
public interface FormService {

    MyResponse createForm(FormCreate formCreate);
    MyResponse getForm();
    MyResponse deleteForm(int id);

    MyResponse updateForm(int id, FormDO formDO);
}
