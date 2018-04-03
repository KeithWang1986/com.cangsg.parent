<#macro head>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />	
	<#include "/webpart/header.ftl" />
	<#nested />	
</head>
</#macro>
<#macro body>
<body>
	<div class="page-head">
		<div class="page-box1 page-width"></div>
	</div>
	<div class="page-body">
		<div class="page-navigation page-width">
			<ul>
				<li><a class="select">LOREM</a></li>
				<li><a>IPSUM</a></li>
				<li><a>DOLOR</a></li>
				<li><a>SIT AMET</a></li>
				<li><a>ALIQUIP</a></li>
			</ul>
		</div>
		<div class="page-box2 page-width">			
			<#nested />
		</div>		
	</div>
	<div class="page-foot">
		<div class="page-box3 page-width"><div class="copy">©2016 Cangsg 京ICP备16035037号</div></div>
	</div>		
	<#include "/webpart/footer.ftl" />
</body>
</html>
</#macro>