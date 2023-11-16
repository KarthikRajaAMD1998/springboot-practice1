package com.jman.form_management_project.service.implementation;

import com.jman.form_management_project.entity.FormVersionDO;
import com.jman.form_management_project.payload.request.FormCreate;
import com.jman.form_management_project.repository.FormRepository;
import com.jman.form_management_project.repository.FormVersionRepository;
import com.jman.form_management_project.service.FormService;
import com.jman.form_management_project.common.MyResponse;
import com.jman.form_management_project.entity.FormDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    FormRepository formRepository;
    FormVersionRepository formVersionRepository;
    @Autowired
    public FormServiceImpl(FormRepository formRepository,FormVersionRepository formVersionRepository) {
        this.formRepository = formRepository;
        this.formVersionRepository=formVersionRepository;
    }

    @Override
    public MyResponse createForm(FormCreate createForm) {
        String message="";
        MyResponse response = new MyResponse();
        FormDO formNewDO = new FormDO();
        FormDO formDO= formRepository.findByInternalName(createForm.getInternalName());
        boolean val = false;


        if (formDO != null ) {
            if(!createForm.getVersionName().isEmpty()) {
                val = formDO.getFormVersions()
                        .stream()
                        .anyMatch(e ->
                                e.getFormVersionName().equals(createForm.getVersionName()) &&
                                e.getFormId() == formDO.getFormId() );
                System.out.println(val);
            }
            else if(formDO.getArchived()){
                message="Form can not be duplicated";
                response.setMessage(message);
                response.setStatus(400);
                return response;
            }
        }
        if(formDO == null )
        {
            formNewDO.setDisplayName(createForm.getDisplayName());
            formNewDO.setInternalName(createForm.getInternalName());
            formRepository.save(formNewDO);
            if(!createForm.getVersionName().isEmpty()) {
                FormVersionDO formVersionDO = new FormVersionDO();
                formVersionDO.setFormVersionName(createForm.getVersionName());
                formVersionDO.setForm(formNewDO);
                formVersionRepository.save(formVersionDO);
            }
            message="Form created successfully";
        }
        else if( !val)
        {
            boolean versionExists = formVersionRepository.existsByFormVersionNameAndForm_FormId(
                    createForm.getVersionName(), formDO.getFormId());
            if(!versionExists) {
                FormVersionDO formVersionDO = new FormVersionDO();
                formVersionDO.setFormVersionName(createForm.getVersionName());
                formVersionDO.setForm(formDO);
                formVersionRepository.save(formVersionDO);
                message="Form version created for "+formDO.getDisplayName()+" form";
            }
            else {
                message="Form version name "+ createForm.getVersionName()+" is already exist with the "+createForm.getDisplayName()+" form";
                response.setStatus(400);
                response.setMessage(message);
                return response;
            }
        }
        response.setStatus(200);
        response.setMessage(message);
        return response;
    }

    @Override
    public MyResponse getForm() {
        List<FormDO> formDOs = formRepository.findAll();

        MyResponse response = new MyResponse();
        String message="Form retrieved successfully";
        response.setStatus(200);
        response.setMessage(message);
        response.setData(formDOs);
        return response;
    }

    @Override
    public MyResponse deleteForm(int id) {
        FormDO formDO = formRepository.findById(id).get();
        formDO.setArchived(true);
        formRepository.save(formDO);
        MyResponse response = new MyResponse();
        String message="Form Deleted successfully";
        response.setStatus(200);
        response.setMessage(message);
        return response;
    }

    @Override
    public MyResponse updateForm(int id, FormDO formData) {
        FormDO formDO = formRepository.findById(id).get();
        if(formDO != null)
        {
            formDO.setDisplayName(formData.getDisplayName());
            formDO.setInternalName(formData.getInternalName());
            formRepository.save(formDO);
        }
        MyResponse response = new MyResponse();
        String message="Form updated successfully";
        response.setStatus(200);
        response.setMessage(message);
        return response;
    }
}
