# Android4A_AA
Projet de mobile programming 4A

## Auteur
Aurélien Andrieux

## Présentation
<p> Simple application démrarrant sur une page de création de compte/login, avant de présenter une liste recensant les jeux principaux de la série « The Legend Of Zelda »</p>
<p> Cette application est codée en Kotlin et applique le pattern MVVM. </p>

## Prérequis

-	Installation de Android Studio.
- Téléchargement de la branche « master » en utilisant le lien suivant: https://github.com/Beuhlex/Android4A_AA
</li>

## Consignes Respectées

- Langage Kotlin
- Architecture MVVM
- Clean Architecture
- Utilisation d'une réelle Base De Données
- Utilisation d'une Api REST
- Affichage d'une liste
- Design
- Autres fonctionnalités
  - Écran d'accueil permettant de se connecter à un compte existant, ou d'en créer un. Différentes erreurs possibles prises en compte
</li>

## Fonctionnalités
#### Écran d'accueil
- Ecran principal permettant de créer un compte ou de se connecter à un compte existant.

![Accueil 33](https://user-images.githubusercontent.com/62256052/103306111-16a6ea00-4a0d-11eb-8022-2948679d34ce.jpg)
![Username Password Dont Match 33](https://user-images.githubusercontent.com/62256052/103305965-b31cbc80-4a0c-11eb-9334-d2a387f7fda2.jpg)

- Impossibilité de créer un compte avec un nom de compte et/ou un mot de passe vide

![No Username 33](https://user-images.githubusercontent.com/62256052/103305952-aef09f00-4a0c-11eb-8f3d-03c0362364c4.jpg)
![No Password 33](https://user-images.githubusercontent.com/62256052/103305943-ad26db80-4a0c-11eb-8ea9-bd3d20935b21.jpg)

- Impossibilité de créer un compte si le mot de passe et le nom d'utilisateur existent déjà

![Username Already Used 33](https://user-images.githubusercontent.com/62256052/103305958-b0ba6280-4a0c-11eb-8c71-e54a6aa6f976.jpg)

#### Écran de liste
- Écran affichant la liste des jeux principaux de la license « The Legend Of Zelda »
</li>

![Liste 33%](https://user-images.githubusercontent.com/62256052/103305699-19eda600-4a0c-11eb-8cc6-324d4afbe9e1.jpg)
