package com.jman.form_management_project.controller;

import com.jman.form_management_project.common.MyResponse;
import com.jman.form_management_project.entity.FormDO;
import com.jman.form_management_project.payload.request.FormCreate;
import com.jman.form_management_project.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form")
@CrossOrigin(origins = "http://localhost:4200")
public class FormController {

    FormService formService;

    @Autowired
    public FormController(FormService formService) {
        this.formService = formService;
    }
	@PostMapping("/create")
	public ResponseEntity<MyResponse> createForm(@RequestBody FormCreate formCreate)
	{
		MyResponse res= formService.createForm(formCreate);

		return ResponseEntity.status(res.getStatus()).body(res);
	}
	@GetMapping("/get")
	public ResponseEntity<MyResponse> getForm(){
		MyResponse res= formService.getForm();
		return ResponseEntity.status(res.getStatus()).body(res);
	}
	@PutMapping("/delete/{formId}")
	public ResponseEntity<MyResponse> deleteContent(@PathVariable("formId") int formId) {
		MyResponse res= formService.deleteForm(formId);
		return ResponseEntity.status(res.getStatus()).body(res);
	}

	@PutMapping("/update/{formId}")
	public ResponseEntity<MyResponse> updateContent(@PathVariable("formId") int formId, @RequestBody FormDO formDO) {
		System.out.println(formId);
		System.out.println(formDO);
		MyResponse res= formService.updateForm(formId,formDO);
		return ResponseEntity.status(res.getStatus()).body(res);
	}

//	@GetMapping("/getbus/{id}")
//	public ResponseEntity<MyResponse> getBusById(@PathVariable int id){
//		MyResponse res= agency.getBusById(id);
//
//		return ResponseEntity.status(res.getStatus()).body(res);
//	}
}
