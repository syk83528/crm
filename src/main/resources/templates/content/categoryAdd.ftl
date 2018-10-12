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
                <div class="col-md-12 column">
                    <form role="form" action="${base}/category/api/category/add" method="post">

                        <div class="form-group">
                            <label>分类名称</label>
                            <input type="text" class="form-control" name="name"/>
                        </div>

                        <div class="form-group">
                            <label>分类类型</label>
                            <input type="text" class="form-control" name="type"/>
                        </div>

                        <div class="form-group">
                            <label>分类图标</label>
                            <#--<img width="150px" height="150px" src="${}">-->
                            <input type="text" class="form-control" name="icon"/>
                        </div>

                        <button type="submit" class="btn btn-default">
                            提交
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>