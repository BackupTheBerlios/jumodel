function moveCloud(msg){
	// ima: move the cloud to the top and add text to it
	var cloud = top.document.getElementById('Cloud');
	if(cloud){
		with(cloud.style) {
			cursor = "wait";
			zIndex = 10;
		}
		cloud.innerHTML = "<table style='width: 100%; height: 100%;'><tr><td>" +
			"<h1 style='vertical-align: middle; text-align: center;'>" + 
			"<img style='vertical-align: middle;margin-right:1em;' src='web/main/images/progress.gif'/>" + (msg?msg:top.msgLoading) + "</h1>" + 
			"</tr></td></table>";
	
	}

}
function showCloud(counter){
	if (!counter)
		counter = 1;

	var cloud = top.document.createElement('div');
	
	cloud.id = "Cloud";
	//init cloud so that 2 remove requests (2 frames) must vote to remove it
	cloud.setAttribute("counter", counter);
	if(top.iBrowserType == 2){
		cloud.style.filter="alpha(opacity=70)";			
	}
	else
		cloud.style.opacity = ".70";
		
	with(cloud.style){
		position = "absolute";
		left = 0;
		top = 0;
		width = window.innerWidth+"px";
		height = window.innerHeight+"px";
		backgroundColor = "white";
	}
	
	
		if(top.iBrowserType == 2) { // MSIE
		var iframe = top.document.createElement("<iframe id='CloudFrame' style='position: absolute; top:0px;left:0px;' ></iframe>");	
		cloud.style.zIndex	= 3;
 		iframe.style.zIndex = cloud.style.zIndex - 1;
  		iframe.style.width 	= cloud.style.width;
    	iframe.style.height = cloud.style.height;
    	iframe.style.filter = "alpha(opacity=0)";
    	iframe.style.top = cloud.style.top;
   		iframe.style.left = cloud.style.left;
   		
   		iframe.style.marginTop 		= cloud.style.marginTop;
   		iframe.style.marginLeft 	= cloud.style.marginLeft;
   		iframe.style.marginRight 	= cloud.style.marginRight;
   		iframe.style.marginBottom 	= cloud.style.marginBottom;
		
		top.document.getElementsByTagName('body')[0].appendChild(iframe);
	}
	
	
	
	top.document.getElementsByTagName('body')[0].appendChild(cloud);
}

function removeCloud() {
	var cloud = top.document.getElementById('Cloud');
	if(cloud){
	
		var c = cloud.getAttribute("counter");
		if (c == 0)//already removed
			return;
			
		c--;//decrease counter
		cloud.setAttribute("counter", c);
		
		if (c != 0)	//someone else must decrease
			return;
			
		cloud.parentNode.removeChild(cloud);
		if(document.all) { // MSIE
			var iframe = top.document.getElementById('CloudFrame');
			iframe.parentNode.removeChild(iframe);
		}
	}
}