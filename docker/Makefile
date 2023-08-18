build:
	cd .. && mvn package
	cp -f ../target/demoForum.war ./
	docker build -t tomcat_webapp .
	docker compose up