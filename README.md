# convertArabicNumberToRomanNumber
Programme Java de conversion de chiffres arabes en chiffres romains

## Démarche : 

Choix de la stratégie de conversion :

Pour convertir un chiffre arabe en chiffre romain, j'ai décidé de créer une matrice de correspondance en base 10 :

    				0	| 1	| 2	  | 3	| 4   | 5  | 6   | 7    | 8     | 9
	 unite		    ''	| I	| II  | III	| IV  | V  | VI  | VII  | VIII  | IX
	 dizaine		''  | X	| XX  | XXX	| XL  | L  | LX  | LXX  | LXXX  | XC
	 centaine		''	| C	| CC  | CCC	| CD  | D  | DC  | DCC  | DCCC  | CM	
	 millier		'' 	| M	| MM  | MMM	

Il suffit maintenant pour chaque nombre de parcourir les entiers et faire correspondre le chiffre (la colonne) avec sa position dans la chaine de caractère (la ligne).

Pour un résultat précis, il faut veiller à ce que les caractères ne soient que des chiffres, qu'ils soient compris entre 1 et 3 999 et qu'il n'y ait pas d'espace.

J'ai choisi d'externaliser la lecture, l'écriture des fichiers ainsi que la méthode de conversion car ces fonctions pourraient être réutilisées et cela permet aussi la mise en place de tests unitaires.

Pour les tests unitaires, j'ai choisi de tester :
* un cas passant (convertir 123)
* un cas avec des caractères
* un cas suprérieur à 3 999

Le projet a été réalisé en 3h

