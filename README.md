configurar credenciales de git

git config --global user.name  "agregar nombre de usuario"
git config --global user.email  "poner el correo con el que se tiene la cuenta de git"

Para descargar el repositorio:

git clone https://github.com/samuelp331/Construccion2.git
git remote add origin https://github.com/samuelp331/Construccion2.git

subir cambios:
git add .
git commit -m "cualquier mensaje descriptivo"
git push origin <rama a la cual quiere subir los cambios"
