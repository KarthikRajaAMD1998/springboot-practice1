package com.jman.form_management_project.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormCreate {

    @NonNull
    private String displayName;

    @NonNull
    private String internalName;

    private String versionName;
}
