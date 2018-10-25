<html>
<head>
    <#include "../../common/include.ftl">
    <link rel="stylesheet" href="${base}/editormd/css/editormd.min.css"/>

    <#--less处理-->
    <link rel="stylesheet/less" type="text/css" href="${base}/less/articleDetail.less" />
    <script src="${base}/less/less.js" type="text/javascript"></script>
</head>
<body>
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

    <div align="center" id="content-editormd">
        <textarea style="display:none;">${content.content}</textarea>
    </div>
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
</script>
</html>