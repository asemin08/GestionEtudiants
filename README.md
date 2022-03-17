# Projet de Gestion D'établissement

Ce projet pour l'instant permet juste la création et la visualisation d'étudiant.


## Pré-requis
* java jdk17
* docker
* ansible
* terraform


#### Pour déployer l'instance ec2 :
1. Se connecter sur [Pipeline](http://146.59.154.110:8080/job/GestionEtudiant/)
2. identifiant : allan
3. mot de passe : 5rR1F4ZJw1wBVVyIqwph
4. aller dans build avec des paramètres
5. Pour déployer cliquer sur build sans cocher la case destroy
6. Attendre que toutes les taches se finissent
7. Pour ce rendre sur le site cliquer sur la case lecture de l'ip de la machine > cliquer sur le temps > afficher logs et l'url de la machine sera affiché
8. Cliquer ou depuis un navigateur ce rendre à l'url affiché

Pour supprimer l'instance ec2
> 1. Se connecter sur [Pipeline](http://146.59.154.110:8080/job/GestionEtudiant/)
> 2. identifiant : allan
> 3. mot de passe : 5rR1F4ZJw1wBVVyIqwph
> 4. aller dans build avec des paramètres
> 5. cocher la case 'destroy'
> 6. cliquer sur build
> 7. attendre que toutes les taches se finissent

 

## Test sans pipeline

1. Créer un dossier .aws à la racine du projet
2. remplir le dossier avec la clé.pem nommé votre clé  MyResto.pem de votre compte aws
3. créer un fichier credentials comme ci-dessous:
`   [default]
   aws_access_key_id = ""
   aws_secret_access_key = ""`
4. Ouvrir un terminal à la racine du fichier 
5. Ce rendre dans le dossier Terraform/App 
`cd terraform/app`
6. Exécuter le init
`terraform init`
7. Exécuter le apply
   `terraform apply`
8. Puis saisir yes
9. Récupérer l'adresse ip ce trouvant dans le fichier ip_connexion.txt
10. Ouvrir un navigateur et ce rendre à cette url.

