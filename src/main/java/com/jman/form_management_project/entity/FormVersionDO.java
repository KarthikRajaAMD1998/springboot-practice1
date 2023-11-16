package com.jman.form_management_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import com.jman.form_management_project.entity.FormDO;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "form_version")
public class FormVersionDO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int formVersionId;

    @NonNull
    private String formVersionName;

    private Boolean archived =false;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinColumn(name = "form_id")
    private FormDO form;

    @Transient
    private int formId;
}

