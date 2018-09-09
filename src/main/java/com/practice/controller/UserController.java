/*
 * Copyright (c) 2016 JCPenney Co. All rights reserved.
 */

package com.practice.controller;

import com.jcpenney.dataservice.graph.domain.Brand;
import com.jcpenney.dataservice.graph.service.BrandService;
import com.practice.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by psingh15 on 5/22/17.
 */

@Slf4j
@RestController
@RequestMapping("${microservice.contextPath}/brands")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Get all Brands existing in graphDB.
     *
     * @return list
     */
    @ApiOperation(value = "Gets a List all Brand ",
            notes = "Gets a List all Brand",
            produces = "application/json")
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity getAllBrand() {
        log.debug("Getting All the Brand From graph ");
        List<Brand> brandList = brandService.getBrands();
        return new ResponseEntity(brandList, HttpStatus.OK);
    }

}
