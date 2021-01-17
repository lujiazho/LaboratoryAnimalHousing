package org.lah.AnimalHealth.service.Impl;

import org.lah.AnimalHealth.mapper.AnimalRequestMapper;
import org.lah.AnimalHealth.service.AnimalRequestService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalHealth.mapper.AnimalSelectMapper;
import org.lah.AnimalHealth.service.AnimalLonginService;
import org.lah.AnimalHealth.service.AnimalSelectService;
import org.lah.Commons.util.PageModel;
import org.lah.AnimalHealth.controller.AnimalLoginController;
import org.lah.AnimalHealth.domain.*;
import org.lah.AnimalHealth.mapper.AnimalLoginMapper;
import org.lah.AnimalHealth.service.AnimalLonginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("AnimalRequestService")
public class AnimalRequestServiceImpl implements AnimalRequestService {
    @Autowired
    private AnimalRequestMapper mapper;
    @Transactional(readOnly=true)
    @Override
    public List<Request> select()
    {
        return mapper.select();
    }
}
