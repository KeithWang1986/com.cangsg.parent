<#import "master/normal.ftl" as page />

<@page.head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="/s/${clientnumber}/dist/css/index.css" />
</@page.head>

<@page.body>
    <div id="root"></div>
    <br/>
    <br/>
    <hr id="a" style="display: block;border-top: none rgb(0, 188, 212); border-left: none rgb(0, 188, 212); border-right: none rgb(0, 188, 212); border-bottom: 2px solid rgb(0, 188, 212); bottom: 8px; box-sizing: content-box; margin: 0px; width: 100%; transform: scaleX(0); transition: opacity 2s cubic-bezier(0.23, 1, 0.32, 1) 0ms, transform 1s cubic-bezier(0.23, 1, 0.32, 1) 0ms;" />
    <br/>
    <div id="b" style="width:45px;height:45px;border:1px solid blue;position:relative;">
    </div>
    <br/>
    <div id="c" style="color: rgba(0, 0, 0, 0.87); background-color:rgb(245, 245, 245); transition: all 1s cubic-bezier(0.23, 1, 0.32, 1) 0ms; box-sizing: border-box; font-family: Roboto, sans-serif; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); box-shadow: rgba(0, 0, 0, 0.12) 0px 1px 6px, rgba(0, 0, 0, 0.12) 0px 1px 4px; border-radius: 50%; position: relative; top: 1px; width: 20px; height: 20px; line-height: 24px; margin-left: -20px;"><!-- react-text: 550 --> <!-- /react-text --><div><span style="height: 200%; width: 200%; position: absolute; top: -10px; left: -10px; overflow: hidden; pointer-events: none; z-index: 1; color: rgb(0, 188, 212);"></span></div><div style="position: absolute; height: 100%; width: 100%; top: 0px; left: 0px;"></div><!-- react-text: 553 --> <!-- /react-text --></div>
    <div>
    <script type="text/javascript">
        function XF() {
            document.getElementById("a").style.transform = "scale(1)";
            setTimeout(()=>{
                document.getElementById("a").style.transform = "scale(0)";
            },4000);            
        }
        function XF2() {
            var x = document.createElement("div");
            x.setAttribute("style", "position:absolute;left:-1px;top:-1px;height:45px;width:45px;border-radius:50%;background-color:rgba(220, 220, 220, 1);opacity:1;transform:scale(0);transition:opacity 2s cubic-bezier(0.23,1,0.32,1) 0ms, transform 1s cubic-bezier(0.23,1,0.32,1) 0ms;")
            document.getElementById("b").appendChild(x);             
            if(x.sender!=null){
                clearTimeout(x.sender);
            }  
            if(x.sender2!=null){
                clearTimeout(x.sender2);
            }         
            x.sender = setTimeout(() => {
                x.style.backgroundColor = "rgba(220, 220, 220, 1)";
                x.style.transform = "scale(1)";
                x.style.opacity = 0;
                x.sender2 = setTimeout(() => {                                    
                    x.parentNode.removeChild(x);
                }, 2000);
            }, 100);                        
        }
        var ccc=true;
        function XF3() {
            if(ccc){
                ccc=false;
                document.getElementById("c").style.marginLeft = "100px";     
                document.getElementById("c").style.backgroundColor="rgb(0, 188, 212)";  
            }
            else{
                ccc=true;
                document.getElementById("c").style.marginLeft = "0px";     
                document.getElementById("c").style.backgroundColor="rgb(245, 245, 245)"; 
            }
        }
    </script>
    <input type="button" value="动画" onclick="XF()" />
    <input type="button" value="动画" onclick="XF2()" />
    <input type="button" value="动画" onclick="XF3()" />
    <script type="text/javascript" src="/s/${clientnumber}/dist/ext.js"></script>
    <script type="text/javascript" src="/s/${clientnumber}/dist/index.js"></script>
</@page.body>