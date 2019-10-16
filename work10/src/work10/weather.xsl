<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>天气</title>
				<link rel="stylesheet" href="weather.css" type="text/css" media="all"/>
				<!-- <script type="text/javascript" src="detail.js"></script>
				<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script> -->
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
			</head>
			<body>
				<div class="seven_day_weather">
					<xsl:apply-templates select="//root"/>
				</div>
				
				<div class="hour_weather">
					<xsl:apply-templates select="//data[1]"/>
				</div>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="//root">
		<div class="top"><h3><xsl:value-of select="city"/>未来7天天气预报</h3></div>
		<xsl:for-each select="child::data">
			<div class="oneday">
				<p><xsl:value-of select="day"/></p>
				<p><xsl:value-of select="wea"/></p>
				<p><xsl:value-of select="tem1"/>/<xsl:value-of select="tem2"/></p>
				<p><xsl:value-of select="win"/></p>
				<p><xsl:value-of select="win_speed"/></p>
			</div>
		</xsl:for-each>
	</xsl:template>
  
  	<xsl:template match="//data[1]">
		<div style="color:red;">分时段预报</div>
		<xsl:for-each select="child::hours">
		<div class="onehour">
			<p><xsl:value-of select="day"/></p>
			<p><xsl:value-of select="tem"/></p>
			<p><xsl:value-of select="win"/></p>
			<p><xsl:value-of select="win_speed"/></p>
		</div>
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>