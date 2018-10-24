<html>
<head>
    <#include "${base}/common/include.ftl">
    <style>
        #my-page {
            float: right;
        }
        #current-page-item {
            background-color: cornflowerblue;
        }
    </style>
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
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>
                                编号
                            </th>
                            <th>
                                分类名称
                            </th>
                            <th>
                                分类类型
                            </th>
                            <th>
                                分类图标
                            </th>
                            <th>
                                创建时间
                            </th>
                            <th>
                                更新时间
                            </th>
                            <th colspan="2">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                <#list categoryPage.getList() as category>
                <tr>
                    <td>
                        ${category.categoryId}
                    </td>
                    <td>
                        ${category.categoryName}
                    </td>
                    <td>
                        ${category.categoryType}
                    </td>
                    <td>
                        <#if category.categoryIcon?starts_with("http")>
                            <img width="150px" height="150px" src="${category.categoryIcon}">
                        <#else >
                            <img width="150px" height="150px" src="${baseImg}${category.categoryIcon}">
                        </#if>
                    </td>
                    <td>
                        <#if (category.createTime)??>
                            ${category.createTime?string('yyyy-MM-dd hh:mm:ss')}
                        </#if>
                    </td>
                    <td>
                        <#if (category.updateTime)??>
                            ${category.updateTime?string('yyyy-MM-dd hh:mm:ss')}
                        </#if>
                    </td>
                    <td>
                        <a href="${base}/admin/category/update?id=${category.categoryId}">更新</a>
                    </td>
                    <td>
                        <a href="${base}/api/admin/category/delete?id=${category.categoryId}">删除</a>
                    </td>
                </tr>
                </#list>
                        </tbody>
                    </table>
                    <ul id="my-page" class="pagination pagination-lg">
                    <#--上一页---->
                <#if (currentPage <= 1)>
                <li class="disabled">
                    <a href="javascript:void()">上一页</a>
                </li>
                <#else >
                <li>
                    <a href="${base}/admin/category?page=${currentPage-1}">上一页</a>
                </li>
                </#if>

                    <#--中间页--->
                <#list 1..categoryPage.getPages() as index>
                    <#if (index == currentPage)>
                <li>

                    <a id="current-page-item" href="${base}/category?page=${index}">${index}</a>
                </li>
                    <#else >
                <li>
                    <a href="${base}/admin/category?page=${index}">${index}</a>
                </li>
                    </#if>
                </#list>

                    <#--下一页-->
                <#if (currentPage >= categoryPage.getPages())>
                <li class="disabled">
                    <a href="javascript:void()">下一页</a>
                </li>
                <#else >
                <li>
                    <a href="${base}/admin/category?page=${currentPage+1}">下一页</a>
                </li>
                </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>