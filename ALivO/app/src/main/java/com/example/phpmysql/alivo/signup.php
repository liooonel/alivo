<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
 $nom_utilisateur = filter_input(INPUT_POST, 'nom_utilisateur');
 $num_telephone = filter_input(INPUT_POST, 'num_telephone');

 if($nom_utilisateur == '' || $num_telephone == ''){
 echo 'Veuillez remplir tous les champs';
 }else{
 require_once('dbConnect.php');
 $sql = "SELECT * FROM utilisateurs WHERE nom_utilisateur ='$nom_utilisateur'";

 $check = mysqli_fetch_array(mysqli_query($linkconn,$sql));

 if(isset($check)){
 echo 'Nom d\'utilisateur existant';
 }else{
 $sql = "INSERT INTO utilisateurs (`identifiant`, `nom_utilisateur`, `num_telephone`) VALUES('','$nom_utilisateur','$num_telephone')";
 if(mysqli_query($linkconn,$sql)){
 echo 'Votre compte a été créé avec succès';
 }else{
 echo 'Veuillez réessayer!';
 }
 }
 mysqli_close($linkconn);
 }
}else{
echo 'Erreur! Vérifiez votre connexion internet';
}