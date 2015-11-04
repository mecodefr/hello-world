FROM codefresh/buildpacks:all

RUN sudo apt-get -y update
RUN sudo apt-get -y install openjdk-7-jdk
COPY Main.java /Main.java
RUN javac Main.java
CMD java Main


#COPY package.json /src/package.json

#WORKDIR /src

#RUN npm install --production

#COPY . /src

#node inspector port
#EXPOSE 9000
#ENV PORT 9000

#CMD node server.js production
