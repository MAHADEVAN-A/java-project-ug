<html>
<head>
<title>THE MADURA COLLEGE</title>
<style type="text/css">
#oval {
      width: 400px;
	  height: 100px;
	  background: rgb(155,21,2);
	  color: rgb(252,220,177);
	  display: block;
	  font: normal 13px Tahoma;
	  line_height: 16px;
	  padding_left: 11px;
	  text-decoration: none;
	  border-radius: 60px;
	  }
.pos1 { position: absolute; top: 150px; left:100px;}
.pos2 { position: absolute; top: 150px; left: 600px;}
.pos3 { position: absolute; top: 350px; left: 100px;}
.pos4 { position: absolute; top: 350px; left: 600px;}
.pos5 { position: absolute; top: 500px; left: 50px;}

.pos { position: absolute; top: 90px; left: 80px;} 
.po { position: absolute; top: 90px; left: 620px;}
.po1 { position: absolute; top: 40px; left: 110px;} 
.po2 { position: absolute; top: 40px; left: 660px;}
.bd { width: 100%;min-width: 700px; min-height: 500px;}
</style>
<script language="JavaScript">
function chec()
{
	var op1=document.getElementById("r1");
	var op2=document.getElementById("r2");
	if(!(op1.checked||op2.checked))
	{
		alert("Choose any option");
	}
if(op1.checked)
{
location.href='add1.html'
}
else if(op2.checked)
{
location.href='add2.html'
}
}
function chec1()
{
location.href='selected1.html'
}
function chec2()
{
location.href='course.html'
}
</script>
</head>
<body style="background: rgb(252,220,177)" class="bd">
<center><h1 style="color: rgb(155,21,2); font-family: cursive; font-size: xx-large" >THE MADURA COLLEGE</h1></center> 
<form >
<input type="radio" name="g1" id="r1" value="s1" class="pos"><h3 style="color: rgb(155,21,2); font-family: cursive; font-size: xx-large" class="po1">IAM A 12TH STUDENT</h3>
<input type="radio" name="g1" id="r2" value="s2" class="po"><h3 style="color: rgb(155,21,2); font-family: cursive; font-size: xx-large" class="po2">IAM A UG STUDENT</h3>
<input type="button" id="oval" class="pos1" value="APPLY FORM" onclick="chec()">
<input type="button" id="oval" class="pos2" value="COURSE DETAILS" onclick="chec2()">
<input type="button" id="oval" class="pos3" value="GALLERY">
<input type="button" id="oval" class="pos4" value="VIEW SELECTED LIST" onclick="chec1()">
</form>
<?php
$text= file_get_contents("Message.txt");
$fix = str_replace("\n","<br>",$text);
echo "<h3 style=\"color: rgb(155,21,2); font-family: cursive; font-size: xx-large\">
<fieldset class=\"pos5\" style=\"color: rgb(155,21,2)\">
<legend>MessageBox</legend>
<div>".$fix."</div>
</fieldset>
</h3>";
?>
</body>
</html>