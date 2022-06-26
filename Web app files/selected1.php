<html>
<head>
<title>SELECTED LIST</title>
<style type="text/css">
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
.bd { width: 100%;min-width: 700px; min-height: 500px;}
.ps{ position: absolute; top: 150px; left:200px;} 
</style>
<script type="text/javascript">
var XMLHttpRequestobj = false;
if(window.XMLHttpRequest)
{
	XMLHttpRequestobj = new XMLHttpRequest();
}
else if (window.Activexobject)
{
	XMLHttpRequestobj = new Activexobject("Microsoft.XMLHTTP");
}
function loadXMLDoc(datasource, divid)
{
	if(XMLHttpRequestobj)
	{
		var obj = document.getElementById(divid);
		XMLHttpRequestobj.open("POST",datasource);
		XMLHttpRequestobj.onreadystatechange = function()
		{
			if(XMLHttpRequestobj.readyState == 4 &&
			XMLHttpRequestobj.status == 200)
			{
				obj.innerHTML = XMLHttpRequestobj.responseText;
			}
		}
		XMLHttpRequestobj.send(null);
	}
}
function createop()
{
var s1=[];
var s2=[];
    s1[0] = "B.Sc.ComputerScience";
    s1[1] = "B.Sc.Mathematics";
    s1[2] = "B.Sc.Physics";
    s1[3] = "B.Sc.Chemistry";
    s1[4] = "B.Sc.Botany";
    s1[5] = "B.Sc.Zoology";
    s1[6] = "B.A.Tamil";
    s1[7] = "B.A.English";
    s1[8] = "B.Com.CA";
    s1[9] = "B.Com.CS";
	
	s2[0] ="M.Sc.ComputerScience";
    s2[1] ="M.Sc.Mathematics";
    s2[2] ="M.Sc.Physics";
    s2[3] ="M.Sc.Chemistry";
    s2[4] ="M.Sc.Botany";
    s2[5] ="M.Sc.Zoology";
    s2[6] ="M.A.Tamil";
    s2[7] ="M.A.English";
    s2[8] ="M.Com.CA";
    s2[9] ="M.Com.CS";
var sb1=document.getElementById("cat1");
var sb2=document.getElementById("cat2");
var sv=sb1.options[sb1.selectedIndex].value;

if(sv==="ug")
{
 sb2.innerText=null;
 var opt1 = document.createElement('option');
  opt1.value="0";
  opt1.innerHTML="--select--";
  sb2.appendChild(opt1);
 for(var i=0;i<10;i++)
 {
  var opt = document.createElement('option');
  opt.value=s1[i];
  opt.innerHTML=s1[i];
  sb2.appendChild(opt);
 }
}
else
{
sb2.innerText=null;
  var opt1 = document.createElement('option');
  opt1.value="0";
  opt1.innerHTML="--select--";
  sb2.appendChild(opt1);
for(var i=0;i<10;i++)
 {
  var opt = document.createElement('option');
  opt.value=s2[i];
  opt.innerHTML=s2[i];
  sb2.appendChild(opt);
  }
}
}
</script>
</head>
<body style="background: rgb(252,220,177)" class="bd">
<form>
<h2 style="color: rgb(155,21,2)">
CHOOSE THE CATEGORY:  <select name="c1" id="cat1" onchange="createop()">
<option value="none">--select--</option>
<option value="ug">UG</option>
<option value="pg">PG</option>
</select>
CHOOSE THE MAJOR: <select name="c2" id="cat2">
<option value="none">--select--</option>
</select>
<input type="button" value="SHOW" id="oval" onclick="loadXMLDoc('sel1.php','mydiv')">
</h2>
<div id="mydiv"></div>
</form>
</body>
</html>