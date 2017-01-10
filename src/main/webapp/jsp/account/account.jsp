<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--</head>--%>
<%--<body>--%>
<section class="scrollable padder">
    <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
        <li><a href="index.html"><i class="fa fa-home"></i> Home</a></li>
        <li><a href="#">UI kit</a></li>
        <li><a href="#">Table</a></li>
        <li class="active">账号管理</li>
    </ul>
    <div class="m-b-md">
        <h3 class="m-b-none">账号管理</h3>
    </div>
    <section class="panel panel-default">
        <header class="panel-heading"> 账号信息 <i class="fa fa-info-sign text-muted"
                                               data-toggle="tooltip" data-placement="bottom"
                                               data-title="ajax to load the data."></i>
        </header>
        <div class="row text-sm wrapper">
            <div class="col-sm-5 m-b-xs">
                <button class="btn btn-sm btn-default" onclick="addData()">Add</button>
            </div>
            <div class="col-sm-4 m-b-xs">
                <div class="btn-group" data-toggle="buttons">
                    <label class="btn btn-sm btn-default active">
                        <input type="radio" name="options" id="option1">
                        Day </label>
                    <label class="btn btn-sm btn-default">
                        <input type="radio" name="options" id="option2">
                        Week </label>
                    <label class="btn btn-sm btn-default">
                        <input type="radio" name="options" id="option2">
                        Month </label>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="input-group">
                    <input type="text" class="input-sm form-control" placeholder="Search">
                    <span class="input-group-btn">
                    <button class="btn btn-sm btn-default" type="button">Go!</button>
                    </span></div>
            </div>
        </div>
        <div class="table-responsive">
            <table class="table table-striped m-b-none">
                <thead>
                <tr>
                    <th width="5%"><input id="mainCheckBox" type="checkbox"></th>
                    <th width="15%">账号</th>
                    <th width="15%">密码</th>
                    <th width="15%">描述</th>
                    <th width="15%">链接</th>
                    <th width="15%">类型</th>
                    <th width="15%">操作</th>
                </tr>
                </thead>
                <tbody id="accountData">
                </tbody>
            </table>
        </div>
        <footer class="panel-footer">
            <div id="tableFooter" class="row">
                <div id="footerBtn" class="col-sm-4 hidden-xs">
                    <button class="btn btn-sm btn-default" onclick="buklDel()">Bulk Delete</button>
                </div>

                <%--<div class="col-sm-4 text-right text-center-xs">--%>

                <%--<li><a onclick="prePage()"><i class="fa fa-chevron-left" ></i></a></li>--%>
                <%--<li><a onclick="changePage(1)">1</a></li>--%>
                <%--<li><a onclick="changePage(2)">2</a></li>--%>
                <%--<li><a >3</a></li>--%>
                <%--<li><a >4</a></li>--%>
                <%--<li><a >5</a></li>--%>
                <%--<li><a onclick="nextPage()"><i class="fa fa-chevron-right"></i></a></li>--%>
                <%--</ul>--%>
                <%--</div>--%>
            </div>
        </footer>
    </section>
</section>
<%--</body>--%>
<%--</html>--%>
