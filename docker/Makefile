build:
	cd .. && mvn package
	cp -f ../target/demoForum-1.0-SNAPSHOT.war ./
	docker build -t test .
	docker run -p 80:8080 test