GENTON Emilie - ESIREM TD1 - TP2 

Pour ce projet de java, j'ai choisi de réaliser un Cluedo (avec l'IDE IntelliJ). Il s'agit d'un jeu Humain VS Humain. 
Il n'y a donc pas d'intelligences artificielles implémentées. 



LE CLUEDO, C'EST QUOI ?

Le but du Cluedo est simple : trouver l'assassin, l'arme du crime et le lieu. Pour ce faire, on distribue toutes les cartes (armes, personnes et lieux)
sauf trois (une de chaque type). Ce talon de 3 cartes constituera la solution de l'enquête. 
Chaque joueur a un pion qui permettra de voyager de pièce en pièce. Les joueurs disposent d'une feuille où chaque élément est répertoirié où ils peuvent cocher
les cartes vues. 

Chaque joueur lance les dés pour se déplacer. Dès qu'il se trouve dans une pièce, il peut alors faire une proposition qui sera, si cela est possible, démentie par 
un joueur. 

Si le joueur parvient à trouver le coupable, le lieu et l'arme, il faut alors qu'il se rende au lieu et fasse son accusation. Si cette accusation est fausse alors
le joueur perd et la partie continue s'il reste au minimum 2 joueurs, sinon il gagne la partie.   




LANCEMENT DE MON CLUEDO

Pour commencer, il suiffit de lancer le fichier d'exécution .jar (se trouvant dans le dossier out/artifacts) dans l'invite de commande à l'aide de la commande suivante : 
				java -jar [chemin/nomFichier.jar]
Une fois le fichier lancé, nous arrivons sur le menu. Ce dernier comporte 2 boutons : un pour quitter la partie et un autre pour jouer. 
Si nous cliquons sur le bouton "JOUER", une deuxième fenêtre s'affiche où nous pouvons renseigner le nombre de joueur (entre 2 et 6). 
Il suffit ensuite d'enquêter ! 
Nous arrivons sur la fenêtre du jeu principale. Il comporte un plateau, une entête où le numéro du joueur est renseigné, la couleur du pion, 
ainsi qu'à droite, deux boutons permettant d'accuser ou de soupçonner quelqu'un. Pour utiliser ces boutons, il faut que le joueur se trouve 
dans une pièce (une case non classique). A gauche, une liste des personnes, armes et lieux que le joueur peut cocher. Enfin, en bas se trouve
les cartes du joueur ainsi que deux autres boutons pour lancer le dé et passer au tour suivant. 



LE DEROULEMENT D'UNE PARTIE

J'ai décidé d'utiliser un seul dé de 6 car j'ai réduit la taille du plateau. De plus, j'ai numéroté les cases du plateau. Vous pourrez trouver le détail dans le 
fichier "plan_plateau.png".

Voici quelques règles qui s'applique sur ce jeu :
      - Le joueur lance le dé pour se déplacer sur le plateau (cf bouton "LANCER LE DÉ"), il peut faire cette action une seule fois par tour. 
      - Une fois le dés lancé, le joueur choisit la case souhaité en un clic (il peut se déplacer au maximun du nombre obtenu au lancé de dé).
      - Si le joueur est dans une pièce il peut alors accuser ou soupçonner quelqu'un (cf PROPOSITION et ACCUSATION). Ici, il choisit les informations.
        Si un joueur peut contredire la proposition, le joueur est alors appelé et choisit la carte à montrer. Il laisse ensuite la main au joueur.
      - Pendant un tour, le joueur peut rester où il se trouve s'il est dans une pièce : pour passer au tour suivant, il faut que le joueur est soit lancé
        le dé soit fait une proposition (ou les deux). 
      - La partie s'arrête quand un des joueurs a fait la bonne accusation ou quand il ne reste plus qu'un seul joueur. 
      - La bibliothèque est un espace ouvert, on peut entrer par n'importe quelle case. 
 

