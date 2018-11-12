/**
 * 
 */

function temp() {
	alert();
}

/*
 * function checkRoundName() { var roundName =
 * document.getElementById("id_round_name"); var vroundName = roundName.value;
 * vroundName = vroundName.trim(); if (vroundName == "") { roundName.style =
 * "border-color: red;"; roundName.style.width = "300px"; roundName.value = "";
 *  } else { roundName.style = "border-color: green;"; roundName.style.width =
 * "300px"; return true; } }
 */

function checkRoundNo() {
	var sproundid=document.getElementById("sp_round_no");
	var divroundid=document.getElementById("div_round_no");
	
	var roundNo = document.getElementById("id_round_no");
	var vroundNo = roundNo.value;
	vroundNo = vroundNo.trim();
	if (vroundNo == "") {
		roundNo.style = "border-color: red;";
		divroundid.className='form-group has-error has-feedback';
		sproundid.className='glyphicon glyphicon-remove form-control-feedback';
		roundNo.style.width = "300px";
		roundNo.value = "";
	} else {
		if (vroundNo < 1) {
			roundNo.style = "border-color: red;";
			divroundid.className='form-group has-error has-feedback';
			sproundid.className='glyphicon glyphicon-remove form-control-feedback';
			roundNo.style.width = "300px";
		} else {
			roundNo.style = "border-color: green;";
			roundNo.style.width = "300px";
			divroundid.className='form-group has-success has-feedback';
			sproundid.className='glyphicon glyphicon-ok form-control-feedback';
			return true;
		}
	}
}

function checkRoundDescription() {
	var sproundid=document.getElementById("sp_round_description");
	var divroundid=document.getElementById("div_round_description");
	
	var roundDesc = document.getElementById("id_round_description");
	var vroundDesc = roundDesc.value;
	vroundDesc = vroundDesc.trim();
	if (vroundDesc == "") {
		roundDesc.style = "border-color: red;";
		divroundid.className='form-group has-error has-feedback';
		sproundid.className='glyphicon glyphicon-remove form-control-feedback';
		
		roundDesc.style.width = "300px";
		roundDesc.style.resize = "none";
		roundDesc.value = "";
	} else {
		roundDesc.style = "border-color: green;";
		divroundid.className='form-group has-success has-feedback';
		sproundid.className='glyphicon glyphicon-ok form-control-feedback';
		
		roundDesc.style.width = "300px";
		roundDesc.style.resize = "none";
		return true;
	}
}

function checkAddress() {
	var sproundid=document.getElementById("sp_round_address");
	var divroundid=document.getElementById("div_round_address");
	
	var addr = document.getElementById("id_round_address");
	var vaddr = addr.value;
	vaddr = vaddr.trim();
	if (vaddr == "") {
		addr.style = "border-color: red;";
		divroundid.className='form-group has-error has-feedback';
		sproundid.className='glyphicon glyphicon-remove form-control-feedback';
		addr.style.width = "300px";
		addr.value = "";
	} else {
		addr.style = "border-color: green;";
		divroundid.className='form-group has-success has-feedback';
		sproundid.className='glyphicon glyphicon-ok form-control-feedback';
		addr.style.width = "300px";
		return true;
	}
}

function checkCity() {
	var sproundid=document.getElementById("sp_round_city");
	var divroundid=document.getElementById("div_round_city");
	
	var city = document.getElementById("id_city");
	var scity = city.options[city.selectedIndex].text;
	if (scity == "SELECT") {
		city.style = "border-color: red;";
		divroundid.className='form-group has-error has-feedback';
		sproundid.className='glyphicon glyphicon-remove form-control-feedback';
		city.style.width = "300px";
	} else {
		city.style = "border-color: green;";
		divroundid.className='form-group has-success has-feedback';
		sproundid.className='glyphicon glyphicon-ok form-control-feedback';
		city.style.width = "300px";
		return true;
	}
}

function checkState() {
	var sproundid=document.getElementById("sp_round_state");
	var divroundid=document.getElementById("div_round_state");
	
	var state = document.getElementById("id_state");
	var sstate = state.options[state.selectedIndex].text;
	if (sstate == "SELECT") {
		state.style = "border-color: red;";
		divroundid.className='form-group has-error has-feedback';
		sproundid.className='glyphicon glyphicon-remove form-control-feedback';
		state.style.width = "300px";
	} else {
		state.style = "border-color: green;";
		state.style.width = "300px";
		divroundid.className='form-group has-success has-feedback';
		sproundid.className='glyphicon glyphicon-ok form-control-feedback';
		return true;
	}
}

function checkCountry() {
	var sproundid=document.getElementById("sp_round_country");
	var divroundid=document.getElementById("div_round_country");
	
	var country = document.getElementById("id_country");
	var scountry = country.options[country.selectedIndex].text;
	if (scountry == "SELECT") {
		country.style = "border-color: red;";
		divroundid.className='form-group has-error has-feedback';
		sproundid.className='glyphicon glyphicon-remove form-control-feedback';
		country.style.width = "300px";
	} else {
		country.style = "border-color: green;";
		divroundid.className='form-group has-success has-feedback';
		sproundid.className='glyphicon glyphicon-ok form-control-feedback';
		country.style.width = "300px";
		return true;
	}
}

function checkRoundDate() {
	var sproundid=document.getElementById("sp_round_date");
	var divroundid=document.getElementById("div_round_date");
	
	var roundDate = document.getElementById("id_round_date");
	var vroundDate = roundDate.value;
	vroundDate = vroundDate.trim();

	var today = new Date();
	var curr_date = today.getDate();
	var curr_month = today.getMonth() + 1;
	var curr_year = today.getFullYear();
	var today_date = curr_year + "-" + curr_month + "-" + curr_date;

	var selDate = new Date(vroundDate);
	var todDate = new Date(today_date);

	if (vroundDate == "") {
		roundDate.style = "border-color: red;";
		divroundid.className='form-group has-error has-feedback';
		sproundid.className='glyphicon glyphicon-remove form-control-feedback';
		roundDate.style.width = "300px";
		roundDate.value = "";
	} else {
		if (selDate >= todDate) {
			roundDate.style = "border-color: green;";
			divroundid.className='form-group has-success has-feedback';
			sproundid.className='glyphicon glyphicon-ok form-control-feedback';
			roundDate.style.width = "300px";
			return true;
		} else {
			roundDate.style = "border-color: red;";
			divroundid.className='form-group has-error has-feedback';
			sproundid.className='glyphicon glyphicon-remove form-control-feedback';
			roundDate.style.width = "300px";
		}
	}
}

/*
 * function checkReportingTime() { var reportTime =
 * document.getElementById("id_round_time"); var vreportTime = reportTime.value;
 * vreportTime = vreportTime.trim(); if (vreportTime == "" || vreportTime ==
 * "00:00") { reportTime.style = "border-color: red;"; reportTime.style.width =
 * "300px"; reportTime.value = ""; } else { reportTime.style = "border-color:
 * green;"; reportTime.style.width = "300px"; return true; } }
 */

function validateAddRoundAll() {
	//alert();
	var resRoundNo = checkRoundNo();
	// var resRoundName = checkRoundName();
	var resDescription = checkRoundDescription();
	var resAddress = checkAddress();
	var resCity = checkCity();
	var resState = checkState();
	var resCountry = checkCountry();
	var resRoundDate = checkRoundDate();
	// var resReportingTime=checkReportingTime();

	if (resRoundNo && resDescription && resAddress && resCity && resState
			&& resCountry) {
		return true;
	} else {
		return false;
	}
}