<html>
<head>
    <#include "../common/include.ftl">
</head>
<body>
<div id="wrapper" class="toggled">
<#--边栏sidebar-->
    <#include "../common/nav.ftl">
<#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-6 column">
                    <form role="form" action="${base}/api/admin/regist" method="post">

                        <div class="form-group">
                            <label>用户名</label>
                            <input type="text" class="form-control" name="name"/>
                        </div>

                        <div class="form-group">
                            <label>性别</label>
                            <input type="text" class="form-control" name="gender"/>
                        </div>

                        <div class="form-group">
                            <label>密码</label>
                        <#--<img width="150px" height="150px" src="${}">-->
                            <input type="password" class="form-control" name="password"/>
                        </div>

                        <button type="submit" class="btn btn-default">
                            确认注册
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>