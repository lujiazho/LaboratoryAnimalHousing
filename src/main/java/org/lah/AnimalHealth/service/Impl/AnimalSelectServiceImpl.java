package org.lah.AnimalHealth.service.Impl;

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
@Service("AnimalSelectService")
public class AnimalSelectServiceImpl implements AnimalSelectService {
    @Autowired
    private AnimalSelectMapper mapper;
    @Transactional(readOnly=true)
    @Override
    public List<Animal> select()
    {
       return mapper.select();
    }
    @Transactional(readOnly=true)
    @Override
    public List<Animal> select2(String id)
    {
        return mapper.select2(id);
    }
    @Transactional(readOnly=true)
    @Override
    public List<Animal> select3(String var)
    {
        return mapper.select3(var);
    }
}
