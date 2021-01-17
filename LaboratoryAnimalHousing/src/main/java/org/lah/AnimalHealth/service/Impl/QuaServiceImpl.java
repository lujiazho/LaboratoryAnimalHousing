package org.lah.AnimalHealth.service.Impl;

import org.lah.AnimalHealth.domain.Animal;
import org.lah.AnimalHealth.domain.Qua;
import org.lah.AnimalHealth.mapper.QuaMapper;
import org.lah.AnimalHealth.service.QuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("QuaService")
public class QuaServiceImpl implements QuaService {
    @Autowired
    private QuaMapper mapper;
    @Transactional(readOnly=true)
    @Override
    public void login(Qua qua)
    {
        mapper.login(qua.getId(),qua.getVar(),qua.getInfo(),qua.getCons(),qua.getName());
    }
    @Transactional(readOnly=true)
    @Override
    public List<Qua> select()
    {
        return mapper.select();
    }
    @Transactional(readOnly=true)
    @Override
    public List<Qua> select2(String id)
    {
        return mapper.select2(id);
    }
    @Transactional(readOnly=true)
    @Override
    public List<Qua> select3(String var)
    {
        return mapper.select3(var);
    }
}
