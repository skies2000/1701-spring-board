/**
 * 
 */

var cnt = 0;
function attFileAppend(ev){

	var tags = document.getElementsByClassName('fileName');
	var yn = true;
	
	for(var t = 0; t<tags.length-1 ; t++){
		if(tags[t].value == ''){
			var br = tags[t].nextElementSibling;
			var img = tags[t].previousElementSibling;
			
			img.parentNode.removeChild(img);
			br.parentNode.removeChild(br);
			tags[t].parentNode.removeChild(tags[t]);
			yn = false;
		} 
	}
	
	if(yn){
	cnt++;
	
	var img = document.createElement("img");
	var br = document.createElement("br");
	var file = document.createElement("input");
	
	
	file.setAttribute('type','file');
	file.setAttribute('class','fileName');
	file.setAttribute('name','fileName'+cnt);
	
	file.onchange = attFileAppend;
			
	img.setAttribute("width", "30px");
	img.setAttribute("align", "center");
	img.setAttribute("id","fileName"+cnt);
	
	
	var div = document.getElementById("fileatt");
	div.appendChild(img);
	div.appendChild(file);
	div.appendChild(br);
	
	var event = ev || window.event;
	if(event ==null) return;
	
	var target = event.srcElement;
	var tagName = target.name;
	var url = target.files[0];
	var reader = new FileReader();
	reader.onload=function(ev2){
		var img = new Image();
		img.src = ev2.target.result;
		document.getElementById(tagName).src  = img.src;
		}
	reader.readAsDataURL(url);
	}
}
	

