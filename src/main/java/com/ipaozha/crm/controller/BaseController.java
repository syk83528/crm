package com.ipaozha.crm.controller;

import com.ipaozha.crm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    private CategoryService categoryService;
}
