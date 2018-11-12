function validateEmail($email) 
{
	 var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	 return emailReg.test($email);
}
/*
function validateContact($cont)
{
	var conReg = /^[0-9-+]+$/;
	return conReg.test($cont);
}
*/
function validateBatch()
{
	document.getElementById("id_div_err").style="display:none;";
	var spbatchid=document.getElementById("batch_sid");
	var batch=document.getElementById("batch_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Batch")
	{
	//	batch.style="border-color: block;";
	//	spbatchid.style="display: block;";
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

function validateTech()
{
	document.getElementById("id_div_err").style="display:none;";
	var spdomainid=document.getElementById("tech_sid");
	var domain=document.getElementById("tech_id");
	var sdomain=domain.options[domain.selectedIndex].text;
	if(sdomain=="Select Technology")
	{
	//	domain.style="border-color: red;";
	//	spdomainid.style="display: block;";
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
	document.getElementById("id_div_err").style="display:none;";
	var spnameid=document.getElementById("fname_sid");
	var divnameid=document.getElementById("fname_div_id");
	
	var fname = document.getElementById("firstName");
	var vfname = fname.value;
	vfname = vfname.trim();
	if (vfname == "") {
	//	fname.style = "border-color: red;";
		spnameid.innerHTML="enter first name";
		return false;
	}
	else if(!vfname.match(/^[a-zA-Z]+$/)){
		spnameid.innerHTML="enter alphabets only";
		return false;
	}
	else if(vfname.length<3){
		spnameid.innerHTML="name cannot contain lessthan 3 characters";
		return false;
	}
	else if(vfname.length>21){
		spnameid.innerHTML="name cannot contain morethan 21 characters";
		return false;
	}
	else {
		fname.style = "border-color: green;";
		spnameid.style="display: none;"
		return true;
	}
}

   function checkLastName()
{
	document.getElementById("id_div_err").style="display:none;";
	var spnameid=document.getElementById("lname_sid");
	var divnameid=document.getElementById("lname_div_id");
	
	var lname = document.getElementById("lastName");
	var vlname = lname.value;
	vlname = vlname.trim();
	if (vlname == "") {
	//	lname.style = "border-color: red;";
		spnameid.innerHTML="enter last name";
		return false;
	}
	else if(!vlname.match(/^[a-zA-Z]+$/)){
		spnameid.innerHTML="enter alphabets only";
		return false;
	}
	else if(vlname.length<3){
		spnameid.innerHTML="name cannot contain lessthan 3 characters";
		return false;
	}
	else if(vlname.length>21){
		spnameid.innerHTML="name cannot contain morethan 21 characters";
		return false;
	}
	else {
		lname.style = "border-color: green;";
		spnameid.style="display: none;"
		return true;
	}
}
/*
function checkContact()
{
	document.getElementById("id_div_err").style="display:none;";
	var ucon=document.getElementById("contact");
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
			return true;
		}
	}
	else
	{
		ucon.style="border-color: red;";
		spnumid.innerHTML="enter correct contact no";
	}
}
*/
function checkContact()
{
	document.getElementById("id_div_err").style="display:none;";
	var ucon=document.getElementById("contact");
	var contact=ucon.value;
	if(contact==""){
		document.getElementById("mbl_sid").innerHTML="please enter mobile number";
		return false;
	}
	else if(isNaN(contact)){
		document.getElementById("mbl_sid").innerHTML="please enter only numbers";
		return false;
	}
	else if(contact.length<10){
		document.getElementById("mbl_sid").innerHTML="mobile number must be 10 digits";
		return false;
	}
	else if(contact.l0ength>10){
		document.getElementById("mbl_sid").innerHTML="mobile number must be 10 digits";
		return false;
	}
	else if((contact.charAt(0)!=9) && (contact.charAt(0)!=8) && (contact.charAt(0)!=7) && (contact.charAt(0)!=6)){
		document.getElementById("mbl_sid").innerHTML="mobile number start with 9/8/7/6";
		return false;
	}
	else{
		ucon.style = "border-color: green;";
		document.getElementById("mbl_sid").style="display: none;";
return true;
	}
}

function checkMail()
{
	document.getElementById("id_div_err").style="display:none;";
	var spemailid=document.getElementById("email_sid");
	var umail=document.getElementById("email");
	var emailaddress=umail.value;
	if(emailaddress=="")
	{
	//	umail.style="border-color: red;";
		spemailid.innerHTML="enter email id";
	return false;}
	else
	{
		
		if(!validateEmail(emailaddress)) 
		{ 
		//	spemailid.style="display: block;"
		//	umail.style="border-color: red;";
			spemailid.innerHTML="enter valid email id";
		return false;}
		else
		{
			umail.style="border-color: green;";
			spemailid.style="display: none;"
			return true;
		}
		return true;
	}
}

function checkDOB()
{
	document.getElementById("id_div_err").style="display:none;";
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
	//	roundDate.style = "border-color: red;";
		sproundid.innerHTML="select your DOB";

		return false;
	} else {
		if (selDate < todDate) {
			roundDate.style = "border-color: green;";
			sproundid.style="display: none;";
			return true;
		} else {
		//	roundDate.style = "border-color: red;";
			sproundid.innerHTML="select your DOB";

			return false;
		}
	}
}

function checkAddrs()
{
	document.getElementById("id_div_err").style="display:none;";
	var sproundid=document.getElementById("addrs_sid");
	var divroundid=document.getElementById("div_addrs_id");
	
	var addr = document.getElementById("addrsid");
	var vaddr = addr.value;
	vaddr = vaddr.trim();
	if (vaddr == "") {
	//	addr.style = "border-color: red;";
		sproundid.innerHTML="enter correct address";
		return false;
	}
	else if(!vaddr.match(/^[a-zA-Z]+$/)){
		sproundid.innerHTML="enter alphabets only";
		return false;
	}
	else if(vaddr.length<3){
		sproundid.innerHTML="address cannot contain lessthan 3 characters";
		return false;
	}
	else if(vaddr.length>21){
		sproundid.innerHTML="address cannot contain morethan 21 characters";
		return false;
	}
	else {
		addr.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkZipcode()
{
	document.getElementById("id_div_err").style="display:none;";
	var sproundid=document.getElementById("zipcode_sid");
	var divroundid=document.getElementById("div_zipcode_id");
	
	var addr = document.getElementById("zipcode");
	var vaddr = addr.value;
	var len=vaddr.length;
	if(vaddr==""){
		document.getElementById("zipcode_sid").innerHTML="please enter pincode";
		return false;
	}
	else if(isNaN(vaddr)){
		document.getElementById("zipcode_sid").innerHTML="alphabets not allowed";
		return false;
	}

	else if (len != 6) {
		document.getElementById("zipcode_sid").innerHTML="pincode contain 6 digits only";
		return false;
	}
	else{
		addr.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
	
}

function checkCountry() {
	document.getElementById("id_div_err").style="display:none;";
	var sproundid=document.getElementById("country_sid");
	var divroundid=document.getElementById("div_country_id");
	
	var country = document.getElementById("country_id");
	var scountry = country.options[country.selectedIndex].text;
	if (scountry == "Select Country") {
	//	country.style = "border-color: red;";
	//	sproundid.style="display: block;";
		sproundid.innerHTML="select country";
		return false;
	} else {
		country.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkState() {
	document.getElementById("id_div_err").style="display:none;";
	var sproundid=document.getElementById("state_sid");
	var divroundid=document.getElementById("div_state_id");
	
	var state = document.getElementById("state_id");
	var sstate = state.options[state.selectedIndex].text;
	if (sstate == "Select State") {
	//	state.style = "border-color: red;";
	//	sproundid.style="display: block;";
		sproundid.innerHTML="select state";
		return false;
	} else {
		state.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkCity() {
	document.getElementById("id_div_err").style="display:none;";
	var sproundid=document.getElementById("city_sid");
	var divroundid=document.getElementById("div_city_id");
	
	var city = document.getElementById("city_id");
	var scity = city.options[city.selectedIndex].text;
	if (scity == "Select City") {
	//	city.style = "border-color: red;";
	//	sproundid.style="display: block;";
		sproundid.innerHTML="select city";
		return false;
	} else {
		city.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkSyop()
{
	document.getElementById("id_div_err").style="display:none;";
	var spyopid=document.getElementById("syop_sid");
	var batch=document.getElementById("syop_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Passed-Out")
	{
	//	batch.style="border-color: red;";
	//	spyopid.style="display: block;";
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

function checkSPER(){
	document.getElementById("id_div_err").style="display:none;";
	var sproundid=document.getElementById("sper_sid");
	var divroundid=document.getElementById("div_sper_id");
	
	var per = document.getElementById("spercentage_id");
	var vper = per.value;
	vper = vper.trim();

	if (vper == "") {
	//	per.style = "border-color: red;";
		sproundid.innerHTML="enter your percentage";
		return false;
	}
	
	if(!vper.match(/^[0-9.]+$/)){
		sproundid.innerHTML="alphabets not allowed";
		return false;
	}
	else if (vper < 35){
		//	per.style = "border-color: red;";
			sproundid.innerHTML="percentage should be above 35";
			return false;
	}
	else if (vper > 100){
		//	per.style = "border-color: red;";
			sproundid.innerHTML="percentage should be below 100";
			return false;
	}
	else {
		per.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkHyop()
{
	document.getElementById("id_div_err").style="display:none;";
	var spyopid=document.getElementById("hyop_sid");
	var batch=document.getElementById("hyop_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Passed-Out")
	{
	//	batch.style="border-color: red;";
	//	spyopid.style="display: block;";
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

function checkHPER(){
	document.getElementById("id_div_err").style="display:none;";
	var sproundid=document.getElementById("hper_sid");
	var divroundid=document.getElementById("div_hper_id");
	
	var per = document.getElementById("hpercentage_id");
	var vper = per.value;
	vper = vper.trim();
	if (vper == "") {
	//	per.style = "border-color: red;";
		sproundid.innerHTML="enter your percentage";
		return false;
	}
	if(!vper.match(/^[0-9.]+$/)){
		sproundid.innerHTML="alphabets not allowed";
		return false;
	}
	else if (vper < 35){
		//	per.style = "border-color: red;";
			sproundid.innerHTML="percentage should be above 35";
			return false;
	}
	else if (vper > 100){
		//	per.style = "border-color: red;";
			sproundid.innerHTML="percentage should be below 100";
			return false;
	}
	else {
		per.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkGstream()
{
	document.getElementById("id_div_err").style="display:none;";
	var spstreamid=document.getElementById("gstream_sid");
	var batch=document.getElementById("gstream_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Stream")
	{
	//	batch.style="border-color: red;";
	//	spstreamid.style="display: block;";
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
	document.getElementById("id_div_err").style="display:none;";
	var spspecid=document.getElementById("gspec_sid");
	var batch=document.getElementById("gspecilization_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Specilization")
	{
	//	batch.style="border-color: red;";
	//	spspecid.style="display: block;";
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

function checkGyop()
{
	document.getElementById("id_div_err").style="display:none;";
	var spyopid=document.getElementById("gyop_sid");
	var batch=document.getElementById("gyop_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Passed-Out")
	{
	//	batch.style="border-color: red;";
	//	spyopid.style="display: block;";
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

function checkGPER(){
	document.getElementById("id_div_err").style="display:none;";
	var sproundid=document.getElementById("gper_sid");
	var divroundid=document.getElementById("div_gper_id");
	
	var per = document.getElementById("gpercentage_id");
	var vper = per.value;
	vper = vper.trim();
	if (vper == "") {
	//	per.style = "border-color: red;";
		sproundid.innerHTML="enter your percentage";
		return false;
	} 
	if(!vper.match(/^[0-9.]+$/)){
		alert("hi..");
		sproundid.innerHTML="alphabets not allowed";
		return false;
	}
	else if (vper < 35){
		//	per.style = "border-color: red;";
			sproundid.innerHTML="percentage should be above 35";
			return false;
	}
	else if (vper > 100){
		//	per.style = "border-color: red;";
			sproundid.innerHTML="percentage should be below 100";
			return false;
	}
	else {
		per.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}

function checkPGstream()
{
	document.getElementById("id_div_err").style="display:none;";
	var spstreamid=document.getElementById("pgstream_sid");
	var batch=document.getElementById("pgstream_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Stream")
	{
	//	batch.style="border-color: red;";
	//	spstreamid.style="display: block;";
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

function checkPGspec()
{
	document.getElementById("id_div_err").style="display:none;";
	var spspecid=document.getElementById("pgspec_sid");
	var batch=document.getElementById("pgspecilization_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Select Specilization")
	{
	//	batch.style="border-color: red;";
	//	spspecid.style="display: block;";
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

function checkPGyop()
{
	document.getElementById("id_div_err").style="display:none;";
	var spyopid=document.getElementById("pgyop_sid");
	var batch=document.getElementById("pgyop_id");
	var sbatch=batch.options[batch.selectedIndex].text;
	if(sbatch=="Passed-Out")
	{
	//	batch.style="border-color: red;";
	//	spyopid.style="display: block;";
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

function checkPGPER()
{
	document.getElementById("id_div_err").style="display:none;";
	var sproundid=document.getElementById("pgper_sid");
	var divroundid=document.getElementById("div_pgper_id");
	
	var per = document.getElementById("pgpercentage_id");
	var vper = per.value;
	vper = vper.trim();
	if (vper == "") {
	//	per.style = "border-color: red;";
		sproundid.innerHTML="enter your percentage";
		return false;
	}
	if(!vper.match(/^[0-9.]+$/)){
		alert("hi..");
		sproundid.innerHTML="alphabets not allowed";
		return false;
	}
	else if (vper < 35){
		//	per.style = "border-color: red;";
			sproundid.innerHTML="percentage should be above 35";
			return false;
	}
	else if (vper > 100){
		//	per.style = "border-color: red;";
			sproundid.innerHTML="percentage should be below 100";
			return false;
	}
	else {
		per.style = "border-color: green;";
		sproundid.style="display: none;";
		return true;
	}
}