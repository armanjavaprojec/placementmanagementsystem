function returnSSCstream() {
	
	var sscStream = document.getElementById("id_edit_ssc_stream_select");
	var ssscStream = sscStream.options[sscStream.selectedIndex].text;
	if (ssscStream == "SELECT") {
		sscStream.style = "border-color: red;";
	} else {
		sscStream.style = "border-color: green;";
		return true;
	}
}

function returnSSCspecialization()
{
	var sscSpecialization = document.getElementById("id_edit_ssc_specialization_select");
	var ssscSpecialization = sscSpecialization.options[sscSpecialization.selectedIndex].text;
	if (ssscSpecialization == "SELECT") {
		sscSpecialization.style = "border-color: red;";
	} else {
		sscSpecialization.style = "border-color: green;";
		return true;
	}
}

function returnInterstream()
{
	var interStream = document.getElementById("id_edit_inter_stream_select");
	var sinterStream = interStream.options[interStream.selectedIndex].text;
	if (sinterStream == "SELECT") {
		interStream.style = "border-color: red;";
	} else {
		interStream.style = "border-color: green;";
		return true;
	}
}

function returnInterspecialization()
{
	var interSpecialization = document.getElementById("id_edit_inter_specialization_select");
	var sinterSpecialization = interSpecialization.options[interSpecialization.selectedIndex].text;
	if (sinterSpecialization == "SELECT") {
		interSpecialization.style = "border-color: red;";
	} else {
		interSpecialization.style = "border-color: green;";
		return true;
	}
}

function returnGradstream()
{
	var gradStream = document.getElementById("id_edit_grad_stream_select");
	var sgradStream = gradStream.options[gradStream.selectedIndex].text;
	if (sgradStream == "SELECT") {
		gradStream.style = "border-color: red;";
	} else {
		gradStream.style = "border-color: green;";
		return true;
	}
}

function returnGradspecialization()
{
	var gradSpecialization = document.getElementById("id_edit_grad_specialization_select");
	var sgradSpecialization = gradSpecialization.options[gradSpecialization.selectedIndex].text;
	if (sgradSpecialization == "SELECT") {
		gradSpecialization.style = "border-color: red;";
	} else {
		gradSpecialization.style = "border-color: green;";
		return true;
	}
}

function returnPGstream()
{
	var pgStream = document.getElementById("id_edit_pg_stream_select");
	var spgStream = pgStream.options[pgStream.selectedIndex].text;
	if (spgStream == "SELECT") {
		pgStream.style = "border-color: red;";
	} else {
		pgStream.style = "border-color: green;";
		return true;
	}
}

function returnPGspecialization()
{
	var pgSpecialization = document.getElementById("id_edit_pg_specialization_select");
	var spgSpecialization = pgSpecialization.options[pgSpecialization.selectedIndex].text;
	if (spgSpecialization == "SELECT") {
		pgSpecialization.style = "border-color: red;";
	} else {
		pgSpecialization.style = "border-color: green;";
		return true;
	}
}

function returnSSCpercantage()
{
	var sscPercent = document.getElementById("id_edit_ssc_percentage");
	var vsscPercent = sscPercent.value;
	vsscPercent = vsscPercent.trim();
	if (vsscPercent == "") {
		sscPercent.style = "border-color: red;";
	} else {
		if (vsscPercent < 35 || vsscPercent > 100) {
			sscPercent.style = "border-color: red;";
		} else {
			sscPercent.style = "border-color: green;";
			return true;
		}
	}
}

function returnInterpercantage()
{
	var interPercent = document.getElementById("id_edit_inter_percentage");
	var vinterPercent = interPercent.value;
	vinterPercent = vinterPercent.trim();
	if (vinterPercent == "") {
		interPercent.style = "border-color: red;";
	} else {
		if (vinterPercent < 35 || vinterPercent > 100) {
			interPercent.style = "border-color: red;";
		} else {
			interPercent.style = "border-color: green;";
			return true;
		}
	}
}

function returnGradpercantage()
{
	var gradPercent = document.getElementById("id_edit_grad_percentage");
	var vgradPercent = gradPercent.value;
	vgradPercent = vgradPercent.trim();
	if (vgradPercent == "") {
		gradPercent.style = "border-color: red;";
	} else {
		if (vgradPercent < 35 || vgradPercent > 100) {
			gradPercent.style = "border-color: red;";
		} else {
			gradPercent.style = "border-color: green;";
			return true;
		}
	}
}

function returnPGpercantage()
{
	var pgPercent = document.getElementById("id_edit_pg_percentage");
	var vpgPercent = pgPercent.value;
	vpgPercent = vpgPercent.trim();
	if (vpgPercent == "") {
		pgPercent.style = "border-color: red;";
	} else {
		
		if(vpgPercent==0)
			{
			pgPercent.style = "border-color: green;";
			return true;
			}
		
		if (vpgPercent < 35 || vpgPercent > 100) {
			pgPercent.style = "border-color: red;";
		} else {
			pgPercent.style = "border-color: green;";
			return true;
		}
	}
}

function returnSSCyop()
{
	var sscPass = document.getElementById("id_edit_ssc_yop");
	var vsscPass = sscPass.value;
	vsscPass = vsscPass.trim();
	if (vsscPass == "") {
		sscPass.style = "border-color: red;";
	} else {
		if (vsscPass < 2001 || vsscPass > 2025) {
			sscPass.style = "border-color: red;";
		} else {
			sscPass.style = "border-color: green;";
			return true;
		}
	}
}

function returnInteryop()
{
	var interPass = document.getElementById("id_edit_inter_yop");
	var vinterPass = interPass.value;
	vinterPass = vinterPass.trim();
	if (vinterPass == "") {
		interPass.style = "border-color: red;";
	} else {
		if (vinterPass < 2001 || vinterPass > 2025) {
			interPass.style = "border-color: red;";
		} else {
			interPass.style = "border-color: green;";
			return true;
		}
	}
}

function returnGradyop()
{
	var gradPass = document.getElementById("id_edit_grad_yop");
	var vgradPass = gradPass.value;
	vgradPass = vgradPass.trim();
	if (vgradPass == "") {
		gradPass.style = "border-color: red;";
	} else {
		if (vgradPass < 2001 || vgradPass > 2025) {
			gradPass.style = "border-color: red;";
		} else {
			gradPass.style = "border-color: green;";
			return true;
		}
	}
}

function returnPGyop()
{
	var pgPass = document.getElementById("id_edit_pg_yop");
	var vpgPass = pgPass.value;
	vpgPass = vpgPass.trim();
	if (vpgPass == "") {
		pgPass.style = "border-color: red;";
	} else {
		
		if(vpgPass==0000)
			{
			pgPass.style = "border-color: green;";
			return true;
			}
		
		if (vpgPass < 2001 || vpgPass > 2025) {
			pgPass.style = "border-color: red;";
		} else {
			pgPass.style = "border-color: green;";
			return true;
		}
	}
}