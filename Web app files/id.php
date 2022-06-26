<html>
<body>
<?php
$han = fopen("id.txt","r");
$id = fgets($han);
$id++;
echo $id;
$han = fopen("id.txt","w");
fwrite($han, $id);
?>
</body>
</html>