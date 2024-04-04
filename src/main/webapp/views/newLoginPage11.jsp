<html lang="en">
<head>
<meta charset="utf-8">
<link rel="icon" href="/logo.png">
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta name="theme-color" content="#000000">
<meta name="description"
	content="Resustainability is a one-stop solution provider to its clients for all its environmental issues including water pollution, waste water treatment and contamination.">
<link rel="apple-touch-icon" href="/iris/resources/images/logo/logo.png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300&amp;display=swap"
	rel="stylesheet">
<style>
* {
	font-family: 'Open Sans', sans-serif;
	box-sizing: border-box;
	margin: 0
}
</style>
<link rel="manifest" href="/manifest.json">
<title>Login Page - IRIS</title>
<script defer="defer" src="/iris/resources/js1/main.js"></script>
<link href="/iris/resources/css1/main.css" rel="stylesheet">
<style data-emotion="css" data-s=""></style>
<style id="apexcharts-css">
.apexcharts-canvas {
	position: relative;
	user-select: none;
	/* cannot give overflow: hidden as it will crop tooltips which overflow outside chart area */
}

/* scrollbar is not visible by default for legend, hence forcing the visibility */
.apexcharts-canvas ::-webkit-scrollbar {
	-webkit-appearance: none;
	width: 6px;
}

.apexcharts-canvas ::-webkit-scrollbar-thumb {
	border-radius: 4px;
	background-color: rgba(0, 0, 0, .5);
	box-shadow: 0 0 1px rgba(255, 255, 255, .5);
	-webkit-box-shadow: 0 0 1px rgba(255, 255, 255, .5);
}

.apexcharts-inner {
	position: relative;
}

.apexcharts-text tspan {
	font-family: inherit;
}

.legend-mouseover-inactive {
	transition: 0.15s ease all;
	opacity: 0.20;
}

.apexcharts-series-collapsed {
	opacity: 0;
}

.apexcharts-tooltip {
	border-radius: 5px;
	box-shadow: 2px 2px 6px -4px #999;
	cursor: default;
	font-size: 14px;
	left: 62px;
	opacity: 0;
	pointer-events: none;
	position: absolute;
	top: 20px;
	display: flex;
	flex-direction: column;
	overflow: hidden;
	white-space: nowrap;
	z-index: 12;
	transition: 0.15s ease all;
}

.apexcharts-tooltip.apexcharts-active {
	opacity: 1;
	transition: 0.15s ease all;
}

.apexcharts-tooltip.apexcharts-theme-light {
	border: 1px solid #e3e3e3;
	background: rgba(255, 255, 255, 0.96);
}

.apexcharts-tooltip.apexcharts-theme-dark {
	color: #fff;
	background: rgba(30, 30, 30, 0.8);
}

.apexcharts-tooltip * {
	font-family: inherit;
}

.apexcharts-tooltip-title {
	padding: 6px;
	font-size: 15px;
	margin-bottom: 4px;
}

.apexcharts-tooltip.apexcharts-theme-light .apexcharts-tooltip-title {
	background: #ECEFF1;
	border-bottom: 1px solid #ddd;
}

.apexcharts-tooltip.apexcharts-theme-dark .apexcharts-tooltip-title {
	background: rgba(0, 0, 0, 0.7);
	border-bottom: 1px solid #333;
}

.apexcharts-tooltip-text-y-value, .apexcharts-tooltip-text-goals-value,
	.apexcharts-tooltip-text-z-value {
	display: inline-block;
	font-weight: 600;
	margin-left: 5px;
}

.apexcharts-tooltip-title:empty, .apexcharts-tooltip-text-y-label:empty,
	.apexcharts-tooltip-text-y-value:empty,
	.apexcharts-tooltip-text-goals-label:empty,
	.apexcharts-tooltip-text-goals-value:empty,
	.apexcharts-tooltip-text-z-value:empty {
	display: none;
}

.apexcharts-tooltip-text-y-value, .apexcharts-tooltip-text-goals-value,
	.apexcharts-tooltip-text-z-value {
	font-weight: 600;
}

.apexcharts-tooltip-text-goals-label,
	.apexcharts-tooltip-text-goals-value {
	padding: 6px 0 5px;
}

.apexcharts-tooltip-goals-group, .apexcharts-tooltip-text-goals-label,
	.apexcharts-tooltip-text-goals-value {
	display: flex;
}

.apexcharts-tooltip-text-goals-label:not(:empty),
	.apexcharts-tooltip-text-goals-value:not(:empty) {
	margin-top: -6px;
}

.apexcharts-tooltip-marker {
	width: 12px;
	height: 12px;
	position: relative;
	top: 0px;
	margin-right: 10px;
	border-radius: 50%;
}

.apexcharts-tooltip-series-group {
	padding: 0 10px;
	display: none;
	text-align: left;
	justify-content: left;
	align-items: center;
}

.apexcharts-tooltip-series-group.apexcharts-active .apexcharts-tooltip-marker
	{
	opacity: 1;
}

.apexcharts-tooltip-series-group.apexcharts-active,
	.apexcharts-tooltip-series-group:last-child {
	padding-bottom: 4px;
}

.apexcharts-tooltip-series-group-hidden {
	opacity: 0;
	height: 0;
	line-height: 0;
	padding: 0 !important;
}

.apexcharts-tooltip-y-group {
	padding: 6px 0 5px;
}

.apexcharts-tooltip-box, .apexcharts-custom-tooltip {
	padding: 4px 8px;
}

.apexcharts-tooltip-boxPlot {
	display: flex;
	flex-direction: column-reverse;
}

.apexcharts-tooltip-box>div {
	margin: 4px 0;
}

.apexcharts-tooltip-box span.value {
	font-weight: bold;
}

.apexcharts-tooltip-rangebar {
	padding: 5px 8px;
}

.apexcharts-tooltip-rangebar .category {
	font-weight: 600;
	color: #777;
}

.apexcharts-tooltip-rangebar .series-name {
	font-weight: bold;
	display: block;
	margin-bottom: 5px;
}

.apexcharts-xaxistooltip {
	opacity: 0;
	padding: 9px 10px;
	pointer-events: none;
	color: #373d3f;
	font-size: 13px;
	text-align: center;
	border-radius: 2px;
	position: absolute;
	z-index: 10;
	background: #ECEFF1;
	border: 1px solid #90A4AE;
	transition: 0.15s ease all;
}

.apexcharts-xaxistooltip.apexcharts-theme-dark {
	background: rgba(0, 0, 0, 0.7);
	border: 1px solid rgba(0, 0, 0, 0.5);
	color: #fff;
}

.apexcharts-xaxistooltip:after, .apexcharts-xaxistooltip:before {
	left: 50%;
	border: solid transparent;
	content: " ";
	height: 0;
	width: 0;
	position: absolute;
	pointer-events: none;
}

.apexcharts-xaxistooltip:after {
	border-color: rgba(236, 239, 241, 0);
	border-width: 6px;
	margin-left: -6px;
}

.apexcharts-xaxistooltip:before {
	border-color: rgba(144, 164, 174, 0);
	border-width: 7px;
	margin-left: -7px;
}

.apexcharts-xaxistooltip-bottom:after, .apexcharts-xaxistooltip-bottom:before
	{
	bottom: 100%;
}

.apexcharts-xaxistooltip-top:after, .apexcharts-xaxistooltip-top:before
	{
	top: 100%;
}

.apexcharts-xaxistooltip-bottom:after {
	border-bottom-color: #ECEFF1;
}

.apexcharts-xaxistooltip-bottom:before {
	border-bottom-color: #90A4AE;
}

.apexcharts-xaxistooltip-bottom.apexcharts-theme-dark:after {
	border-bottom-color: rgba(0, 0, 0, 0.5);
}

.apexcharts-xaxistooltip-bottom.apexcharts-theme-dark:before {
	border-bottom-color: rgba(0, 0, 0, 0.5);
}

.apexcharts-xaxistooltip-top:after {
	border-top-color: #ECEFF1
}

.apexcharts-xaxistooltip-top:before {
	border-top-color: #90A4AE;
}

.apexcharts-xaxistooltip-top.apexcharts-theme-dark:after {
	border-top-color: rgba(0, 0, 0, 0.5);
}

.apexcharts-xaxistooltip-top.apexcharts-theme-dark:before {
	border-top-color: rgba(0, 0, 0, 0.5);
}

.apexcharts-xaxistooltip.apexcharts-active {
	opacity: 1;
	transition: 0.15s ease all;
}

.apexcharts-yaxistooltip {
	opacity: 0;
	padding: 4px 10px;
	pointer-events: none;
	color: #373d3f;
	font-size: 13px;
	text-align: center;
	border-radius: 2px;
	position: absolute;
	z-index: 10;
	background: #ECEFF1;
	border: 1px solid #90A4AE;
}

.apexcharts-yaxistooltip.apexcharts-theme-dark {
	background: rgba(0, 0, 0, 0.7);
	border: 1px solid rgba(0, 0, 0, 0.5);
	color: #fff;
}

.apexcharts-yaxistooltip:after, .apexcharts-yaxistooltip:before {
	top: 50%;
	border: solid transparent;
	content: " ";
	height: 0;
	width: 0;
	position: absolute;
	pointer-events: none;
}

.apexcharts-yaxistooltip:after {
	border-color: rgba(236, 239, 241, 0);
	border-width: 6px;
	margin-top: -6px;
}

.apexcharts-yaxistooltip:before {
	border-color: rgba(144, 164, 174, 0);
	border-width: 7px;
	margin-top: -7px;
}

.apexcharts-yaxistooltip-left:after, .apexcharts-yaxistooltip-left:before
	{
	left: 100%;
}

.apexcharts-yaxistooltip-right:after, .apexcharts-yaxistooltip-right:before
	{
	right: 100%;
}

.apexcharts-yaxistooltip-left:after {
	border-left-color: #ECEFF1;
}

.apexcharts-yaxistooltip-left:before {
	border-left-color: #90A4AE;
}

.apexcharts-yaxistooltip-left.apexcharts-theme-dark:after {
	border-left-color: rgba(0, 0, 0, 0.5);
}

.apexcharts-yaxistooltip-left.apexcharts-theme-dark:before {
	border-left-color: rgba(0, 0, 0, 0.5);
}

.apexcharts-yaxistooltip-right:after {
	border-right-color: #ECEFF1;
}

.apexcharts-yaxistooltip-right:before {
	border-right-color: #90A4AE;
}

.apexcharts-yaxistooltip-right.apexcharts-theme-dark:after {
	border-right-color: rgba(0, 0, 0, 0.5);
}

.apexcharts-yaxistooltip-right.apexcharts-theme-dark:before {
	border-right-color: rgba(0, 0, 0, 0.5);
}

.apexcharts-yaxistooltip.apexcharts-active {
	opacity: 1;
}

.apexcharts-yaxistooltip-hidden {
	display: none;
}

.apexcharts-xcrosshairs, .apexcharts-ycrosshairs {
	pointer-events: none;
	opacity: 0;
	transition: 0.15s ease all;
}

.apexcharts-xcrosshairs.apexcharts-active, .apexcharts-ycrosshairs.apexcharts-active
	{
	opacity: 1;
	transition: 0.15s ease all;
}

.apexcharts-ycrosshairs-hidden {
	opacity: 0;
}

.apexcharts-selection-rect {
	cursor: move;
}

.svg_select_boundingRect, .svg_select_points_rot {
	pointer-events: none;
	opacity: 0;
	visibility: hidden;
}

.apexcharts-selection-rect+g .svg_select_boundingRect,
	.apexcharts-selection-rect+g .svg_select_points_rot {
	opacity: 0;
	visibility: hidden;
}

.apexcharts-selection-rect+g .svg_select_points_l,
	.apexcharts-selection-rect+g .svg_select_points_r {
	cursor: ew-resize;
	opacity: 1;
	visibility: visible;
}

.svg_select_points {
	fill: #efefef;
	stroke: #333;
	rx: 2;
}

.apexcharts-svg.apexcharts-zoomable.hovering-zoom {
	cursor: crosshair
}

.apexcharts-svg.apexcharts-zoomable.hovering-pan {
	cursor: move
}

.apexcharts-zoom-icon, .apexcharts-zoomin-icon, .apexcharts-zoomout-icon,
	.apexcharts-reset-icon, .apexcharts-pan-icon,
	.apexcharts-selection-icon, .apexcharts-menu-icon,
	.apexcharts-toolbar-custom-icon {
	cursor: pointer;
	width: 20px;
	height: 20px;
	line-height: 24px;
	color: #6E8192;
	text-align: center;
}

.apexcharts-zoom-icon svg, .apexcharts-zoomin-icon svg,
	.apexcharts-zoomout-icon svg, .apexcharts-reset-icon svg,
	.apexcharts-menu-icon svg {
	fill: #6E8192;
}

.apexcharts-selection-icon svg {
	fill: #444;
	transform: scale(0.76)
}

.apexcharts-theme-dark .apexcharts-zoom-icon svg, .apexcharts-theme-dark .apexcharts-zoomin-icon svg,
	.apexcharts-theme-dark .apexcharts-zoomout-icon svg,
	.apexcharts-theme-dark .apexcharts-reset-icon svg,
	.apexcharts-theme-dark .apexcharts-pan-icon svg, .apexcharts-theme-dark .apexcharts-selection-icon svg,
	.apexcharts-theme-dark .apexcharts-menu-icon svg,
	.apexcharts-theme-dark .apexcharts-toolbar-custom-icon svg {
	fill: #f3f4f5;
}

.apexcharts-canvas .apexcharts-zoom-icon.apexcharts-selected svg,
	.apexcharts-canvas .apexcharts-selection-icon.apexcharts-selected svg,
	.apexcharts-canvas .apexcharts-reset-zoom-icon.apexcharts-selected svg
	{
	fill: #008FFB;
}

.apexcharts-theme-light .apexcharts-selection-icon:not(.apexcharts-selected):hover svg,
	.apexcharts-theme-light .apexcharts-zoom-icon:not(.apexcharts-selected):hover svg,
	.apexcharts-theme-light .apexcharts-zoomin-icon:hover svg,
	.apexcharts-theme-light .apexcharts-zoomout-icon:hover svg,
	.apexcharts-theme-light .apexcharts-reset-icon:hover svg,
	.apexcharts-theme-light .apexcharts-menu-icon:hover svg {
	fill: #333;
}

.apexcharts-selection-icon, .apexcharts-menu-icon {
	position: relative;
}

.apexcharts-reset-icon {
	margin-left: 5px;
}

.apexcharts-zoom-icon, .apexcharts-reset-icon, .apexcharts-menu-icon {
	transform: scale(0.85);
}

.apexcharts-zoomin-icon, .apexcharts-zoomout-icon {
	transform: scale(0.7)
}

.apexcharts-zoomout-icon {
	margin-right: 3px;
}

.apexcharts-pan-icon {
	transform: scale(0.62);
	position: relative;
	left: 1px;
	top: 0px;
}

.apexcharts-pan-icon svg {
	fill: #fff;
	stroke: #6E8192;
	stroke-width: 2;
}

.apexcharts-pan-icon.apexcharts-selected svg {
	stroke: #008FFB;
}

.apexcharts-pan-icon:not(.apexcharts-selected):hover svg {
	stroke: #333;
}

.apexcharts-toolbar {
	position: absolute;
	z-index: 11;
	max-width: 176px;
	text-align: right;
	border-radius: 3px;
	padding: 0px 6px 2px 6px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.apexcharts-menu {
	background: #fff;
	position: absolute;
	top: 100%;
	border: 1px solid #ddd;
	border-radius: 3px;
	padding: 3px;
	right: 10px;
	opacity: 0;
	min-width: 110px;
	transition: 0.15s ease all;
	pointer-events: none;
}

.apexcharts-menu.apexcharts-menu-open {
	opacity: 1;
	pointer-events: all;
	transition: 0.15s ease all;
}

.apexcharts-menu-item {
	padding: 6px 7px;
	font-size: 12px;
	cursor: pointer;
}

.apexcharts-theme-light .apexcharts-menu-item:hover {
	background: #eee;
}

.apexcharts-theme-dark .apexcharts-menu {
	background: rgba(0, 0, 0, 0.7);
	color: #fff;
}

@media screen and (min-width: 768px) {
	.apexcharts-canvas:hover .apexcharts-toolbar {
		opacity: 1;
	}
}

.apexcharts-datalabel.apexcharts-element-hidden {
	opacity: 0;
}

.apexcharts-pie-label, .apexcharts-datalabels, .apexcharts-datalabel,
	.apexcharts-datalabel-label, .apexcharts-datalabel-value {
	cursor: default;
	pointer-events: none;
}

.apexcharts-pie-label-delay {
	opacity: 0;
	animation-name: opaque;
	animation-duration: 0.3s;
	animation-fill-mode: forwards;
	animation-timing-function: ease;
}

.apexcharts-canvas .apexcharts-element-hidden {
	opacity: 0;
}

.apexcharts-hide .apexcharts-series-points {
	opacity: 0;
}

.apexcharts-gridline, .apexcharts-annotation-rect, .apexcharts-tooltip .apexcharts-marker,
	.apexcharts-area-series .apexcharts-area, .apexcharts-line,
	.apexcharts-zoom-rect, .apexcharts-toolbar svg, .apexcharts-area-series .apexcharts-series-markers .apexcharts-marker.no-pointer-events,
	.apexcharts-line-series .apexcharts-series-markers .apexcharts-marker.no-pointer-events,
	.apexcharts-radar-series path, .apexcharts-radar-series polygon {
	pointer-events: none;
}

/* markers */
.apexcharts-marker {
	transition: 0.15s ease all;
}

@
keyframes opaque { 0% {
	opacity: 0;
}

100
%
{
opacity
:
1;
}
}

/* Resize generated styles */
@
keyframes resizeanim {from { opacity:0;
	
}

to {
	opacity: 0;
}

}
.resize-triggers {
	animation: 1ms resizeanim;
	visibility: hidden;
	opacity: 0;
}

.resize-triggers, .resize-triggers>div, .contract-trigger:before {
	content: " ";
	display: block;
	position: absolute;
	top: 0;
	left: 0;
	height: 100%;
	width: 100%;
	overflow: hidden;
}

.resize-triggers>div {
	background: #eee;
	overflow: auto;
}

.contract-trigger:before {
	width: 200%;
	height: 200%;
}
</style>
</head>
<body style="">
	<noscript>You need to enable JavaScript to run this app.</noscript>
	<div id="root">
		<div class="App_App__1WLdD">
			<div class="landingpage_container__9l4uZ">
				<div class="loginsidebar_container__Bx-w8">
					<div class="loginsidebar_subContainer__5IGr0">
						<div class="loginsidebar_bannerImg__H1hLa">
							<img src="/iris/resources/images/banner/newbanner.png"	
								alt="banner">
						</div>
					</div>
				</div>
				<div class="signin_container__gah7X">
					<div class="signin_subcontainer__uL6na">
						<form class="signin_innerSubContainer__k25ca">
							<h1>Sign In</h1>
							<p>Enter your official email ID and password to use the
								application</p>
							<div class="signin_innSubConFirst__1NDQu">
								<svg
									class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium signin_icon__+SiYq css-vubbuv"
									focusable="false" aria-hidden="true" viewBox="0 0 24 24"
									data-testid="EmailIcon">
									<path
										d="M20 4H4c-1.1 0-1.99.9-1.99 2L2 18c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V6c0-1.1-.9-2-2-2zm0 4-8 5-8-5V6l8 5 8-5v2z"></path></svg>
								<input type="text" placeholder="Email ID" name="emailId"
									value="admin@gmail.com">
							</div>
							<p class="signin_error__dOUFp" data-testid="emailError"></p>
							<div class="signin_innSubConFirst__1NDQu">
								<svg
									class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium signin_icon__+SiYq css-vubbuv"
									focusable="false" aria-hidden="true" viewBox="0 0 24 24"
									data-testid="LockIcon">
									<path
										d="M18 8h-1V6c0-2.76-2.24-5-5-5S7 3.24 7 6v2H6c-1.1 0-2 .9-2 2v10c0 1.1.9 2 2 2h12c1.1 0 2-.9 2-2V10c0-1.1-.9-2-2-2zm-6 9c-1.1 0-2-.9-2-2s.9-2 2-2 2 .9 2 2-.9 2-2 2zm3.1-9H8.9V6c0-1.71 1.39-3.1 3.1-3.1 1.71 0 3.1 1.39 3.1 3.1v2z"></path></svg>
								<input placeholder="Password" type="password" name="password"
									value="Admin@ReIris321">
								<div>
									<svg
										class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium signin_icon__+SiYq css-vubbuv"
										focusable="false" aria-hidden="true" viewBox="0 0 24 24"
										data-testid="VisibilityOffIcon">
										<path
											d="M12 7c2.76 0 5 2.24 5 5 0 .65-.13 1.26-.36 1.83l2.92 2.92c1.51-1.26 2.7-2.89 3.43-4.75-1.73-4.39-6-7.5-11-7.5-1.4 0-2.74.25-3.98.7l2.16 2.16C10.74 7.13 11.35 7 12 7zM2 4.27l2.28 2.28.46.46C3.08 8.3 1.78 10.02 1 12c1.73 4.39 6 7.5 11 7.5 1.55 0 3.03-.3 4.38-.84l.42.42L19.73 22 21 20.73 3.27 3 2 4.27zM7.53 9.8l1.55 1.55c-.05.21-.08.43-.08.65 0 1.66 1.34 3 3 3 .22 0 .44-.03.65-.08l1.55 1.55c-.67.33-1.41.53-2.2.53-2.76 0-5-2.24-5-5 0-.79.2-1.53.53-2.2zm4.31-.78 3.15 3.15.02-.16c0-1.66-1.34-3-3-3l-.17.01z"></path></svg>
								</div>
							</div>
							<p class="signin_error__dOUFp" data-testid="errorPassword"></p>
							<span class="signin_forgotLink__UYP1r"> <a
								href="/forgot-password">Forgot Password?</a></span>
							<div class="signin_login__Fkg79">
								<button type="submit">Sign In</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="Toastify"></div>
		</div>
	</div>
	<svg id="SvgjsSvg1001" width="2" height="0"
		xmlns="http://www.w3.org/2000/svg" version="1.1"
		xmlns:xlink="http://www.w3.org/1999/xlink"
		xmlns:svgjs="http://svgjs.dev"
		style="overflow: hidden; top: -100%; left: -100%; position: absolute; opacity: 0;">
		<defs id="SvgjsDefs1002"></defs>
		<polyline id="SvgjsPolyline1003" points="0,0"></polyline>
		<path id="SvgjsPath1004" d="M0 0 "></path></svg>
</body>
</html>