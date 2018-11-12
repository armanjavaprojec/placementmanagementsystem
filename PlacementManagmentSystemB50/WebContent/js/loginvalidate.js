$(document).ready(function() {
	$("#b").click(function(){
		var username = $("#inputEmail").val();
		var password = $("#inputPassword").val();
		/*var nameReg=/[^a-z|^A-Z|^_|^.]{2,4}$/;*/
		var emailReg = /^[\w\.]+\@[a-zA-Z0-9]+\.[a-zA-z]{2,4}$/;
		/*var passReg=/^[a-zA-Z]\w{2,14}$/;*/
var passReg=/^[A-Za-z0-9!@#$%^&*]{6,15}$/;
		
		if(username==""){
			$("#s1").text("Please Enter Username!");
			$("#inputEmail").focus();
			return false;
		}
		else if (!emailReg.test(username)) {
			$("#s1").text("Invalid Username!");
			$("#inputEmail").focus();
			return false;
			}
		else if(username!==""||emailReg.test(username)) {
			
			$("#s1").hide();
		}
		
		
		if(password==""){
			$("#s2").text("Please Enter Password!");
			$("#inputPassword").focus();
			return false;
		}
		else if (!passReg.test(password)) {
			$("#s2").text("Password must consist of altleat 6 Characters!");
			$("#inputPassword").focus();
			return false;
			}
		
		else if(password!==""){
			$("#s2").hide();
		}
		
	});
});