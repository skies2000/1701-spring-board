/**
 * 
 */

var url = 'index.jsp?inc=./board/';

function init(){
	var getId = function(val){return document.getElementById(val);} 
	var frmB = document.frm_board;
	var btninput = getId('btninput');
	var btninputR = getId('btninputR');
	var btnlist = getId('btnList');
	
	
	 
	
	
	if(btninput != null){
		btninput.onclick = function(){
			frmB.action = 'input.do';
			frmB.submit();
		}
	} 
	
	if(btninputR != null){
		btninputR.onclick = function(){
			frmB.action = 'inputR.do'; 
			frmB.submit();
			
		}
	} 
	
	if(btnlist != null){
		btnlist.onclick = function(){
			frmB.action = 'list.do';
			frmB.submit();
			
		}
	}
}
function Go(value){
	
	var ff = document.frm_board;
	 
	ff.listVal.value = value;
	
	ff.action = 'view.jsp'
	
	ff.submit();
}


