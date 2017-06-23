/**
 * 
 */

var url = 'index.jsp?inc=./board/';

function init(){
	var getId = function(val){return document.getElementById(val);} 
	var frmB = document.frm_board;
	var btninput = getId('btninput');
	var btninputR = getId('btninputR');
	var btnlist = getId('btnlist');
	
	
	
	
	
	
	if(btninput != null){
		btninput.onclick = function(){
			frmB.action = url + 'input.jsp';
			frmB.submit();
		}
	}
	
	if(btninputR != null){
		btninputR.onclick = function(){
			frmB.action = url + 'input_result.jsp';
			frmB.submit();
			
		}
	}
	
	if(btnlist != null){
		btnlist.onclick = function(){
			frmB.action = url + 'list.jsp';
			frmB.submit();
			
		}
	}
}
function Go(value){
	
	var ff = document.frm_board;
	 
	ff.listVal.value = value;
	
	ff.action = url+'view.jsp'
	
	ff.submit();
}


