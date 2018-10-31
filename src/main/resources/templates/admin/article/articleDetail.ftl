<!DOCTYPE html>
<html>
<head>
    <#include "../../common/include.ftl">
    <link rel="stylesheet" href="${base}/editormd/css/editormd.min.css"/>

    <#--less处理-->
    <link rel="stylesheet/less" type="text/css" href="${base}/less/articleDetail.less" />
    <script src="${base}/less/less.js" type="text/javascript"></script>
</head>
<body class="clearfix">
<#--标题-->
<div id="wrapper">
    <h1>${content.title!""}</h1>
    <#--人物头像,描述,创建时间,更新时间,点赞数目,收藏数目-->
    <div>
        <div>
            <img class="img-circle" width="50px" height="50px" src="${content.iconImage}">
        </div>
        <div>
            <label>
                <#if (content.updateTime)??>
                    ${content.updateTime?string('yyyy-MM-dd hh:mm:ss')}
                </#if>
            </label><br />
            <label></label>
        </div>
    </div>

    <div id="content-editormd">
        <textarea style="display:none;">${content.content}</textarea>
    </div>
</div>

<div class="clearfix" id="comment-add">
    <h1 style="text-align: center">评论区</h1>
    <input id="add-articleId" hidden type="text" value="${content.id}">
    <div class="form-group col-lg-4" style="padding-left: 0px">
        <input id="add-name" class="form-control" type="text" placeholder="请输入您的大名"/>
    </div>
    <div class="form-group">
        <textarea id="add-content" class="form-control" placeholder="编辑评论"></textarea>
    </div>
    <div class="form-group">
        <button class="btn btn-default pull-right" onclick="submit()">提交评论</button>
    </div>
</div>
<div id="comment-list">
    <div class="comment-title">
        <div class="comment-title-left">
            <span class="comment-count">${commentList?size}</span>条评论
            <span>只看作者</span>
        </div>
        <div class="comment-title-right">
            <label>按时间倒序</label>
            <label>按时间正序</label>
        </div>
    </div>

    <#list commentList as comment>
    <div class="comment">
        <div id="comment-header">
            <img class="comment-icon img-circle" width="40px" height="40px" src="${comment.icon}" alt="还看!戳你眼">
            <div class="comment-header-right">
                <label class="comment-name">${comment.name}</label>
                <span>
                <#if (comment.updateTime)??>
                    ${(comment.updateTime)?string('yyyy-MM-dd hh:mm:ss')}
                </#if>
                </span>
            </div>
        </div>
        <div id="comment-content">
            ${comment.content}
        </div>
    </div>
    </#list>
</div>


<script src="${base}/editormd/lib/jquery-3.1.1/jquery-3.1.1.js"></script>
<script src="${base}/editormd/editormd.js"></script>
<script src="${base}/editormd/lib/marked.min.js"></script>
<script src="${base}/editormd/lib/prettify.min.js"></script>
<script src="${base}/editormd/lib/raphael.min.js"></script>
<script src="${base}/editormd/lib/underscore.min.js"></script>
<script src="${base}/editormd/lib/sequence-diagram.min.js"></script>
<script src="${base}/editormd/lib/flowchart.min.js"></script>
<script src="${base}/editormd/lib/jquery.flowchart.min.js"></script>
<script type="text/javascript">
    $(function () {
        editormd.markdownToHTML("content-editormd", {
            htmlDecode: "style,script,iframe", //可以过滤标签解码
            emoji: true,
            taskList: true,
            tex: true,               // 默认不解析
            flowChart: true,         // 默认不解析
            sequenceDiagram: true, // 默认不解析
            codeFold: true
        });

    })


    function submit() {
        var name = $("#add-name").val();
        var content = $("#add-content").val();
        var articleId = $("#add-articleId").val();
        if (name.length <= 0) {
            alert("请填写姓名");
            return
        }
        if (content.length <= 0) {
            alert("请填写评论");
            return
        }
        if (articleId.length <= 0) {
            alert("文章不存在");
            return
        }

        // console.log(params);
        var params = {
            "articleId": articleId,
            "content": content,
            "name": name
        };

        var url = "${base}/comment/add";
        console.log(url);

        $.ajax({
            url: url,
            type : "POST",
            data: params,    //返回数据类型  //请求数据编码类型
            success: function (result) {
                if (result && result.code == 0) {
                    alert("评论成功");
                    location.reload(true);
                } else {
                    alert(result.msg);
                }
            }
        });

    }
</script>
</html>