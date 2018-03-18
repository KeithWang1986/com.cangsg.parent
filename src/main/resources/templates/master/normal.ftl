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
	<#nested />	
	<#include "/webpart/footer.ftl" />
</body>
</html>
</#macro>