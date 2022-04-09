This application for docker, docker compose and rest application



run the following
step 1: goto
D:\MyProjects\MyWork\expenseApp>
step 2 run the following to build image
docker build -t venn-app/expense-app:0.0.1-SNAPSHOT .

step 3: 
docker container ls -a

to run above image

docker run -d -p 9090:9090 venn-app/expense-app:0.0.1-SNAPSHOT

docker run -p 9090:9090 -p 27017:27017 venn-app/expense-app:0.0.1-SNAPSHOT

above two commands would not run, i tried to connect my local mongo which did connect

so create docker compose for application and mongo then worked fine.


Created a docker compose so run docker compose works fine.

Step 4: goto the root directory where docker compose exists
        to start ==> docker-compose up -d  

        to stop ==> docker-compose down 

**********************************


to stop docker container :

step 1: docker container list

step 2: take image id 

docker container stop fe9225b81275

step 3:  docker rm fe9225b81275

docker network ls

which is important command
docker inspect bridge

Create a custom network

step 1: docker network create rest-application-mongodb-network

step 2: docker network ls

step 3:
#docker run -p 9090:9090 -p 27017:27017 --network=rest-application-mongodb-network venn-app/expense-app:0.0.1-SNAPSHOT

above alose did not work.

only docker compose works fine for application + any database

