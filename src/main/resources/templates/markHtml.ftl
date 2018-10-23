<html>
<head>
    <#include "./common/include.ftl">
    <link rel="stylesheet" href="../editormd//css/editormd.min.css"/>
    <style>
        #content li{
            list-style:disc;
        }
    </style>
</head>
<body>

<div id="content-editormd">
    <textarea style="display:none;">${content.content}</textarea>
</div>


<script src="../editormd/lib/jquery-3.1.1/jquery-3.1.1.js"></script>
<script src="../editormd/editormd.js"></script>
<script src="../editormd/lib/marked.min.js"></script>
<script src="../editormd/lib/prettify.min.js"></script>
<script src="../editormd/lib/raphael.min.js"></script>
<script src="../editormd/lib/underscore.min.js"></script>
<script src="../editormd/lib/sequence-diagram.min.js"></script>
<script src="../editormd/lib/flowchart.min.js"></script>
<script src="../editormd/lib/jquery.flowchart.min.js"></script>
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