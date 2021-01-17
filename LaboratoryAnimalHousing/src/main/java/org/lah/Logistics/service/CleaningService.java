package org.lah.Logistics.service;
import org.lah.Commons.util.PageModel;
import org.lah.Logistics.domain.Application;
import org.lah.Logistics.domain.Waste;

import java.util.List;

public interface CleaningService {
    /**
     * 添加垃圾
     * @param Waste 垃圾对象
     * */
    void addWaste(Waste waste);

    /**
     * 获得所有用户
     * @return User对象的List集合
     * */
    List<Waste> findWaste(Waste waste, PageModel pageModel);

    // 导出
    List<Waste> getAllWaste();
}
