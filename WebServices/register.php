<?php
include("DataBaseClass.php");
$dataBase = new DataBase("localhost", "root", "qwerty123", "database");

$Name = $_POST["Name"];
$LastName = $_POST["LastName"];
$Email = $_POST["Email"];
$Password = $_POST["Password"];

echo $dataBase->doQuery("call register('$Name', '$LastName', '$Email', '$Password');");
$dataBase->close();
?>