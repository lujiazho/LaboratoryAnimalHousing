<%--<%@ page import="com.lhd.framework.core.web.util.RequestUtil" %>--%>
<%--<%@ page import="com.lhd.platform.model.system.LoginInfo" %>--%>
<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--<%--%>
<%--	LoginInfo loginInfo = (LoginInfo) RequestUtil.getHttpServletRequest().getSession().getAttribute(LoginInfo.LOGIN_INFO);--%>
<%--	//String currentDate = DateUtil.getCurrentDate();--%>
<%--	String departCode = loginInfo.getLoginDepart().getDepartcode();--%>
<%--	//String departName = loginInfo.getLoginDepart().getDepartname();--%>
<%--	//String userCode = loginInfo.getLoginUser().getUsercode();--%>
<%--%>--%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="she,sypro,sshe,springmvc,hibernate">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<%--	<jsp:include page="/lhd/layout/inc.jsp"></jsp:include>--%>

	<script type="text/javascript">

			var editIndex = undefined; //记录当前选中行的下标
			var edit = undefined; //弹出窗口对象
			var selectedRow;
			var idTemmp;
            var editIndexInvoice = {
                value: undefined
            };

			$(function(){
				fLoadTableDetail();
				// fLoadDataDetail();

				//构建弹出窗口
				/*edit = $('#edit').dialog({
					title:'编辑窗口',
					modal:true,
					buttons:[{
						text:'确定',
						iconCls:'icon-ok',
						handler:function(datas) {
							saveformDetail();
							edit.dialog('close');
						}
					},{
						text:'取消',
						iconCls:'icon-no',
						handler:function(){
							edit.dialog('close');
							$('#datagrid').datagrid('unselectAll');
						}
					}]
				});
				//窗口关闭
				edit.dialog('close');*/
				//按钮显示或隐藏
				var strHref = this.location.href;
				strHref.indexOf("showButton");
				if(strHref.indexOf("showButton")>0){
					$("#tbd").hide();
				}else{
					$("#tbd").show();
				}
			});

			function fLoadTableDetail(){

				$('#datagrid').datagrid({
					url:'',
					singleSelect:false,
					toolbar:'#tb',
					nowrap : true,
					border : true,
					collapsible:true,
					cache: true,
					method:'get',
					width : $(this).width() - 0.1,
					height : $(this).height()-0.1,
					showFooter : true,
					pagination : true,
					//onDblClickCell: onDblClickCell,
					//onClickRow:onClickRow,
					onClickRow: onClickRowQuery,
					remoteSort: false,  //如果为true标识基于数据库排序，如果为false基于页面排序
					multiSort:true,
					//onSortColumn:sortColumn,
					columns : [ [
                                    {field : 'ck',checkbox : true},
                                    {field : 'id',hidden:true,editor:{ type:'textbox' }},
									{field : 'partDepartCode',title : '区分单位编码，隐藏，地区公司编码即5位数字编码',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'armRentId',title : '单项租赁ID',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'rentCode',title : '单项租赁编号',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'contractCode',title : '合同编号',align : 'left',width : 150,sortable: true,editor:{ type:'textbox',options: {
                                                editable: true,
                                                required: true
                                            } }},
									{field : 'contractName',title : '合同名称',align : 'left',width : 150,sortable: true,editor:{ type:'textbox',options: {
                                                editable: true,
                                                required: true
                                            } }},
									{field : 'contractSignDate',title : '合同签订日期',align : 'left',width : 150,sortable: true,editor:{ type:'datebox',options: {
                                                editable: true,
                                                required: true
                                            } }},
									{field : 'contractMoney',title : '合同金额',align : 'left',width : 150,sortable: true,editor:{ type:'textbox',options: {
                                                editable: true,
                                                required: true
                                            } }},
									{field : 'currencyCode',title : '币种编码',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'currencyName',title : '币种',align : 'left',width : 150,sortable: true,editor:{ type:'textbox',options: {
                                                editable: true,
                                                required: true,
                                                icons: [{
                                                    iconCls: 'icon-search',
                                                    handler: function (e) {
                                                        openDlgArmHelp("/lhd/arm/dict/ArmDictExchangerateHelpManager.jsp","汇率字典",currencyCallBack);
                                                    }
                                                }]
                                            } }},
									{field : 'cf01',title : '备用字符1',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'cf02',title : '备用字符2',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'cf03',title : '备用字符3',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'cf04',title : '备用字符4',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'cf05',title : '备用字符5',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'nf01',title : '数字备用1',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'nf02',title : '数字备用2',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'nf03',title : '数字备用3',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'nf04',title : '数字备用4',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
									{field : 'nf05',title : '数字备用5',align : 'left',width : 150,sortable: true,hidden:true,editor:{ type:'textbox' }},
						   ] ],
					onBeforeLoad : function(param) {
						$(this).datagrid('unselectAll');
					},
					onDblClickCell: onDblClickCellInvoice,
					onLoadSuccess : function(data) {

					},
					onClickCell: function (rowIndex, field, value) {

					},
					onAfterEdit :function(index, row, changes){  //行结束编辑事件

					}
				});

				//分页
				var pg = $("#datagrid").datagrid("getPager");
				if(pg) {
					   $(pg).pagination({
						onBeforeRefresh:function(){

						},
					   onRefresh:function(pageNumber,pageSize){
						   fLoadDataDetail();
						},
					   onChangePageSize:function(){

						},
					   onSelectPage:function(pageNumber,pageSize){
						   fLoadDataDetail();
						}
				   });
				}
			}
			//排序
			function sortColumnDetail(sort,order){
				ajaxCallbackGrid("armRentContractController.do?datagrid&funccode=<%=request.getParameter("funccode")%>","","",$('#datagrid'),"","");
			}

			//加载数据
			function fLoadDataDetail(){
				ajaxCallbackGrid("armRentContractController.do?datagrid&funccode=<%=request.getParameter("funccode")%>&rentCode="+rentCodeVal,"","",$('#datagrid'),"","");
			}

			function callBackLoadData(){
				ajaxCallbackGrid("armRentContractController.do?datagrid&funccode=<%=request.getParameter("funccode")%>&rentCode="+rentCodeVal,"","",$('#datagrid'),"","");
			}

			//单击行响应
			function onClickRowQuery(rowIndex, rowData) {
				selectedRow = rowData;
				idTemmp=selectedRow.id;
				//queryDetail(selectedRow.id);
			}

			//结束编辑状态
			function endEditing(){
				if (editIndex == undefined){return true}
				if ($('#datagrid').datagrid('validateRow', editIndex)){
					$('#datagrid').datagrid('endEdit', editIndex);
					editIndex = undefined;
					return true;
				} else {
					return false;
				}
			}

			//单击行响应
			function onClickRow(rowIndex, rowData){
				endEditing();

			}
			//双击行响应
			function onDblClickCell($datagrid, editIndexObj, index, field, value) {
				if (editIndexObj.value != index) {
					if (endEditing($datagrid, editIndexObj)) {
						$datagrid.datagrid('selectRow', index).datagrid('beginEdit', index);
						var ed = $datagrid.datagrid('getEditor', {
							index: index,
							field: field
						});
						if (ed) {
							($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
						}
						editIndexObj.value = index;
					} else {
						setTimeout(function() {
							$datagrid.datagrid('selectRow', editIndexObj.value);
						}, 0);
					}
				}
			}


			//编辑
			function editDialog(){
				datas = $('#datagrid').datagrid('getSelections');
				//选中一行是才允许编辑
				if(datas.length==1){
					openDialog(datas[0]);

				}else if(datas.length>1){
					Messager.Alert('提示','只能选择一条数据进行编辑！','info');
					$('#datagrid').datagrid('unselectAll');
				}else{
					Messager.Alert('提示','请选择要编辑的数据！','info');
				}
			}

			//新增
			function openDialog(row){
				if(row == ""){
					//清空表单 disableValidation和enableValidation解决清除表单数据打开新增页面直接弹出提示问题
					$('#editForm').form('disableValidation');
					$('#editForm').form('clear');
					$('#editForm').form('enableValidation');
				} else {
					$('#editForm').form('load',datas[0]);
				}
				//打开窗口
				edit.dialog('open');
			}

			//保存
			function saveform(){
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});

				var isValid = $('#editForm').form('validate');
				if (!isValid){
					Messager.Alert('提示','请填写并检查数据!','info');
					parent.$.messager.progress('close');
					return isValid;	// 返回false终止表单提交
				}
				var dataParams = JSON.stringify($("#editForm").serializeObject());
				var Params ={};
				Params["dataobj"]=dataParams;
				ajaxCallback("armRentContractController.do?saveForm","post",Params,"",saveCallBack,"");
				edit.dialog('close');
				parent.$.messager.progress('close');

			}

			//保存回调
			function saveCallBackDetail(r){
				if (r.success) {
					Messager.Alert('提示',r.msg,'info');
					//刷新列表页
					fLoadData();
				} else {
					Messager.Alert('操作失败',r.cause,'error');
				}
			}

			//筛选
			function filterDetail(Params){
				ajaxCallback('armRentContractController.do?datagrid&funccode=<%=request.getParameter("funccode")%>','',Params,'',callbackgrid,'');
			}
			//筛选回调
			function callbackgridDetail(r){
				if (r.success) {
					$("#datagrid").datagrid('loadData', r.obj); //将数据绑定到datagrid
				} else {
					Messager.Alert(r.msg,r.cause,'info');
				}
			}

            function addRow($datagrid, editIndexObj, rowData) {
                if (endEditing($datagrid, editIndexObj)) {
                    $datagrid.datagrid('appendRow', rowData);
                    editIndexObj.value = $datagrid.datagrid('getRows').length - 1;
                    $datagrid.datagrid('selectRow', editIndexObj.value)
                        .datagrid('beginEdit', editIndexObj.value);
                }
            }

            function addInvoice() {
                var rowData = {
                }
                rowData.currencyName="人民币";
                rowData.currencyCode="CNY";
                rowData.armRentId=armRentId;
				rowData.rentCode=rentCodeVal;
				rowData.partDepartCode=partDepartCode;
                addRow($("#datagrid"), editIndexInvoice,rowData);
            }

			//结束编辑状态
			function endEditing($datagrid, editIndexObj) {
				if (editIndexObj.value == undefined) {
					return true
				}
				if ($datagrid.datagrid('validateRow', editIndexObj.value)) {
					$datagrid.datagrid('endEdit', editIndexObj.value);
					editIndexObj.value = undefined;
					return true;
				} else {
					return false;
				}
			}

			//结束编辑状态
			function endEditingInvoice() {
				return endEditing($("#datagrid"), editIndexInvoice);
			}

			//双击行响应
			function onDblClickCellInvoice(index, field, value) {
				onDblClickCell($("#datagrid"), editIndexInvoice, index, field, value);
			}

			// 删除
			function deleteInvoice() {
				var rows = $('#datagrid').datagrid('getSelections');
				var ids = [];
				if (rows.length > 0) {
					$.messager.confirm('请确认', '您要删除当前所选数据？', function(r) {
						if (r) {
							// 数据库数据，从数据库删除
							for ( var i = 0; i < rows.length; i++) {
								if(rows[i].id != null && rows[i].id!= ""){
									ids.push(rows[i].id);
								}
							}
							var params = {};
							params["ids"]=ids.join(',');
							ajaxCallback("armRentContractController.do?delete", "", params, "", saveInvoiceCallback,"");
						}
					});
				} else {
					Messager.Alert('提示', '请选择要删除的数据！', 'info');
				}
			}

			// 保存单据
			function saveInvoice() {
				if (!endEditingInvoice()) {
					Messager.Alert('提示', '请填写并检查数据!', 'info');
					return false;
				}
				if ($('#datagrid').datagrid('getChanges').length == 0) {
					Messager.Alert('提示', '没有要保存的数据!', 'info');
					return false;
				}
				//获取新增数据
				var inserted = $('#datagrid').datagrid('getChanges', "inserted");
				//获取修改数据
				var updated = $('#datagrid').datagrid('getChanges', "updated");
				var params = {};
				params["dataobj"] = JSON.stringify(inserted.concat(updated));
				ajaxCallback("armRentContractController.do?saveInvoice", "post", params, "", saveInvoiceCallback, "");
			}


            // 保存单据回调
            function saveInvoiceCallback(r) {
                if (r.success) {
                    Messager.Alert('提示', r.msg, 'info');
                    callBackLoadData();
                } else {
                    Messager.Alert('操作失败', r.cause, 'error');
                }
            }

            function callBackLoadData(){
                ajaxCallbackGrid("armRentContractController.do?datagrid&funccode=<%=request.getParameter("funccode")%>&rentCode="+rentCodeVal,"","",$('#datagrid'),"","");
            }

            function currencyCallBack(data) {
                var obj = data[0];
                var codeEditor = $('#datagrid').datagrid('getEditor', {
                    index: editIndexInvoice.value,
                    field: 'currencyCode'
                });
                codeEditor.actions.setValue(codeEditor.target, obj.currencyCode);
                var nameEditor = $('#datagrid').datagrid('getEditor', {
                    index: editIndexInvoice.value,
                    field: 'currencyName'
                });
                nameEditor.actions.setValue(nameEditor.target, obj.currency);
            }

    </script>
</head>

 <div id="tbd" style="height:auto; float:right;padding:5px;">
	 <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addInvoice()">新增</a>
     <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteInvoice()">删除</a>
     <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="saveInvoice()">保存</a>
 </div>
 <table id="datagrid"  style="width:100%;height:100%" data-options="fit:true"></table>
</html>









