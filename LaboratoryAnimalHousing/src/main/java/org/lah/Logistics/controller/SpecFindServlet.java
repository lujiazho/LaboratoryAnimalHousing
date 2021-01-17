package org.lah.Logistics.controller;

import net.sf.json.JSONArray;

import org.lah.Commons.util.SqlSession;
import org.lah.Logistics.domain.Model;
import org.lah.Logistics.domain.Name;
import org.lah.Logistics.mapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.lah.Commons.LahConstants.EQUIPSPECTABLE;

@WebServlet(value="/spec/findSpec.do",name="SpecFindServlet")
public class SpecFindServlet extends HttpServlet {
    @Autowired
    ModelMapper modelMapper;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid=null;
        List specList = null;

        JSONArray jsonArray = null;
        // 读取请求协议包：设备编号
        eid = request.getParameter("eid");
        String sql = "select * from "+EQUIPSPECTABLE+" where eid = "+eid;
        // 查询该设备所有型号集合
        specList = SqlSession.selectList(sql, Model.class);
        // 转换为json格式字符串
        jsonArray = JSONArray.fromObject(specList);
        System.out.println(jsonArray);
        // 将json格式字符串写入响应包
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonArray.toString());
    }// tomcat负责将响应包推送给客户端的异步请求对象
}
