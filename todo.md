### livrables ok

-  [ ] ne pas oublier de résoudre (autant que possible) les alertes de l'IDE

### grammaire

-  [ ] les règles avec des opérations binaires parenthésées sont redondantes (elles correspondantes à une combinaison
   des
   règles des opérations binaires et des termes parenthésées)

### transformation de l'AST

-  [ ] a priori, elle laisse des noeuds LetPlus, pour lesquels il n'y a pas de règle d'interprétation. Ex. : let x = let
   x =
   1 in x in x, qui donne Let(x,LetPlus(List((x,Lit(1))),Var(x)),Var(x))

### interprétation ok

### typage

-  [x] vert ok (mais le message d'erreur associé à 1 + fun x -  [ ]> x est curieux)
-  [x] bleu ok
-  [ ] rouge : pb de typage de l'application (ex. le plus simple: (fun x -  [ ]> x) 1). On tombe sur un cas non
   implémenté d'un
   pattern matching. Mais à la base, il ne devrait pas y avoir de pattern matching, l'unification est plus générale.