FROM tomcat:9-jre17


ADD demoForum.war /usr/local/tomcat/webapps/
COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/
COPY tomcat-users.xml  /usr/local/tomcat/conf/
ADD postgresql-42.6.0.jar /usr/local/tomcat/lib/
#ADD postgresql-42.6.0.jar /usr/lib/jvm/java-17-amazon-corretto/lib

EXPOSE 8080

CMD ["catalina.sh", "run"]