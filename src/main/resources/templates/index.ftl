<#import "master/normal.ftl" as page />

<@page.head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="/s/${clientnumber}/dist/css/index.css" />    
</@page.head>

<@page.body>
    <div id="root"></div>
    <div style="height:500px;width:500px;border:1px solid red"></div>
    
    <script type="text/javascript" src="/s/${clientnumber}/dist/ext.js"></script>
    <script type="text/javascript" src="/s/${clientnumber}/dist/index.js"></script>
</@page.body>
