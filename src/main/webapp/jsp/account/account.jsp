<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

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
        <div class="table-responsive">
            <table class="table table-striped m-b-none">
                <thead>
                <tr>
                    <th width="20%">账号</th>
                    <th width="25%">密码</th>
                    <th width="25%">描述</th>
                    <th width="15%">链接</th>
                    <th width="15%">类型</th>
                </tr>
                </thead>
                <tbody id="accountData">
                </tbody>
            </table>
        </div>
    </section>
</section>
</body>
</html>
