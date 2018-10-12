package com.ipaozha.crm.form;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class CategoryForm {
    private String name;
    private String type;
    private String icon;
}
