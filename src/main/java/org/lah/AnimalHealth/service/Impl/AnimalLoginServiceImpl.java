package org.lah.AnimalHealth.service.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalHealth.service.AnimalLonginService;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("AnimalLoginService")
public class AnimalLoginServiceImpl implements AnimalLonginService {
    @Autowired
    private AnimalLoginMapper mapper;
    @Transactional(readOnly=true)
    @Override
    public void login(Animal animal) {
        mapper.login(animal.getId(),animal.getVar(),animal.getState(),animal.getHealth(),animal.getDate());
    }
    @Transactional(readOnly=true)
    @Override
    public void update(String id,String health)
    {
        mapper.update(id,health);
    }
}
