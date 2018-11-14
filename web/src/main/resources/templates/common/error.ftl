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
                    <div class="alert alert-dismissable alert-success">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4>提示!</h4>
                        操作失败!
                        <a href="${base}" class="alert-link">
                            2s后将跳转操作页面
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    setTimeout(function () {
        <#if (url)??>
            location.href= "${base}${url}";
        <#else >
            location.href="${base}";
        </#if>
    },2000);

</script>