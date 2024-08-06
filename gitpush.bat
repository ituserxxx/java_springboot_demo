@echo off


rem "clean jar"
call del .\ytwl_admin.jar
call mvnw.cmd clean package
echo "mvnw.cmd clean package ok"

rem "move jar"
move .\target\xcx-0.0.1-SNAPSHOT.jar .\ytwl_admin.jar
echo ".\ytwl_admin.jar update ok"

rem "add file"
git add .

rem "commit file"
git commit -m "Add compiled JAR and update changes"

rem "push file"
git push origin

rem "ok"
echo "push ok"
