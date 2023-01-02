cd swing
mvn clean install -s settings.xml
mvn package 
cd ..

cd Dynamic
mvn package -s settings.xml 
cd ..

cd MobileTurismo.uy
mvn package -s settings.xml 
cd ..

