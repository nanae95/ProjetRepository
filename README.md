*****************************************************************************
PROJET JAVA : VALLA & NAEJUS

COMPTE RENDU 
*****************************************************************************

Différences entre notre diagramme UML de base et le diagramme UML de notre projet final :

Notre diagramme initial était assez simple avec une classe Utilisateur, Bibliothèque et Document.
Nous avions décidé de représenter les différents types de documents en créant pour chacun des types de docmuents, une classe qui héritent de document.
Les utilisateurs étaient reliés à des bibliothèques par une relation estEnregistré.
Et les documents étaient reliés à des bibliothèques par une relation Héberge.

Dans le diagramme correspondant à notre projet rendu nous nous sommes retrouvés avec plus de classes que prévu initialement.

Nous avons rajouté une classe Application qui regroupe toutes les fonctionnalités demandées de l'application.
Elle permet notamment d'afficher des sorties et de gérer des entrées pour permettre à l'utilisateur de l'application 
d'intérargir avec la base de données.

Nous avons également ajouté la classe DocumentComparator qui sert à trier chronologiquement des documents 
et la classe ExceptionSerie qui sert à renvoyer un message d'erreur si le document n'est pas une série.

Nous avons créer plusieurs classes Liste (ListeDoc, ListeLivre, ListeSerie, ListeSerieLivre), la classe ListeDoc pour gérer 
tous les documents, ListeLivre les documents livres, ListeSerie seulement les séries et ListeSerieLivre les séries de livres.

La classe FileReader contient une fonction qui permet de lire un fichier CSV qui est ensuite appelée dans la classe Main pour 
charger les données.

Nous avions prévu une fonction échange pour permettre à 2 bibliothèques de s'échanger des documents mais nous avons finalement 
opté pour 2 fonctions, une fonction emprunt et une fonction remise pour effectuer un échange.



CEPENDANT :

Par manque de temps, nous n'avons pas pu implémenter de fonctions pour gérer l'emprunt d'une bibliotheque au réseau ainsi que
l'emprunt par un utilisateur dans une bibliotheque. De plus, l'emprunt que nous avons commencer à implémenter ne prend pas en
compte la disponibilité du document dans la bibliotheque.

De plus, il manque des exceptions pour le controle des valeurs entrées par l'utilisateur. Conséquences : l'application s'arrete
alors qu'elle pourrait ignorer l'action.

Nous n'avons pas non plus, fait tous les controles quant à la distinction entre les livres et les documents pour les différentes
fonctionnalités et l'application

======> MANQUE DE TEMPS :'(



