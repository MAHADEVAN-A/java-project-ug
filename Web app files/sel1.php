<?php
if(isset($_REQUEST["c2"]))
{
$sv=$_REQUEST["c2"];
$text= file_get_contents($sv.".txt");
$fix = str_replace("\n","<br>",$text);

echo "<h3 style=\"color: rgb(155,21,2); font-family: cursive; font-size: x-large\">
<fieldset class=\"pos11\" style=\"color: rgb(155,21,2)\">
<legend>MessageBox</legend>
<div><pre>".$fix."</pre></div>
</fieldset>
</h3>";
}
?>