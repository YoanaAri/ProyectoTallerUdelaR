
cd swing
call mvn clean install -U
call mvn package
cd ..

cd dynamic
call mvn package
call mvn cargo:deploy
cd..

cd mobileturismo.uy
call mvn package
call mvn cargo:deploy
cd..

