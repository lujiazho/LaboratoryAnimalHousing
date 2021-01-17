package org.lah.Logistics.controller;

import net.sf.json.JSONArray;
import org.lah.Commons.util.SqlSession;
import org.lah.Logistics.domain.Name;
import org.lah.Logistics.mapper.EquipMapper;
import org.lah.Logistics.mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.lah.Commons.LahConstants.EQUIPNAMETABLE;

@WebServlet(value="/spec/findEname.do",name="EnameFindServlet")
public class EnameFindServlet extends HttpServlet {
    @Autowired
    EquipMapper equipMapper;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid=null;
        List equipList = null;

        JSONArray jsonArray = null;
        // 读取请求协议包：设备编号
        eid = request.getParameter("eid");
        String sql = "select * from "+EQUIPNAMETABLE+" where id = "+eid;
        // 查询该设备所有型号集合
        equipList = SqlSession.selectList(sql, Name.class);
        // 转换为json格式字符串
        jsonArray = JSONArray.fromObject(equipList);
        System.out.println(jsonArray);
        // 将json格式字符串写入响应包
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonArray.toString());
    }// tomcat负责将响应包推送给客户端的异步请求对象
}
