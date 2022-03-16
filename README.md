commande pour lancé le build de l'image:


``
docker build -t verkeur08/gestionetablissement:latest  --build-arg branch=main --build-arg depoGit=GestionEtudiants --build-arg autheurGit=asemin08 --build-arg tagImage=3.8.4-openjdk-17-slim --no-cache .
``