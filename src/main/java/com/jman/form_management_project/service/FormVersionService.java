package com.jman.form_management_project.service;

import com.jman.form_management_project.common.MyResponse;
import org.springframework.stereotype.Service;

@Service
public interface FormVersionService {
    MyResponse deleteFormVersion(int id);
    MyResponse updateVersionName(int id,String versionName);
}
