package org.lah.Commons.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SqlSession {
	
	/*
	 *  作用：
	 *      1）将接受一条查询语句,并执行
	 *      2）将得到执行结果数据行，转换为实体类对象
	 *      3）将实体类对象保存到List 
	 * 
	 */
	public static List  selectList(String sql,Class classFile){
		
		 PreparedStatement ps = DBUtil.createStatement(sql);
		 ResultSet rs = null;
		 Field fieldArray[]=null;
		 List list = new ArrayList();
		 //1.推送查询语句得到一个结果集[ResultSet]
		 try {
			rs =ps.executeQuery();
			
			 //2.获得实体类相关属性
			 fieldArray = classFile.getDeclaredFields();
			 //3.赋值转换
			 while(rs.next()){
				Object obj =  classFile.newInstance();
				for(int i=0;i<fieldArray.length;i++){
					Field fieldObj = fieldArray[i];//private Integer deptNo;
					String fieldName = fieldObj.getName();//deptNo
					String value =rs.getString(fieldName);
					init(obj,value,fieldObj);
					
				}
				list.add(obj);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
		}
		
		return list;
	}


	public static List  selectList(String sql, Class classFile, HttpServletRequest request){

		PreparedStatement ps=null;
		Connection con = null;
		ResultSet rs = null;
		Field fieldArray[]=null;
		List list = new ArrayList();
		ServletContext application = request.getServletContext();
		Map conPool=null;
		//1.推送查询语句得到一个结果集[ResultSet]
		try {

			conPool = (Map)application.getAttribute("key");
			Iterator it = conPool.keySet().iterator();
			while(it.hasNext()){
				con =(Connection)  it.next();
				boolean flag = (boolean)conPool.get(con);
				if(flag==true){
					conPool.put(con, false);
					break;
				}else{
					con=null;
				}
			}

			if(con==null){
				//等待  Thread.wait();
				//新建一个connection
			}

			ps = con.prepareStatement(sql);

			rs =ps.executeQuery();

			//2.获得实体类相关属性
			fieldArray = classFile.getDeclaredFields();
			//3.赋值转换
			while(rs.next()){
				Object obj =  classFile.newInstance();
				for(int i=0;i<fieldArray.length;i++){
					Field fieldObj = fieldArray[i];//private Integer deptNo;
					String fieldName = fieldObj.getName();//deptNo
					String value =rs.getString(fieldName);
					init(obj,value,fieldObj);

				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conPool.put(con, true);
		}

		return list;
	}
	
	private static void init(Object obj,String value,Field fieldObj){
		
		   //1.通知JVM，当前程序要使用fieldObj属性
		     fieldObj.setAccessible(true);
		   //2.赋值
		     try {
				if(value==null){
					 fieldObj.set(obj, value);
				 }else{
					  
					 String typeName = fieldObj.getType().getName();
					 if("java.lang.Integer".equals(typeName)){
						 fieldObj.set(obj, Integer.valueOf(value));
					 }else if("java.lang.Double".equals(typeName)){
						 fieldObj.set(obj, Double.valueOf(value));
					 }else if("java.lang.String".equals(typeName)){
						 fieldObj.set(obj, value);
					 }
				 }
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
	}
	
	
	
	/*
	 * 1.根据接收的【实体类对象】自动生成一条INSERT
	 * 2.负责将INSERT推送到数据库中执行，返回操作行数 
	 *  INSERT INTO  [表名]  (字段1，字段2)   value(值1，值2)
        -----------  -----  ------------   ------------- 
	 * 
	 */
	public static int insert(Object obj){
		String tableName=null;
		StringBuffer columnStr = new StringBuffer("(");
		StringBuffer valueStr =  new StringBuffer(" value(");
		StringBuffer sql = new StringBuffer("INSERT INTO  ");
		Field fieldArray[]  = null;
		PreparedStatement ps = null;
		int flag =0;
		//1.根据实体类获得操作的表名
		tableName = getName(obj.getClass());
		//2.获得需要赋值字段序列
		try {
			fieldArray = obj.getClass().getDeclaredFields();
			for(int i=0;i<fieldArray.length;i++){
				Field fieldObj = fieldArray[i];
				fieldObj.setAccessible(true);
				Object value = fieldObj.get(obj);
				String typeName = fieldObj.getType().getName();
				if("java.lang.String".equals(typeName)){
					if(value!=null &&  !"".equals(value)){
						if(columnStr.length()==1){
							columnStr.append(fieldObj.getName());
							valueStr.append("'");
							valueStr.append(value);
							valueStr.append("'");
						}else{
						    columnStr.append(",");
						    columnStr.append(fieldObj.getName());
						    valueStr.append(",'");
							valueStr.append(value);
							valueStr.append("'");
						}
					}
				}else if("java.lang.Integer".equals(typeName) || "java.lang.Double".equals(typeName)){
					if(value!=null && ((Integer)value)!=0){
						if(columnStr.length()==1){
							columnStr.append(fieldObj.getName());
							valueStr.append(value);
						}else{
						    columnStr.append(",");
						    columnStr.append(fieldObj.getName());
						    valueStr.append(",");
							valueStr.append(value);
							
						}
					}
				}
				
				
			}
			columnStr.append(")");
			valueStr.append(")");
			
			sql.append(tableName);
			sql.append(columnStr);
			sql.append(valueStr);
			System.out.println("sql: "+sql.toString());
			
			ps = DBUtil.createStatement(sql.toString());
			flag = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null);
		}
		
		return flag;
	}
	
	//根据实体类得到类型名
	private static String getName(Class classFile){
		
		  String classPath =  classFile.getName();//com.bjpowernode.model.Dept
		  int index = classPath.lastIndexOf(".");
		  String typeName = classPath.substring(index+1);
		  return typeName;
	}
	
	
	/*
	 *  1.根据得到实体类对象内容，自动生成一条更新数据
	 *  2.自动执行更新语句 
	 */
	public static int update(Object obj,String primaryKey){
		   String tableName = null;
		   StringBuffer setBuffer = new StringBuffer(" set ");
		   StringBuffer whereBuffer = new StringBuffer (" where ");
		   StringBuffer sql = new StringBuffer("update ");
		   Field fieldArray[]=null;
		   int flag = 0;
		   PreparedStatement ps =null;
		   //1.获得操作表名
		   tableName = getName(obj.getClass());
		   //2.设置需要更新字段信息
		   try {
			fieldArray = obj.getClass().getDeclaredFields();
			   for(int i=0;i<fieldArray.length;i++){
				     Field fieldObj = fieldArray[i];
				     fieldObj.setAccessible(true);
				     String fieldName = fieldObj.getName();
				     String typeName = fieldObj.getType().getName();
				     Object value = fieldObj.get(obj);
				     
				     if(fieldName.equals(primaryKey)){
				    	 whereBuffer.append(fieldName);
				    	 whereBuffer.append(" = ");
				    	 if("java.lang.String".equals(typeName) || "java.util.Date".equals(typeName)){
				    		 whereBuffer.append("'");
				    		 whereBuffer.append(value);
				    		 whereBuffer.append("'");
				    	 }else{
				    		 whereBuffer.append(value);
				    	 }
				     }else{
				    	 
				    	 if(setBuffer.length()>5){
				    		 setBuffer.append(",");
				    	 }
				    	 setBuffer.append(fieldName);
				    	 setBuffer.append(" = ");
				    	 if("java.lang.String".equals(typeName) || "java.util.Date".equals(typeName)){
				    		 setBuffer.append("'");
				    		 setBuffer.append(value);
				    		 setBuffer.append("'");
				    	 }else{
				    		 setBuffer.append(value);
				    	 }
				    		
				    		 
				    	
				     }
			   }
			   
			   sql.append(tableName);
			   sql.append(setBuffer);
			   sql.append(whereBuffer);
			   System.out.println("sql : "+sql);
			   ps = DBUtil.createStatement(sql.toString());
			   flag = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(null);
		}
		return flag; 
		   
	}
	
	
	
	
	
	
	
	
	//批处理删除  delete from 表名 where 主键 in(主键值，主键值)


	public static int  delete(String tableName,String primary ,String array[]){
		int result = 0;
		StringBuffer sql = new StringBuffer("delete from ");
		sql.append(tableName);
		sql.append(" where ");
		sql.append(primary);
		sql.append(" in (");

		for(int i=0;i<array.length;i++){
			String data = array[i];
			if(i>0){
				sql.append(",");
			}
			sql.append(data);
		}
		sql.append(")");
		System.out.println("delete :"+sql.toString());
		PreparedStatement ps = DBUtil.createStatement(sql.toString());
		try {
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(null);
		}

        return result;
	}
	
	
	
	
	
	
	
	
	

}
