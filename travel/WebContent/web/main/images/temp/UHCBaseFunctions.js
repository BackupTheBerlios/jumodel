// PNI: trim definition
String.prototype.trim = function() {
	return this.replace(/^\s+|\s+$/g,"");
}
String.prototype.ltrim = function() {
	return this.replace(/^\s+/,"");
}
String.prototype.rtrim = function() {
	return this.replace(/\s+$/,"");
}


function Nothing(){};
function TrueFct(){return true};
function FalseFct(){return false};

// PNI: MainMenu.jsf - fast document search
function findDocumentsTextField(evt, field){			   		
	var key = (evt.which) ? evt.which : evt.keyCode;		
	if(field){
		field.className ="menuContentSearchField"
	}
	
	if (key==13) {
		return findDocumentsImage()
	}
				  		
}

function findDocumentsImage(){
	var field = document.getElementById('MainMenuForm:searchDocsField');
	if((field.value).trim()!=""){
		var button = document.getElementById('MainMenuForm:searchDocsButton');
		var address = button.href;
		button.href = address+"?search="+(field.value).trim();
		top.goContext.getLowerFrame().getFrame(1).vWindow.document.location = button.href;
		button.href = address;
		return false;					
	}
	field.value="";	
	field.className ="menuContentSearchField_Mandatory"
	alert(top.msgFastDocumentSearch);
	field.focus();
	return false;
}
		   		   
function findDocumentsClearContent(){		   		
	var field = document.getElementById('MainMenuForm:searchDocsField');		  		
	field.value="";		  		
}

// SSO: MainMenu.jsf - notifier 
var notifierShown = false;
		   
function showNotifier(load){		
	if (notifierShown)
	return;
	notifierShown = true;
	var start = document.getElementById('notifier').clientWidth - 10;		   		
	animate(-250, -start, 0, 10);
	document.getElementById('notifierShow').style.display = 'none';	
	document.getElementById('notifierClose').style.display = 'block';	
		   				   		
	  	if (load){
	   		if (this.frames["reminderFrame"]){//exploder
	   			if (this.frames["reminderFrame"].loadMessages)//reminder may exire and is replaced with script
	   					this.frames["reminderFrame"].loadMessages();
	   			}
	   			else{
	   				var r = document.getElementById('reminderFrame').contentWindow;		   		
	   				if (r){//ff
	   					if (r.loadMessages)//reminder may exire and is replaced with script
	   						r.loadMessages();		
	   				}
	   				else{
	   					alert('cant load reminder messages!');
	   				}
	   			}
	   	}			   		
}
		   
function hideNotifier(){			   			   		
	if (!notifierShown)
	return;
	var stop = document.getElementById('notifier').clientWidth - 10;		   		
	animate(0, 0, -stop, -10);
	document.getElementById('notifierShow').style.display = 'block';		
	document.getElementById('notifierClose').style.display = 'none';	
	notifierShown = false;	   				   		
}
		   
function animate(pos, start, stop, leap){
   	if (pos == stop){//animation ends
	var finishOpacity = 0.9;//expand
		if (start > stop)//hide
			finishOpacity = 0.1;
		   	document.getElementById('notifyArea').style.opacity = finishOpacity;	
		   	document.getElementById('notifyArea').style.filter = 'alpha(opacity=' + finishOpacity * 100 + ')';
		   	//alert('stop');
		   	return;		   			
		}
	//alert('go');
	document.getElementById('notifier').style.left = pos+'px';
	pos += leap;		   		
	//==opacity
	var totalMovement = Math.abs(start - stop); 		   		
	var currentMovement = Math.abs(start - pos);
	var opacity = currentMovement/totalMovement;
		   				   		
	document.getElementById('notifyArea').style.opacity = opacity;
	document.getElementById('notifyArea').style.filter = 'alpha(opacity=' + opacity * 100 + ')';
	//==========
		   		
	window.setTimeout('animate(' + pos + ', ' + start + ', ' + stop + ', ' + leap + ')', 1);
}		   		   


function showInfo(info){
	alert(info);
}

function defined(object) {
	return (typeof(object) != 'undefined')
}

function isEmpty(sVal) {
	switch (typeof(sVal)){
		case 'undefined': return true;
		case 'object': return ((sVal instanceof Object) ? false : (sVal==null));
		case 'string':return (sVal == '')
		default:return false;
  }
}
function parseBool(bVal) {
	return  (((typeof(bVal)=='string') && (bVal=='0')) ? false : ((bVal) ? true:false))
}
function parseDecInt(sVal) {
	 return ((typeof(sVal)=='string') &&
	 			(sVal.length>1) &&
				( sVal.charAt(0)=="0" )
			  ) ?
			  parseDecInt(sVal.substr(1)) : (parseInt(sVal)|| 0)
}
function define(Val,Default){
	return ((typeof(Val) == 'undefined')? Default : Val);
}
function joinObjects(a,b){
	if ( a.length )
		for ( var i in b )
			a.push(b[i])
	else
		for ( var i in b )
			a[i] = b[i]
	return a;
}
function isEmptyObject(oVal){
	for ( var i in oVal )
		return false;
	return true;
}


function round(nVal, iPrec){
	nVal = parseFloat(nVal);
	iPrec = Math.pow(10,iPrec);
	return Math.round(nVal*iPrec)/iPrec ;
}


function isObjClicked(button){
	if (button.objClicked)
		return false;
	button.objClicked = true;
	return true;
}
	
function UHCBaseFunctions_moveCloud(msg){
	// ima: move the cloud to the top and add text to it
	var cloud = top.document.getElementById('Cloud');
	if(cloud){
		with(cloud.style) {
			cursor = "wait";
			zIndex = 10;
		}
		cloud.innerHTML = "<table style='width: 100%; height: 100%;'><tr><td>" +
			"<h1 style='vertical-align: middle; text-align: center;'>" + 
			"<img style='vertical-align: middle;margin-right:1em;' src='Pics/progress.gif'/>" + (msg?msg:top.msgLoading) + "</h1>" + 
			"</tr></td></table>";
	
	}

}
function UHCBaseFunctions_showCloud(counter){
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
		width = screen.width;
		height = screen.height;
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

function UHCBaseFunctions_removeCloud() {
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

function selectAll(src, dest){
	var inputs = document.getElementsByTagName('input');
	for (i=0;i<inputs.length;i++){
		if ((inputs[i].type=='checkbox') && (inputs[i].name.indexOf(dest)!=-1)){
			inputs[i].checked = src.checked;
		}
	}
}

function clickAll(src, chbx){
	var inputs = document.getElementsByTagName('input');
	var all = true;
	for (i=0;i<inputs.length;i++){
		if ((inputs[i].type=='checkbox') && (inputs[i].name.indexOf(src)!=-1)){
			all = (all && inputs[i].checked);
		}
	}
	
	findElement(chbx, 'input').checked = all;
	//document.getElementById(chbx).checked = all;
}

function checkboxCorrector(e, src, name, allVal, noneVal){
	if ( !e )
	   e = window.event;
	
	var val = ( e.srcElement||e.target ).value;
	
	var boxes = document.getElementsByName(name);
	
	var all;
	var none;
	var allChecked = true;
	var somethingchecked = false;
	for (i = 0; i < boxes.length; i++){
		if (boxes[i].value == noneVal) none = boxes[i];
		if (boxes[i].value == allVal) all = boxes[i];
		if (boxes[i].value != noneVal && boxes[i].value != allVal){
			allChecked = allChecked && boxes[i].checked;
			somethingchecked = somethingchecked || boxes[i].checked;
		}
	}
	
	if (this[name+"allCheck"] == undefined) this[name+"allCheck"] = false;
	
	if (val == noneVal) {
		for (i = 0; i < boxes.length; i++){
			boxes[i].checked = (boxes[i].value == noneVal);
		}
		this[name+"allCheck"] = false;
		return
	}
	if (val == allVal) {
		if (this[name+"allCheck"]) {
		// if all checked do uncheck
			for (i = 0; i < boxes.length; i++){
				boxes[i].checked = (boxes[i].value == noneVal);
			}
			this[name+"allCheck"] = false;
		}
		else {
		// if not all checked do check
			for (i = 0; i < boxes.length; i++){
				boxes[i].checked = (boxes[i].value != noneVal);
			}
			this[name+"allCheck"] = true;
		}	
		return
	}
	
	if (none) none.checked = !somethingchecked;
	if (all) all.checked = allChecked;	
	this[name+"allCheck"] = allChecked;
}

function listCorrector(e, src, name, allVal, noneVal){
	if ( !e )
	   e = window.event;
	
	val = ( e.srcElement||e.target ).value;
	
	var opts = src.options;  
	
	var all;
	var none;
	var allSelected = true;
	var somethingSelected = false;
	for (i = 0; i < opts.length; i++){
		if (opts[i].value == noneVal) none = opts[i];
		if (opts[i].value == allVal) all = opts[i];
		if (opts[i].value != noneVal && opts[i].value != allVal){
			allSelected = allSelected && opts[i].selected;
			somethingSelected = somethingSelected || opts[i].selected;
		}
	}
	
	if (this[name+"allSelect"] == undefined) this[name+"allSelect"] = false;
	
	if (val == noneVal) {
		if (none) none.selected = false;
	
		for (i = opts.length-1; i != -1; i--){
			opts[i].selected = (opts[i].value == noneVal);
		}
		this[name+"allSelect"] = false;
		return;
	}
	if (val == allVal && !this[name+"allSelect"]) {
		if (all) all.selected = false;	
		
		for (i = opts.length-1; i != -1; i--){
			opts[i].selected = (opts[i].value != noneVal);
		}
		this[name+"allSelect"] = true;
		return;
	}
	
	if (none) none.selected = !somethingSelected;
	if (all) all.selected = allSelected;	
	this[name+"allSelect"] = allSelected;
}

/*
 * finds element thats ID contains given id
 * slaweks
 */
function findElement(id, tagName){
		var elems = document.getElementsByTagName(tagName);
		for (var i=0; i<elems.length; i++){
			var elem = elems[i];
			if (elem.id.indexOf(id) != -1)
				return elem;
		}
}

/*
 * finds element thats name contains given string
 */
function findElementByName(name, tagName){
		var elems = document.getElementsByTagName(tagName);
		for (var i=0; i<elems.length; i++){
			var elem = elems[i];
			if (elem.name.indexOf(name) != -1)
				return elem;
		}
}

/*
 * adds *next* onload function
 * slaweks
 *
 * Usage:
 * addLoadEvent(nameOfSomeFunctionToRunOnPageLoad);
 * addLoadEvent(function() {
 *  // more code to run on page load 
 * });
 *
 */
function addLoadEvent(func) {
  var oldonload = window.onload;
  if (typeof window.onload != 'function') {
    window.onload = func;
  } else {
    window.onload = function() {
      if (oldonload) {
        oldonload();
      }
      func();
    }
  }
}
/**
 * Adds event listener to element
 * @author pawelgo
 * Usage:
 * addEventListenerToElement(document.getElementById('someId'),'click',functionName);
**/
function addEventListenerToElement(element, eventName , functionName ) {
	if( document.addEventListener ) {
		element.addEventListener( eventName , functionName , false );
	}
	else if( document.attachEvent ) {
		element.attachEvent( "on" + eventName , functionName );
	}
}

function openFirstRunWizard(){

	var first = window.top.goContext.getAppOption("firstRun");
	var oLink =  top.visible.lower.LowerLeft.document.getElementById('MainMenuForm:wizardLink')
	if (first && oLink)				
		oLink.onclick();
}

/*
 * PNI, MDO:
 * This function is called on every loaded page BEFORE use method displayHelp().
 * On pages with tabs it is called on click every tab.
 */
function setHelpUrl (url) {
	top.helpUrl = url;	

}


//PNI, MDO: Display help from all pages
function displayHelp() {	
	var win;
	var baseWindow = window;
	
	// get mother of all windows 
	while (baseWindow.opener) {		
		baseWindow = baseWindow.opener;		
	}

	/* PNI, MDO:
	 * Variable top.helpUrl is set on each page, 
	 * so we know what help page is to be open with certain page	 
	 */
		
	var url = top.helpUrl;
	
	if (url && (url != '')) {

		win = (window.open(url ,'help','menubar=no, toolbar=no, location=no, scrollbars=yes, resizable=yes, status=yes,fullscreen=yes')).focus();
		baseWindow.top.openedWindows.push(win);
		
	}
}


function displayHelpBaseLib() {	
	var win;
	
	/* PNI, MDO:
	 * Variable top.helpUrl is set on each page, 
	 * so we know what help page is to be open with certain page	 
	 */
		
	var url = top.helpUrl;
	
	if (url && (url != '')) {

//		win = window.open(url ,'help','menubar=no, toolbar=no, location=no, scrollbars=yes, resizable=yes, status=yes,fullscreen=yes');
		win =goContext.getLowerFrame().getFrame(1).CreateWindow(url ,'help','menubar=no, toolbar=no, location=no, scrollbars=yes, resizable=yes, status=yes,fullscreen=yes');
		top.openedWindows.push(win);
		win.focus()
		//win.SetFocus();		
	}
}

