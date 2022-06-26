<html>
<head>
<style type="text/css">
.bd { width: 100%;min-width: 700px; min-height: 800px;}
</style>
<title>RESULT</title>
</head>
<body style="background: rgb(252,220,177)" class="bd">
<center><h1 style="color: rgb(155,21,2)">FORM SENT SUCCESSFULLY.</h1></center>
<?php

$name=$_REQUEST["xxxx"];
$dob=$_REQUEST["Dob"];
if($_REQUEST["gen"]=="Male")
{
$gend=(integer)1;
}
else
{
$gend=(integer)2;
}
$fname=$_REQUEST["Fname"];
$foc=$_REQUEST["Foc"];
$mname=$_REQUEST["Mname"];
$moc=$_REQUEST["Moc"];
$strt =$_REQUEST["Street"];
$area =$_REQUEST["Area"];
$pin =(integer)$_REQUEST["Pin"];

$natt=$_REQUEST["nat"];
switch($natt)
{
	case "Indian": $x[0]=(integer)1;break;
	case "O1": $x[0]=(integer)2;break;
}
$mt=$_REQUEST["mtong"];
switch($mt)
{
	case "Tamil": $x[1]=(integer)1;break;
	case "English": $x[1]=(integer)2;break;
	case "O2": $x[1]=(integer)3;break;
}
$r=$_REQUEST["relg"];
switch($r)
{
	case "Hindu": $x[2]=(integer)1;break;
	case "Muslim": $x[2]=(integer)2;break;
	case "Christ": $x[2]=(integer)3;break;
	case "O3": $x[2]=(integer)4;break;
}
$c=$_REQUEST["comm"];
switch($c)
{
	case "OC": $x[3]=(integer)1;break;
	case "BC": $x[3]=(integer)2;break;
	case "MBC": $x[3]=(integer)3;break;
	case "SS": $x[3]=(integer)4;break;
	case "DNC": $x[3]=(integer)5;break;
	case "O4": $x[3]=(integer)6;break;
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
$cast=$_REQUEST["caste"];
$mo=(integer)$_REQUEST["mno"];
$ed=$_REQUEST["eid"];


 $db = oci_connect("system","thebookofmirdad","//localhost/XE")
 or die ("Couldn't connect to server");

$han = fopen("id.txt","r");
$id = fgets($han);
$id++;
$han = fopen("id.txt","w");
fwrite($han, $id);

$sql1 = 'INSERT INTO STUDENTDETAIL VALUES(\''.$id.'\',\''.$name.'\',\''.$dob.'\',\''.$fname.'\',\''.$foc.'\',\''.$mname.'\',\''.$moc.'\',\''.$strt.'\',\''.$area.'\','.$pin.','.$mo.',\''.$ed.'\','.$x[0].','.$x[1].','.$x[2].','.$x[3].','.$gend.',\''.$cast.'\',\''.$x[4].'\')';
$compiled=oci_parse($db,$sql1);
oci_execute($compiled);
oci_commit($db);

$ug=$_REQUEST["ugmajor"];
switch($ug)
{
	case "bcsc": $y[0]="U0001";break;
	case "bmat": $y[0]="U0002";break;
	case "bphy": $y[0]="U0003";break;
	case "bche": $y[0]="U0004";break;
	case "bzoo": $y[0]="U0005";break;
	case "bbot": $y[0]="U0006";break;
	case "btam": $y[0]="U0007";break;
	case "beng": $y[0]="U0008";break;
	case "bbcs": $y[0]="U0009";break;
	case "bbca": $y[0]="U0010";break;
}
$tg=$_REQUEST["tgroup"];
switch($tg)
{
	case "cs": $y[1]="G0001";break;
	case "bi": $y[1]="G0002";break;
	case "ac": $y[1]="G0003";break;
	case "O6": $y[1]="G0004";break;
}

$strea=$_REQUEST["cat"];
switch($strea)
{
	case "reg": $stream=1;break;
	case "fin": $stream=2;break;
	
}

$ln=$_REQUEST["lan"];
$eg=$_REQUEST["eng"];
$sub1=$_REQUEST["s1"];
$sub2=$_REQUEST["s2"];
$sub3=$_REQUEST["s3"];
$sub4=$_REQUEST["s4"];
$monyp=$_REQUEST["myp"];
$tot = $ln + $eg + $sub1 + $sub2 + $sub3 + $sub4;

$sql2 = 'INSERT INTO TMARKDETAIL VALUES(\''.$id.'\',\''.$y[1].'\','.$ln.','.$eg.','.$sub1.','.$sub2.','.$sub3.','.$sub4.','.$tot.',\''.$y[0].'\',\''.$monyp.'\','.$stream.')';
$compiled=oci_parse($db,$sql2);
oci_execute($compiled);

if($_SERVER["REQUEST_METHOD"] == "POST")
{
    // Check if file was uploaded without errors
    if(isset($_FILES["u1"]) && $_FILES["u1"]["error"] == 0){
        $allowed = array("jpg" => "image/jpg", "jpeg" => "image/jpeg", "gif" => "image/gif", "png" => "image/png");
        $filename = $_FILES["u1"]["name"];
        $filetype = $_FILES["u1"]["type"];
        $filesize = $_FILES["u1"]["size"];
    
        // Verify file extension
        $ext = pathinfo($filename, PATHINFO_EXTENSION);
        if(!array_key_exists($ext, $allowed)) die("Error: Please select a valid file format.");
    
        // Verify file size - 5MB maximum
        $maxsize = 5 * 1024 * 1024;
        if($filesize > $maxsize) die("Error: File size is larger than the allowed limit.");
    
        // Verify MYME type of the file
        if(in_array($filetype, $allowed)){
            // Check whether file exists before uploading it
            if(file_exists("upload1/" . $filename)){
                echo $filename . " is already exists.";
            } else{
                move_uploaded_file($_FILES["u1"]["tmp_name"], "upload1/" . $filename);
                echo "Your passport size photo file was uploaded successfully.";
            } 
        } else{
            echo "Error: There was a problem uploading your file. Please try again."; 
        }
		$urll="upload1\\".$filename;
		$sq1='insert into upload1 values(\''.$id.'\',\''.$urll.'\')';
		$compiled=oci_parse($db,$sq1);
        oci_execute($compiled);
		
    } 
	else
	{
        echo "Error: " . $_FILES["u1"]["error"];
    }
	
	 // Check if file was uploaded without errors
    if(isset($_FILES["u2"]) && $_FILES["u2"]["error"] == 0)
	{
        $allowed = array("jpg" => "image/jpg", "jpeg" => "image/jpeg", "gif" => "image/gif", "png" => "image/png");
        $filename = $_FILES["u2"]["name"];
        $filetype = $_FILES["u2"]["type"];
        $filesize = $_FILES["u2"]["size"];
    
        // Verify file extension
        $ext = pathinfo($filename, PATHINFO_EXTENSION);
        if(!array_key_exists($ext, $allowed)) die("Error: Please select a valid file format.");
    
        // Verify file size - 5MB maximum
        $maxsize = 5 * 1024 * 1024;
        if($filesize > $maxsize) die("Error: File size is larger than the allowed limit.");
    
        // Verify MYME type of the file
        if(in_array($filetype, $allowed))
		{
            // Check whether file exists before uploading it
            if(file_exists("upload2/" . $filename)){
                echo $filename . " is already exists.";
            } else{
                move_uploaded_file($_FILES["u2"]["tmp_name"], "upload2/" . $filename);
                echo "Your marksheet photo file was uploaded successfully.";
            } 
        } 
		else
		{
            echo "Error: There was a problem uploading your file. Please try again."; 
        }
		$urll="upload2\\".$filename;
		$sq1='insert into upload2 values(\''.$id.'\',\''.$urll.'\')';
		$compiled=oci_parse($db,$sq1);
        oci_execute($compiled);
		
    } else{
        echo "Error: " . $_FILES["u2"]["error"];
    }
}


oci_commit($db);
oci_close($db);
?>
</body>
</html>