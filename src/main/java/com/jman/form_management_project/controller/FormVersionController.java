package com.jman.form_management_project.controller;

import com.jman.form_management_project.common.MyResponse;
import com.jman.form_management_project.entity.FormDO;
import com.jman.form_management_project.payload.request.MyFormVersionRequest;
import com.jman.form_management_project.service.FormVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formVersion")
@CrossOrigin(origins = "http://localhost:4200")
public class FormVersionController {

    FormVersionService formVersionService;

   @Autowired
    public FormVersionController(FormVersionService formVersionService) {
        this.formVersionService = formVersionService;
    }

    @PutMapping("/delete/{formVersionId}")
    public ResponseEntity<MyResponse> deleteContent(@PathVariable("formVersionId") int formId) {
        MyResponse res= formVersionService.deleteFormVersion(formId);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @PutMapping("/update/{formVersionId}")
    public ResponseEntity<MyResponse> updateVersionName(@PathVariable("formVersionId") int formVersionId, @RequestBody MyFormVersionRequest versionName) {
        System.out.println(formVersionId);
        System.out.println(versionName);
        MyResponse res= formVersionService.updateVersionName(formVersionId,versionName.getVersionName());
        return ResponseEntity.status(res.getStatus()).body(res);
    }

}
