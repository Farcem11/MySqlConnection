<?php
include("DataBaseClass.php");
$dataBase = new DataBase("localhost", "root", "qwerty123", "database");

$Email = $_POST["Email"];//"Farcem90@hotmail.com";
$Password = $_POST["Password"];//"hola123";

echo $dataBase->doQuery("call signIn('$Email', '$Password');");
$dataBase->close();
?>