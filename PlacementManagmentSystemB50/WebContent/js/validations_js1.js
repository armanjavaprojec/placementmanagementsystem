
function checkBatch()
{
	var spbatchid=document.getElementById("batch_sid");
	var batch=document.getElementById("batch_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Batch")
	{
		batch.style="border-color: red;";
		spbatchid.style="display: block;";
		spbatchid.innerHTML="select batch";
		return false;
	}
	else
	{
		batch.style="border-color: green;";
		spbatchid.style="display: none;"
		return true;
	}
}
function checkDomain()
{
	var spdomainid=document.getElementById("tech_sid");
	var domain=document.getElementById("tech_id");
	var sdomain=domain.options[domain.selectedIndex].text;
	if(sdomain=="Select Technology")
	{
		domain.style="border-color: red;";
		spdomainid.style="display: block;";
		spdomainid.innerHTML="select technology";
		return false;
	}
	else
	{
		domain.style="border-color: green;";
		spdomainid.style="display: none;"
		return true;
	}
}

function checkFirstName()
{
	 
	var spnameid=document.getElementById("fname_sid");
	var divnameid=document.getElementById("fname_div_id");
	
	var fname = document.getElementById("firstname");
	 
	var vfname = fname.value;
	vfname = vfname.trim();
	if (vfname == "") {
		fname.style = "border-color: red;";
		spnameid.innerHTML="enter correct name";
	} else {
		fname.style = "border-color: green;";
		spnameid.style="display: none;"
	}
}
function checkLastName()
{
	var spnameid=document.getElementById("lname_sid");
	var divnameid=document.getElementById("lname_div_id");
	
	var lname = document.getElementById("lastname");
	var vlname = lname.value;
	vlname = vlname.trim();
	if (vlname == "") {
		lname.style = "border-color: red;";
		spnameid.innerHTML="enter correct name";
	} else {
		lname.style = "border-color: green;";
		spnameid.style="display: none;"
	}
}
function validateEmail($email) 
{
	 var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	 return emailReg.test($email);
}

function validateContact($cont)
{
	var conReg = /^[0-9-+]+$/;
	return conReg.test($cont);
}

function checkMail()
{
	var spemailid=document.getElementById("email_sid");
	var umail=document.getElementById("email");
	var emailaddress=umail.value;
	if(emailaddress=="")
	{
		umail.style="border-color: red;";
		spemailid.innerHTML="enter email id";
	}
	else
	{
		if(!validateEmail(emailaddress)) 
		{ 	
			umail.style="border-color: red;";
			spemailid.innerHTML="enter valid email id";
		}
		else
		{
			umail.style="border-color: green;";
			$.get("othercontroller?req=mail&vmail="+emailaddress,function(data){
				if(data=="no")
				{
					umail.style="border-color: green;";
					spemailid.style="display: none;"
				}
				else
				{
					umail.style="border-color: red;";
				}
			});
			return true;
		}
	}
}

function checkContact()
{
	var ucon=document.getElementById("mobno");
	var spnumid=document.getElementById("mbl_sid");
	var contact=ucon.value;
	var len=contact.length;
	if(len==10)
	{
		if(!validateContact(contact)) 
		{ 	
			ucon.style="border-color: red;";
			spnumid.innerHTML="enter only digits no";
		}
		else
		{
			ucon.style="border-color: green;";
			spnumid.style="display: none;"
		}
	}
	else
	{
		ucon.style="border-color: red;";
		spnumid.innerHTML="enter correct contact no";
	}
}
function checkDOB()
{
	var sproundid=document.getElementById("dob_sid");
	var divroundid=document.getElementById("div_dob_id");
	
	var roundDate = document.getElementById("dob");
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
		sproundid.innerHTML="select your DOB";

		return false;
	} else {
		if (selDate < todDate) {
			roundDate.style = "border-color: green;";
			sproundid.style="display: none;"
			return true;
		} else {
			roundDate.style = "border-color: red;";
			sproundid.innerHTML="select your DOB";

			return false;
		}
	}
}

function checkAddrs()
{
	var sproundid=document.getElementById("addrs_sid");
	var divroundid=document.getElementById("div_addrs_id");
	
	var addr = document.getElementById("location");
	var vaddr = addr.value;
	vaddr = vaddr.trim();
	if (vaddr == "") {
		addr.style = "border-color: red;";
		sproundid.innerHTML="enter correct address";
		return false;
	} else {
		addr.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkZipcode()
{
	var sproundid=document.getElementById("zipcode_sid");
	var divroundid=document.getElementById("div_zipcode_id");
	
	var addr = document.getElementById("pincode");
	var vaddr = addr.value;
	var len=vaddr.length;
	if (len == 6) {
		addr.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
	else {
		addr.style = "border-color: red;";
		sproundid.innerHTML="enter 6 digits only";
		return false;
	}
}

function validateCountry()
{
	var country=document.getElementById("country");
	var scountry=country.options[country.selectedIndex].text;
	if(scountry=="SELECT")
	{
		country.style="border-color: red;";
	}
	else
	{
		country.style="border-color: green;";
		return true;
	}	
}

function validateState()
{
	var state=document.getElementById("state");
	var sstate=state.options[state.selectedIndex].text;
	if(sstate=="SELECT")
	{
		state.style="border-color: red;";
	}
	else
	{
		state.style="border-color: green;";
		return true;
	}	
}

function validateCity()
{
	var city=document.getElementById("city");
	var scity=city.options[city.selectedIndex].text;
	if(scity=="SELECT")
	{
		city.style="border-color: red;";
	}
	else
	{
		city.style="border-color: green;";
		return true;
	}	
}

function checkCity() {
	var sproundid=document.getElementById("city_sid");
	var divroundid=document.getElementById("div_city_id");
	
	var city = document.getElementById("city");
	var scity = city.options[city.selectedIndex].text;
	if (scity == "Select City") {
		city.style = "border-color: red;";
		sproundid.style="display: block;";
		sproundid.innerHTML="select city";
		return false;
	} else {
		city.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkState() {
	var sproundid=document.getElementById("state_sid");
	var divroundid=document.getElementById("div_state_id");
	
	var state = document.getElementById("state");
	var sstate = state.options[state.selectedIndex].text;
	if (sstate == "Select State") {
		state.style = "border-color: red;";
		sproundid.style="display: block;";
		sproundid.innerHTML="select state";
		return false;
	} else {
		state.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkCountry() {
	var sproundid=document.getElementById("country_sid");
	var divroundid=document.getElementById("div_country_id");
	
	var country = document.getElementById("country");
	var scountry = country.options[country.selectedIndex].text;
	if (scountry == "Select Country") {
		country.style = "border-color: red;";
		sproundid.style="display: block;";
		sproundid.innerHTML="select country";
		return false;
	} else {
		country.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}
function checkSPER(){
	var sproundid=document.getElementById("sper_sid");
	var divroundid=document.getElementById("div_sper_id");	
	var per = document.getElementById("spercentage_id");
	var vper = per.value;
	vper = vper.trim();
	if (vper == "") {
		per.style = "border-color: red;";
		sproundid.innerHTML="enter your percentage";
		return false;
	} else {
		per.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkHPER(){
	var sproundid=document.getElementById("hper_sid");
	var divroundid=document.getElementById("div_hper_id");
	
	var per = document.getElementById("hpercentage_id");
	var vper = per.value;
	vper = vper.trim();
	if (vper == "") {
		per.style = "border-color: red;";
		sproundid.innerHTML="enter your percentage";
		return false;
	} else {
		per.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkGPER(){
	var sproundid=document.getElementById("gper_sid");
	var divroundid=document.getElementById("div_gper_id");
	
	var per = document.getElementById("gpercentage_id");
	var vper = per.value;
	vper = vper.trim();
	if (vper == "") {
		per.style = "border-color: red;";
		sproundid.innerHTML="enter your percentage";
		return false;
	} else {
		per.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkPGPER(){
	var sproundid=document.getElementById("pgper_sid");
	var divroundid=document.getElementById("div_pgper_id");
	
	var per = document.getElementById("pgpercentage_id");
	var vper = per.value;
	vper = vper.trim();
	if (vper == "") {
		per.style = "border-color: red;";
		sproundid.innerHTML="enter your percentage";
		return false;
	} else {
		per.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkSyop()
{
	var spyopid=document.getElementById("syop_sid");
	var batch=document.getElementById("syop_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Yop")
	{
		batch.style="border-color: red;";
		spyopid.style="display: block;";
		spyopid.innerHTML="select yop";
		return false;
	}
	else
	{
		batch.style="border-color: green;";
		spyopid.style="display: none;"
		return true;
	}
}

function checkHyop()
{
	var spyopid=document.getElementById("hyop_sid");
	var batch=document.getElementById("hyop_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Yop")
	{
		batch.style="border-color: red;";
		spyopid.style="display: block;";
		spyopid.innerHTML="select yop";
		return false;
	}
	else
	{
		batch.style="border-color: green;";
		spyopid.style="display: none;"
		return true;
	}
}

function checkGyop()
{
	var spyopid=document.getElementById("gyop_sid");
	var batch=document.getElementById("gyop_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Yop")
	{
		batch.style="border-color: red;";
		spyopid.style="display: block;";
		spyopid.innerHTML="select yop";
		return false;
	}
	else
	{
		batch.style="border-color: green;";
		spyopid.style="display: none;"
		return true;
	}
}

function checkPGyop()
{
	var spyopid=document.getElementById("pgyop_sid");
	var batch=document.getElementById("pgyop_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Yop")
	{
		batch.style="border-color: red;";
		spyopid.style="display: block;";
		spyopid.innerHTML="select yop";
		return false;
	}
	else
	{
		batch.style="border-color: green;";
		spyopid.style="display: none;"
		return true;
	}
}

function checkGstream()
{
	var spstreamid=document.getElementById("gstream_sid");
	var batch=document.getElementById("gstream_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Stream")
	{
		batch.style="border-color: red;";
		spstreamid.style="display: block;";
		spstreamid.innerHTML="select stream";
		return false;
	}
	else
	{
		batch.style="border-color: green;";
		spstreamid.style="display: none;"
		return true;
	}
}

function checkPGstream()
{
	var spstreamid=document.getElementById("pgstream_sid");
	var batch=document.getElementById("pgstream_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Stream")
	{
		batch.style="border-color: red;";
		spstreamid.style="display: block;";
		spstreamid.innerHTML="select stream";
		return false;
	}
	else
	{
		batch.style="border-color: green;";
		spstreamid.style="display: none;"
		return true;
	}
}

function checkGspec()
{
	var spspecid=document.getElementById("gspec_sid");
	var batch=document.getElementById("gspecilization_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Specilization")
	{
		batch.style="border-color: red;";
		spspecid.style="display: block;";
		spspecid.innerHTML="select specilization";
		return false;
	}
	else
	{
		batch.style="border-color: green;";
		spspecid.style="display: none;"
		return true;
	}
}

function checkPGspec()
{
	var spspecid=document.getElementById("pgspec_sid");
	var batch=document.getElementById("pgspecilization_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Specilization")
	{
		batch.style="border-color: red;";
		spspecid.style="display: block;";
		spspecid.innerHTML="select specilization";
		return false;
	}
	else
	{
		batch.style="border-color: green;";
		spspecid.style="display: none;"
		return true;
	}
}
