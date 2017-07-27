<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dream
  Date: 2017/7/20
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>微课堂</title>
    <meta charset="UTF-8">
    <%--<link rel="stylesheet" href="https://terryz.github.io/lib/bootstrap/3.3.7/css/bootstrap.min.css" />--%>
    <%--<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">--%>
    <link href="${pageContext.request.contextPath}/css/b.page.bootstrap3.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/layui.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">


    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-bpage.js"></script>
    <script src="${pageContext.request.contextPath}/js/b.page.js"></script>
    <script src="${pageContext.request.contextPath}/js/Calendar.js"></script>

</head>

<body>
<div class="content">
    <div class="container" style="margin-top: 30px;">


        <!-- HTML代码、服务端内容填充 -->
        <div>
            <div style="margin: 15px;">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: auto">用户ID</label>
                        <div class="layui-input-inline">
                            <input type="text"  class="layui-input" id="userid">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: auto">开始时间</label>
                        <div class="layui-input-block">
                            <input type="text"   class="layui-input"  id="startTime" onClick="new Calendar().show(this);" readonly>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: auto">结束时间</label>
                        <div class="layui-input-block">
                            <input type="text"  class="layui-input"  id="endTime" onClick="new Calendar().show(this);" readonly>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn" onclick="setPage()">查询</button>
                        <button class="layui-btn" onclick="download()">下载</button>
                    </div>
                </div>
            </div>

            <!-- 定义表格框架 -->
            <table id="dataGridTableJson" class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                    <tr>
                        <%--<th class="selectColumn" >选择</th>--%>
                        <%--<td class="selectColumn"><input type="radio" name="userSelect" value="$ {d.id}" /></td>--%>
                        <th>用户ID</th>
                        <th>用户姓名</th>
                        <th>成绩</th>
                        <th>测试时间</th>
                        <th>组织</th>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
        <div id="page3"></div>
    </div>
</div>

<script type="text/javascript">
    $(function(){
        setPage();
    });

    function download(){
        var url = "download?";
        var userid = $("#userid").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        if(userid.length>0){
            url += "&userid="+userid;
        }
        if(startTime.length>0){
            url += "&startTime="+startTime;
        }
        if(endTime.length>0){
            url += "&endTime="+endTime;
        }
        var args = {"time":new Date()};
        location.href=url;
    }

    function setPage(){
        //javascript初始化
        $('#page3').bPage({
            url : '${pageContext.request.contextPath}/getPage',
            //开启异步处理模式
            asyncLoad : true,
            //关闭服务端页面模式
            serverSidePage : false,
            //数据自定义填充
            render : function(data){
                var tb = $('#dataGridTableJson tbody');
                $(tb).empty();
                if(data && data.list && data.list.length > 0){
                    $.each(data.list,function(i,row){
                        var tr = $('<tr>');
//                        $(tr).append('<td></td>');
                        $(tr).append('<td>'+row.userid+'</td>');
                        $(tr).append('<td>'+row.username+'</td>');
                        $(tr).append('<td>'+row.grade+'</td>');
                        $(tr).append('<td>'+row.settime+'</td>');
                        $(tr).append('<td>'+row.org+'</td>');
                        $(tb).append(tr);
                    });
                }
            },
            params : function(){
                return {
                    userid : $("#userid").val(),
                    startTime : $("#startTime").val(),
                    endTime : $("#endTime").val()
                };
            }
        });
        if($("#page3").children().length > 1){
            removeElement($("#page3").children()[$("#page3").children().length-1]);
        }
    }

    function removeElement(_element){
        var _parentElement = _element.parentNode;
        if(_parentElement){
            _parentElement.removeChild(_element);
        }
    }
</script>
</body>
</html>
