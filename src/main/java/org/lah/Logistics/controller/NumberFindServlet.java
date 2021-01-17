package org.lah.Logistics.controller;

import net.sf.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;
import org.lah.Commons.util.SqlSession;
import org.lah.Logistics.domain.EquipLikeDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.lah.Commons.LahConstants.EQUIPTABLE;

@WebServlet(value="/spec/findNumber.do",name="NumberFindServlet")
public class NumberFindServlet extends HttpServlet {

    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(NumberFindServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid=null;
        String sid=null;
        List numberList;

        JSONArray jsonArray = null;
        // 读取请求协议包：设备编号
        eid = request.getParameter("eid");
        sid = request.getParameter("sid");
        logger.info("eid: "+eid+"\nsid: "+sid);
        String sql = "select * from "+EQUIPTABLE+" where equipmentname_id = "+eid+" and specificationmodel_id = "+sid;
        // 查询该设备所有型号集合
        numberList = SqlSession.selectList(sql, EquipLikeDB.class);
//        List<Equip> numberList = equipMapper.selectByEidSid(eid, sid);
        logger.info(numberList+"\n\n这丫有没有\n\n");
        // 转换为json格式字符串
        jsonArray = JSONArray.fromObject(numberList);
        System.out.println(jsonArray);
        // 将json格式字符串写入响应包
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonArray.toString());
    }// tomcat负责将响应包推送给客户端的异步请求对象
}
