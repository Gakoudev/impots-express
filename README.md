# impots-express API REST
 Impots Express est une application API REST de gestion fiscale simplifiée qui permet aux utilisateurs de déclarer leurs impôts, de suivre leurs montants à régler et d&apos;effectuer des paiements en quelques étapes simples. Cette plateforme conviviale vise à faciliter le processus de conformité fiscale, offrant une expérience fluide et efficace pour les déclarants et les contribuables.
# Démonstration avec POSTMAN:
Nous Allons ajoutez 3 déclarant et pour chaque déclarant nous allons l'affecté une déclaration. La déclaration du declarant 1 sera payé entièrement, ceelui du déclarant 2 sera payé en deux tranche mais de manière incomplèète et celui du declarant 3 ne sera pas payé. Ainsi nous allons faire sortire les déclaration impayé et le montant restant à payer.
   # Plan de Travail POSTMAN
   <img width="205" alt="workspace" src="https://github.com/Gakoudev/impots-express/assets/98522554/b32139fc-bc0b-4a80-a51c-e95861f70298">


   # Ajouter Declarant
<img width="552" alt="add" src="https://github.com/Gakoudev/impots-express/assets/98522554/8ca3a54a-9c76-45b2-83c8-cf9ec74db132">

 Par le même procédé nous avons ajoutez 3 déclarant.
   # Lister Declarant
<img width="561" alt="list" src="https://github.com/Gakoudev/impots-express/assets/98522554/24c9b83e-a63d-4f29-8f9e-1eeefae656e3">

  # Ajouter Declaration
 <img width="550" alt="add" src="https://github.com/Gakoudev/impots-express/assets/98522554/be30bba4-0fc9-40f8-9640-75c8c903c74e">
 
Par le même procédé nous avons ajoutez 3 déclaration.
 # Lister Declaration
<img width="571" alt="list" src="https://github.com/Gakoudev/impots-express/assets/98522554/96d3e7a6-7433-4ecb-aeea-1c4e876e4c07">

  # Ajouter Paiement
<img width="545" alt="addP1" src="https://github.com/Gakoudev/impots-express/assets/98522554/326b3a4f-0788-4a39-a108-770801bec4e7">

Ici nous avons effectué un paiement total pour la déclaration d'id 1

<img width="559" alt="addP2(1)" src="https://github.com/Gakoudev/impots-express/assets/98522554/0c904588-365f-43bc-9433-c26e50b70772">
<img width="568" alt="addP2(2)" src="https://github.com/Gakoudev/impots-express/assets/98522554/2063a7de-cbe5-4790-a682-0f49087a6537">

Dans cette démo nous avons fait un paiement par tranche pour la déclaration d'id 2. Ce pendant le montant totale du paiement reste inférieur au montant de la déclaration  
  # Lister Paiement
<img width="574" alt="listP" src="https://github.com/Gakoudev/impots-express/assets/98522554/4c6d7531-b125-4baa-8621-91377644a307">


 # Lister Declaration Non Payée
<img width="566" alt="listNP" src="https://github.com/Gakoudev/impots-express/assets/98522554/350f8b87-357f-4ab5-b32f-1b6a99ad807a">

On peut voire de manière claire la liste des déclaration non payée et le reste à payer.
