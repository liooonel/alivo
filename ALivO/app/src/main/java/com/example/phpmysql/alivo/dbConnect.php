<?php
 define('HOST','mysql.hostinger.fr');
 define('USER','u861631075_root);
 define('PASS','ALivoRoot236');
 define('DB','u861631075_alivo');

 $linkconn = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');

// Pour une meilleure gestion des erreurs de connexion pour éviter l'affichage des messgaes d'erreurs qui affiche
// les informations sur son serveur ou qui renvoie un message d'erreur pas forcément compréhensible pour un non-
//informaticien

 /*if (!$linkconn)
 {
     // Traitement de l'erreur
 }
 else
 {
   if (!@mysql_select_db('ma_base', $linkconn)
   {
     // Traitement de l'erreur
   }
   else
   {
     $sql = 'SELECT champ1,champ2 FROM `ma_table`';
     $rs = @mysql_query($sql, $linkconn);
     if (!$rs)
     {
       // Traitement de l'erreur
     }
     else
     {
       if (mysql_num_rows($rs) == 0)
       {
         // Traitement du cas où la requête n'a retourné aucun élément

       }
       else
       {
         // Exploitation des données
         while ($row = mysql_fetch_assoc($rs))
         {
           // ...
         }
       }
     }
   }
 }*/