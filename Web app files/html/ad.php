<html>
<head>
<title>ADMISSION FORM</title>
<style type="text/css">
.bd { width: 100%;min-width: 700px; min-height: 800px;}
#oval {
      width: 100px;
	  height: 50px;
	  background: rgb(155,21,2);
	  color: rgb(252,220,177);
	  display: block;
	  font: normal 13px Tahoma;
	  line_height: 16px;
	  padding_left: 11px;
	  text-decoration: none;
	  border-radius: 60px;
	  
	  }
	  .b1{position: absolute; top: 650px; left:390px;}
	  .b2{position: absolute; top: 650px; left:600px;}
.pos1 { position: absolute; top: 100px; left:20px; border:none;}
.pos2 { position: absolute; top: 100px; left: 370px;border:none;}
.pos3 { position: absolute; top: 100px; left: 700px;border:none;}
.pos4 { position: absolute; top: 500px; left: 50px;border:none;}
.pos5 { position: absolute; top: 500px; left: 500px;border:none;} 
</style>
</head>
<body style="background: rgb(252,220,177)" class="bd">
<form>
<h1 style="color: rgb(155,21,2)">ADMISSION FORM</h1>
<h3 style="color: rgb(155,21,2)">
<fieldset class="pos1">
<legend>StudentDetails1</legend>
<pre>
Name:               <input type="text" name="Name"><br>
Date of birth:      <input type="text" name="Dob"><br>
Gender:             <select name="gen"><option value="Male">MALE</option><option value="Female">FEMALE</option><select><br>
Father Name:        <input type="text" name="Fname"><br>
Father Occupation:  <input type="text" name="Foc"><br>
Mother Name:        <input type="text" name="Mname"><br>
Mother Occupation:  <input type="text" name="Moc"><br>
Address:            <textarea></textarea>
</pre>
</fieldset>
<fieldset class="pos2">
<legend>StudentDetails2</legend>
<pre>
Nationality:     <select name="nat">
<option value="Indian">INDIAN</option>
<option value="O1">OTHERS</option>
<select><br>
Mother Tongue:   <select name="mtong">
<option value="Tamil">TAMIL</option>
<option value="English">ENGLISH</option>
<option value="O2">OTHERS</option>
<select><br>
Religion:        <select name="relg">
<option value="Hindu">HINDU</option>
<option value="Muslim">MUSLIM</option>
<option value="Christ">CHRISTIANITY</option>
<option value="O3">Others</option>
<select><br>
Community:       <select name="comm">
<option value="OC">OC</option>
<option value="BC">BC</option>
<option value="MBC">MBC</option>
<option value="SS">SC/ST</option>
<option value="DNC">DNC</option>
<option value="O4">Others</option>
</select><br>
Native District: <select name="district">
<option value="M">MADURAI</option>
<option value="S">SIVAGANAGAI</option>
<option value="V">VIRUDHUNAGAR</option>
<option value="T">THENI</option>
<option value="D">DINDUGUL</option>
<option value="O5">Others</option>
<select><br>
Caste:           <input type="text" name="caste"><br>
Mobile no:       <input type="text" name="mno"><br>
EmailID:         <input type="text" name="eid"><br>
</pre>
</fieldset>
<fieldset class="pos3">
<legend>MarkDetails</legend>
<pre>
Marks in H.S. / CBSE -XII

Language:                <input type="text" name="lan"><br>
English:                 <input type="text" name="eng"><br>
Subject1:                <input type="text" name="s1"><br>
Subject2:                <input type="text" name="s2"><br>
Subject3:                <input type="text" name="s3"><br>
Subject4:                <input type="text" name="s4"><br>
Month & Year of Passing: <input type="text" name="myp"><br>
</pre>
</fieldset>
<fieldset class="pos4">
<legend>CourseDetails</legend>
<pre>
Select your major:        <select name="ugmajor">
<option value="csc">B.Sc.ComputerScience</option>
<option value="mat">B.Sc.Mathematics</option>
<option value="phy">B.Sc.Physics</option>
<option value="che">B.Sc.Chemistry</option>
<option value="zoo">B.Sc.Zoology</option>
<option value="bot">B.Sc.Botany</option>
<option value="tam">B.A.Tamil</option>
<option value="eng">B.A.English</option>
<option value="bcs">B.Com.CS</option>
<option value="bca">B.Com.CA</option>
</select><br>
Select your 12th Group:   <select name="tgroup">
<option value="cs">ComputerScience</option>
<option value="bi">Biology</option>
<option value="ac">Accounts</option>
<option value="O6">Others</option>
<select>
</pre>
</fieldset>
<fieldset class="pos5">
<legend>Uploads</legend>
<pre>
Upload your passport size photo: <input type="file" name="u1">
Upload your Marksheet photo:     <input type="file" name="u2">
</pre>
</fieldset>
<input type="submit" value="APPLY" id="oval" class="b1">
<input type="button" value="BACK" id="oval" class="b2" onclick="location.href='Entry.html'">
</h3>
</form>
<?php
$name=$_REQUEST["Name"];
$dob=$_REQUEST["Dob"];
if($_REQUEST["gen"]=="Male")
{
$gend=1;
}
else
{
$gend=2;
}
$fname=$_REQUEST["Fname"];
$foc=$_REQUEST["Foc"];
$mname=$_REQUEST["Mname"];
$moc=$_REQUEST["Moc"];
$x[5];
$natt=$_REQUEST["nat"];
switch($natt)
{
	case "Indian": $x[0]=1;break;
	case "O1": $x[0]=2;break;
}
$mt=$_REQUEST["mtong"];
switch($mt)
{
	case "Tamil": $x[1]=1;break;
	case "English": $x[1]=2;break;
	case "O2": $x[1]=3;break;
}
$r=$_REQUEST["relg"];
switch($r)
{
	case "Hindu": $x[2]=1;break;
	case "Muslim": $x[2]=2;break;
	case "Christ": $x[2]=3;break;
	case "O3": $x[2]=4;break;
}
$c=$_REQUEST["comm"];
switch($c)
{
	case "OC": $x[3]=1;break;
	case "BC": $x[3]=2;break;
	case "MBC": $x[3]=3;break;
	case "SS": $x[3]=4;break;
	case "DNC": $x[3]=5;break;
	case "O4": $x[3]=6;break;
}
$d=$_REQUEST["district"];
switch($d)
{
	case "M": $x[4]="N0001";break;
	case "S": $x[4]="N0002";break;
	case "V": $x[4]="N0003";break;
	case "T": $x[4]="N0004";break;
	case "D": $x[4]="N0005";break;
	case "O5": $x[4]="N0006";break;
}
$cast=$_REQUEST("caste");
$mo=$_REQUEST("mno");
$ed=$_REQUEST("eid");
 $db = oci_connect("system","thebookofmirdad","localhost/8080")
 or die ("Couldn't connect to server");
 
$sql = 'INSERT INTO STUDENTDETAIL VALUES(:name,:dob,:gender,:fname,:focc,:mname,:mocc,:nati,:mton,:relgi,:comu,:dist,:cas,:mo,:emid)';
$compiled=oci_parse($db,$sql);
oci_bind_by_name($compiled,':name',$name);
oci_bind_by_name($compiled,':dob',$dob);
oci_bind_by_name($compiled,':gender',$gend);
oci_bind_by_name($compiled,':fname',$fname);
oci_bind_by_name($compiled,':focc',$foc);
oci_bind_by_name($compiled,':mname',$mname);
oci_bind_by_name($compiled,':mocc',$moc);
oci_bind_by_name($compiled,':nati',$x[0]);
oci_bind_by_name($compiled,':mton',$x[1]);
oci_bind_by_name($compiled,':relgi',$x[2]);
oci_bind_by_name($compiled,':comu',$x[3]);
oci_bind_by_name($compiled,':dist',$[4]);
oci_bind_by_name($compiled,':cas',$cast);
oci_bind_by_name($compiled,':mo',$mo);
oci_bind_by_name($compiled,':emid',$ed);
oci_execute($compiled);

$y[2];
$ug=$_REQUEST["ugmajor"];
switch($ug)
{
	case "csc": $y[0]="U0001";break;
	case "mat": $y[0]="U0002";break;
	case "phy": $y[0]="U0003";break;
	case "che": $y[0]="U0004";break;
	case "zoo": $y[0]="U0005";break;
	case "bot": $y[0]="U0006";break;
	case "tam": $y[0]="U0007";break;
	case "eng": $y[0]="U0008";break;
	case "bcs": $y[0]="U0009";break;
	case "bca": $y[0]="U0010";break;
}
$tg=$_REQUEST["tgroup"];
switch($tg)
{
	case "cs": $y[1]="G0001";break;
	case "bi": $y[1]="G0002";break;
	case "ac": $y[1]="G0003";break;
	case "O6": $y[1]="G0004";break;
}

$ln=$_REQUEST("lan");
$eg=$_REQUEST("eng");
$sub1=$_REQUEST("s1");
$sub2=$_REQUEST("s2");
$sub3=$_REQUEST("s3");
$sub4=$_REQUEST("s4");
$monyp=$_REQUEST("myp");
?>
</body>
</html>