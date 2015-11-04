FROM codefresh/buildpacks:all

RUN sudo apt-get -y update
RUN sudo apt-get -y install openjdk-7-jdk
COPY Main.java /Main.java
COPY rt.jar /rt.jar
RUN javac -cp rt.jar Main.java

EXPOSE 83
CMD sudo java -cp rt.jar:. Main


#COPY package.json /src/package.json

#WORKDIR /src

#RUN npm install --production

#COPY . /src

#node inspector port
#EXPOSE 9000
#ENV PORT 9000

#CMD node server.js production
