
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-08-09
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <%
        pageContext.setAttribute("PATH", request.getContextPath());
    %>
    <title>员工列表</title>
    <script type="text/javascript" src="${PATH}/static/js/jquery-1.12.4.min.js"></script>
    <link rel="stylesheet" href="${PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="${PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //点击新增按钮，弹出模态框，查出部门信息，并在下拉列表中显示
            $("#addBut").click(function (){
                //清除表单数据及样式（表单重置）
                resetForm("#addModal form");
                //发送ajax请求，查出部门信息，显示在下拉列表中
                getDepartment("#departmentOption");
                //弹出模态框并取消点击背景关闭模态框
                $("#addModal").modal({
                    backdrop:"static"
                });
            });

            //为提交按钮绑定单击事件及验证
            $("#saveEmployee").click(function () {
                //前端校验
                if (!checkForm("#inputEmail") || !checkSalary("#inputSalary")){
                    return false;
                }
                $.ajax({
                    url: "${PATH}/employees",
                    type: "POST",
                    data: $("#employeeForm").serialize(),
                    success:function (result) {
                        //后端校验
                        if (result.code === 200){
                            alert("员工添加成功！");
                            //关闭模态框
                            $("#addModal").modal('hide')
                            <%--if (${pageInfo.pages == 0}){--%>
                            <%--    location.href="${PATH}/employees?pageNum=1";--%>
                            <%--}else {--%>
                                location.href = "${PATH}/employees?pageNum=${pageInfo.pages}";
                            // }
                        }else {
                            //显示错误信息
                            if (undefined !== result.info.errorFields.email){
                                showCheckInfo("#inputEmail","error",result.info.errorFields.email)
                            }
                        }
                    }
                })
            })

            //为编辑按钮绑定单击事件
            $(document).on("click","#updateButton",function (){
                //清空表单数据和样式
                resetForm("#updateModal form")
                //查询所有的部门信息，显示在下拉列表中
                getDepartment("#updateOption");
                //查询所有员工信息
                getEmployee($(this).attr("employeeId"));
                //把员工id传递给模态框的更新按钮
                $("#updateEmployee").attr("employeeId",$(this).attr("employeeId"));
                //弹出模态框
                $("#updateModal").modal({
                    backdrop:"static"
                });
            })

            //为删除按钮绑定单击事件
            $(document).on("click","#deleteButton",function () {
                //弹出确认对话框
                // alert($(this).parents("tr").find("td:eq(2)").text());
                var name = $(this).parents("tr").find("td:eq(2)").text();
                var b = confirm("确定要删除【"+name+"】吗？");
                var id = $(this).prev().attr("employeeId");
                if (b){
                    $.ajax({
                        url:"${PATH}/employees/"+id,
                        type:"DELETE",
                        success:function (result) {
                            alert(result.msg);
                            location.reload();
                        }
                    })
                }



            })
            //为更新按钮绑定单击事件
            $("#updateEmployee").click(function () {
                //进行邮箱表单验证
                if (!checkForm("#updateEmail")){
                    return false;
                }
                //发送ajax请求
                $.ajax({
                    url:"${PATH}/employees/"+$(this).attr("employeeId"),
                    type:"PUT",
                    data: $("#updateModal form").serialize(),
                    success:function (result) {
                        alert(result.msg);
                        $("#addModal").modal('hide');
                        <%--location.href = "${PATH}/employees?pageNum=${pageInfo.pageNum}";--%>
                        location.reload();
                    }
                })
            });

            //全选/全不选
            $("#checkAll").click(function () {
                $(".checkItem").prop("checked",$(this).prop("checked"));
            })

            $(document).on("click",".checkItem",function () {
                var b1 = $(".checkItem:checked").length === $(".checkItem").length;
                $("#checkAll").prop("checked",b1);
            })
            
            //为批量删除绑定单击事件
            $("#deleteAll").click(function () {
                var employeeNames = "";
                var delete_id = "";
                $.each($(".checkItem:checked"),function () {
                    employeeNames += $(this).parents("tr").find("td:eq(2)").text()+",";
                    delete_id += $(this).parents("tr").find("td:eq(1)").text()+"-";
                })
                //去除员工姓名多余的逗号
                employeeNames = employeeNames.substring(0,employeeNames.length-1);
                //去除员工id多余的-
                delete_id = delete_id.substring(0,delete_id.length-1);

                var b2 = confirm("您确定要删除【"+employeeNames+"】吗？");
                if (b2){
                    $.ajax({
                        url:"${PATH}/employees/"+delete_id,
                        type:"DELETE",
                        success:function (result) {
                            alert(result.msg);
                            location.reload();
                        }
                    })
                }


            })

            //为清除所有数据绑定单击事件
            $("#deleteAllButton").click(function () {
                var b3 = confirm("您确定要清除所有的数据吗？");
                if (b3){
                    $.ajax({
                        url:"${PATH}/deleteAll",
                        type:"GET",
                        success:function (result) {
                            alert(result.msg);
                            location.reload();
                        }
                    })
                }
            })

        })
        //进行邮箱表单验证
        function checkForm(element) {
            var email = $(element).val();
            var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if (!regEmail.test(email)){
                showCheckInfo(element,"error","邮箱格式不正确!")
                return false;
            }else {
                showCheckInfo(element,"success","");
            }
            return true;
        }
        //进行薪资表单验证
        function checkSalary(element) {
            var salary = $(element).val();
            var regSalary = /^[0-9]*$/;
            if (!regSalary.test(salary)){
                showCheckInfo(element,"error","包含不是数字的字符!")
                return false;
            }else {
                showCheckInfo(element,"success","");
            }
            return true;
        }

        //显示表单校验信息
        function showCheckInfo(element,status,msg) {
            //清空当前元素的校验状态
            $(element).parent().removeClass("has-error has-success");
            $(element).next("span").text("");
            if ("success" === status){
                $(element).parent().addClass("has-success");
                $(element).next("span").text(msg);
            }else if ("error" === status){
                $(element).parent().addClass("has-error");
                $(element).next("span").text(msg);
            }
        }
        //清空表单样式及内容
        function resetForm(element) {
            //清空表单内容
            $(element)[0].reset();
            //清空表单样式
            $(element).find("*").removeClass("has-error has-success");
            $(element).find(".help-block").text("");
        }
        //获取所有的部门信息
        function getDepartment(element) {
            $(element).empty();
            $.ajax({
                url:"${PATH}/department",
                type:"GET",
                success:function (result) {
                    $.each(result,function(){
                        // var departmentInfo = this.departmentName;
                        //  $("#departmentOption").append("<option>"+empInfo+"<option/>");
                        var optionElement = $("<option></option>").append(this.departmentName).attr("value",this.departmentId);
                        optionElement.appendTo(element);
                    });
                }
            });
        }
        //获取所有的员工信息
        function getEmployee(id){
            $.ajax({
                url:"${PATH}/employees/"+id,
                type:"GET",
                success:function (result) {
                    var employee = result.info.employee;
                    $("#updateName").text(employee.employeeName);
                    $("#updateEmail").val(employee.email);
                    $("#updateSalary").val(employee.salary);
                    $("#updateModal input[name=gender]").val([employee.gender])
                    $("#updateModal select").val([employee.departmentId])
                }
            })

        }
    </script>

</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>员工管理</h1>
            </div>
        </div>
        <%--    新增与删除按钮    --%>
        <div class="row">
            <div class="col-md-3 col-md-offset-9">
                <button id="addBut" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;新增
                </button>
                <button id="deleteAll" class="btn btn-warning">
                    <span  class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;删除
                </button>
            </div>
        </div>
        <!-- 分页查询 -->
        <div class="row">
                <table class="table table-striped table-hover">
                    <tr>
                        <th>
                            <label>
                                <input type="checkbox" name="check" id="checkAll">
                            </label>
                        </th>
                        <th>ID</th>
                        <th>姓名</th>
                        <th>邮箱</th>
                        <th>性别</th>
                        <th>部门</th>
                        <th>薪资</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="emp">
                        <tr>
                            <td>
                                <label>
                                    <input type="checkbox" name="check" class="checkItem">
                                </label>
                            </td>
                            <td>${emp.employeeId}</td>
                            <td>${emp.employeeName}</td>
                            <td>${emp.email}</td>
                            <td>${emp.gender}</td>
                            <td>${emp.department.departmentName}</td>
                            <td>${emp.salary}</td>
                            <td>
                                <button class="btn btn-info btn-sm" id="updateButton" employeeId="${emp.employeeId}">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                    &nbsp;编辑
                                </button>
                                <button class="btn btn-warning btn-sm" id="deleteButton"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;删除</button>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-1">
                <div>当前第<kbd>${pageInfo.pageNum}</kbd>页，共有<kbd>${pageInfo.pages}</kbd>页，总计<kbd>${pageInfo.total}</kbd>条记录</div>
            </div>
            <div class="col-md-3 col-md-offset-4">
                <button id="deleteAllButton" class="btn btn-danger">
                    <span  class="glyphicon glyphicon-alert" aria-hidden="true"></span>&nbsp;清除所有数据
                </button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${pageInfo.pageNum == 1}">
                            <li class="disabled"><a href="">首页</a></li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum != 1}">
                            <li><a href="${PATH}/employees?pageNum=1">首页</a></li>
                        </c:if>

                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li >
                                <a href="${PATH}/employees?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                            <c:if test="${pageInfo.pageNum == page_Num}">
                                <li class="active"><a href="#">${page_Num}</a></li>
                            </c:if>

                            <c:if test="${pageInfo.pageNum != page_Num}">
                                <li><a href="${PATH}/employees?pageNum=${page_Num}">${page_Num}</a></li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                                <a href="${PATH}/employees?pageNum=${pageInfo.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                       <c:if test="${pageInfo.pageNum == pageInfo.pages}">
                           <li class="disabled"><a href="">尾页</a></li>
                       </c:if>
                        <c:if test="${pageInfo.pageNum != pageInfo.pages}">
                            <li><a href="${PATH}/employees?pageNum=${pageInfo.pages}">尾页</a></li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
    </div>

    <!-- 新增员工模态框 -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">员工添加</h4>
                </div>
                <div class="modal-body">
                    <!-- 新增员工表单 -->
                    <form class="form-horizontal" id="employeeForm">
                        <div class="form-group">
                            <label for="inputName" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input name="employeeName" type="text" class="form-control" id="inputName" placeholder="Name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputEmail" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-10">
                                <input name="Email" type="text" class="form-control" id="inputEmail" placeholder="Email">
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputSalary" class="col-sm-2 control-label">薪资</label>
                            <div class="col-sm-10">
                                <input name="salary" type="text" class="form-control" id="inputSalary" placeholder="Salary" required>
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label  class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label class="radio-inline col-sm-1 control-label">
                                    <input type="radio" name="gender" id="genderRadio1" value="男" checked="checked"> 男
                                </label>
                                <label class="radio-inline col-sm-1 control-label">
                                    <input type="radio" name="gender" id="genderRadio2" value="女"> 女
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">部门</label>
                            <label class="col-sm-3 control-label">
                                <select class="form-control" name="departmentId" id="departmentOption">

                                </select>
                            </label>
                        </div>

                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="saveEmployee">保存</button>

                </div>
            </div>
        </div>
    </div>

    <!-- 修改员工模态框 -->
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="updateModalLabel">员工修改</h4>
                </div>
                <div class="modal-body">
                    <!-- 修改员工表单 -->
                    <form class="form-horizontal" id="updateForm">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <p class="form-control-static" id="updateName"> </p>
<%--                                <input name="employeeName" type="text" class="form-control" id="updateName" placeholder="Name">--%>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-10">
                                <input name="Email" type="text" class="form-control" id="updateEmail" placeholder="Email">
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="updateSalary" class="col-sm-2 control-label">薪资</label>
                            <div class="col-sm-7">
                                <input name="salary" type="text" class="form-control" id="updateSalary" placeholder="Salary">
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label  class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label class="radio-inline col-sm-1 control-label">
                                    <input type="radio" name="gender" id="updateRadio1" value="男" checked="checked"> 男
                                </label>
                                <label class="radio-inline col-sm-1 control-label">
                                    <input type="radio" name="gender" id="updateRadio2" value="女"> 女
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">部门</label>
                            <label class="col-sm-3 control-label">
                                <select class="form-control" name="departmentId" id="updateOption">

                                </select>
                            </label>
                        </div>

                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="updateEmployee">更新</button>

                </div>
            </div>
        </div>
    </div>

</body>
</html>
