<?php
include("DataBaseClass.php");
$dataBase = new DataBase("localhost", "root", "qwerty123", "database");

$Name = $_POST["Name"];
$LastName = $_POST["LastName"];
$Email = $_POST["Email"];
$Password = $_POST["Password"];
$UserName = $_POST["UserName"];

echo $dataBase->doQuery("call register('$Name', '$LastName', '$Email', '$Password', '$UserName');");
$dataBase->close();
?>