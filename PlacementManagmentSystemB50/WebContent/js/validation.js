
function validateEmail($email) 
{
	 var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	 return emailReg.test($email);
}

function validateContact($cont)
{
	var conReg = /^\(?([7-9]{2})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})$/;
	return conReg.test($cont);
}
function validatePassword($pssw)
{
	
	var pssword=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,15}$/;
    return pssword.test($pssw);
}
function validateDate($dd){
    var day = $("#day").val();
    var month = $("#month").val();
    var year = $("#year").val();
    var age = 18;
    var mydate = new Date();
    mydate.setFullYear(year, month-1, day);

    var currdate = new Date();
    currdate.setFullYear(currdate.getFullYear() - age);
    if ((currdate - mydate) < 0){
        //alert("Sorry, only persons over the age of " + age + " may enter this site");
       var tt=currdate-mydate;
        return tt.test($dd);
    }
    return true;
}