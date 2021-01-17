package org.lah.Logistics.service.impl;

import org.lah.Commons.util.PageModel;
import org.lah.Logistics.domain.Model;
import org.lah.Logistics.domain.Waste;
import org.lah.Logistics.mapper.WasteMapper;
import org.lah.Logistics.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("CleaningService")
public class CleaningServiceImpl implements CleaningService {
    @Autowired
    private WasteMapper wasteMapper;

    @Override
    public void addWaste(Waste waste){
        wasteMapper.save(waste);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Waste> findWaste(Waste waste, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String,Object> params = new HashMap<>();
        params.put("waste", waste);
        int recordCount = wasteMapper.count(params);
        pageModel.setRecordCount(recordCount);
        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }
        List<Waste> wastes = wasteMapper.selectByPage(params);

        return wastes;
    }

    @Transactional(readOnly=true)
    @Override
    public List<Waste> getAllWaste() {
        return wasteMapper.selectAllWaste();
    }
}
