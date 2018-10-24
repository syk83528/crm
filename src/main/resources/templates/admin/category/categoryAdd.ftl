<html>
<head>
    <#include "${base}/common/include.ftl">
</head>
<body>
<div id="wrapper" class="toggled">
<#--边栏sidebar-->
    <#include "${base}/common/nav.ftl">
<#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" action="${base}/api/admin/category/add" method="post" enctype="multipart/form-data">

                        <div class="form-group">
                            <label>分类名称</label>
                            <input type="text" class="form-control" name="name"/>
                        </div>

                        <div class="form-group">
                            <label>分类类型</label>
                            <input type="text" class="form-control" name="type" value="${(maxType+1)!""}"/>
                        </div>

                        <div class="form-group">
                            <label>分类图标</label>
                            <#--<img width="150px" height="150px" src="${}">-->
                            <input type="text" class="form-control" name="icon"/>
                        </div>

                        <#--图片上传-->
                        <div class="form-group">
                            <label >File input</label>
                            <input type="file" name="file"/>
                            <p class="help-block">
                                上传分类图片,单张不能大于10mb,总文件不能大于50mb
                            </p>
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