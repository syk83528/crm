<html>
<head>
    <#include "../common/include.ftl">

    <style>
        #form-wrapper {
            margin: 0 auto;
            float: none;
        }
    </style>
</head>
<body>
<div id="wrapper" class="toggled">
<#--边栏sidebar-->
    <#include "../common/nav.ftl">
<#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div id="form-wrapper" class="col-md-2 column">
                    <form role="form" action="${base}/api/admin/login" method="post">

                        <div class="form-group">
                            <label>用户名</label>
                            <input type="text" class="form-control" name="username"/>
                        </div>

                        <div class="form-group">
                            <label>密码</label>
                        <#--<img width="150px" height="150px" src="${}">-->
                            <input type="password" class="form-control" name="password"/>
                        </div>

                        <button type="submit" class="btn btn-default col-md-12">
                            登录
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>