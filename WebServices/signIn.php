<?php
include("DataBaseClass.php");
$dataBase = new DataBase("localhost", "root", "qwerty123", "database");

$Email = "Farcem90@hotmail.com"; //$_POST["Email"];
$Password = "hola123"; //$_POST["Password"];

echo $dataBase->doQuery("call signIn('$Email', '$Password');");
$dataBase->close();
?>
