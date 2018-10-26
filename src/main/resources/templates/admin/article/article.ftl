<html>
<head>
    <#include "../../common/include.ftl">
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
                                id
                            </th>
                            <th>
                                标题
                            </th>
                            <th>
                                内容
                            </th>
                            <th>
                                作者id
                            </th>
                            <th>
                                允许评论
                            </th>
                            <th>
                                点赞数
                            </th>
                            <th>
                                收藏数
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
                <#list articlePage.getList() as article>
                <tr>
                    <td>
                        ${article.getId()!""}
                    </td>
                    <td>
                        ${article.title!""}
                    </td>
                    <td>
                        <a href="/admin/article/${article.id}">${article.content!""}</a>
                    </td>
                    <td>
                        ${article.authorId!""}
                    </td>
                    <td>
                        <#if (article.allowComment)??>
                            ${(article.allowComment)?string('是','否')?html}
                        </#if>
                    </td>
                    <td>
                        ${article.likeCount!""}
                    </td>
                    <td>
                        ${article.collectCount!""}
                    </td>
                    <td>
                        <#if (article.createTime)??>
                            ${article.createTime?string('yyyy-MM-dd hh:mm:ss')}
                        </#if>
                    </td>
                    <td>
                        <#if (article.updateTime)??>
                            ${article.updateTime?string('yyyy-MM-dd hh:mm:ss')}
                        </#if>
                    </td>
                    <td>
                        <a href="${base}/admin/category/update?id=${article.id}">更新</a>
                    </td>
                    <td>
                        <a href="${base}/api/admin/category/delete?id=${article.id}">删除</a>
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
                <#list 1..articlePage.getPages() as index>
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
                <#if (currentPage >= articlePage.getPages())>
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