<html>
<head>
    <#include "../common/include.ftl">
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
    <#include "../common/nav.ftl">
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
                        </tr>
                        </thead>
                        <tbody>
                <#list categoryPage.getContent() as category>
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
                        <img width="150px" height="150px" src="${category.categoryIcon}">
                    </td>
                    <td>
                        ${category.createTime!""}
                    </td>
                    <td>
                        ${category.updateTime!""}
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
                <#else>
                <li>
                    <a href="${base}/category?page=${currentPage-1}">上一页</a>
                </li>
                </#if>

                    <#--中间页--->
                <#list 1..categoryPage.getTotalPages() as index>
                <#if (index == currentPage)>
                <li>

                    <a id="current-page-item" href="${base}/category?page=${index}">${index}</a>
                </li>
                <#else >
                <li>
                    <a href="${base}/category?page=${index}">${index}</a>
                </li>
                </#if>
                </#list>

                    <#--下一页-->
                <#if (currentPage >= categoryPage.getTotalPages())>
                <li class="disabled">
                    <a href="javascript:void()">下一页</a>
                </li>
                <#else >
                <li>
                    <a href="${base}/category?page=${currentPage+1}">下一页</a>
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