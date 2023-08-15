FROM tomcat:9.0-alpine

ADD demoForum.war /usr/local/tomcat/webapps/
COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/
COPY tomcat-users.xml  /usr/local/tomcat/conf/

EXPOSE 8080

CMD ["catalina.sh", "run"]