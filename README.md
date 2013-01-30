Mercenaries
===========

Team
----

- bguerout
- adergham
- FlorentD
- yamsellem
- dimapod
- sophietk

Server
------

Install, deploy and test web server:

```
cd server
npm install
node server.js
node tests/it.js
```

Install [supervisor](https://github.com/isaacs/node-supervisor) for server live refresh

Webapp
------

Start the server and open http://localhost:3000

Android App
-----------
See android readme


Mongo
-----

Install [Mongo on mac](http://shiftcommathree.com/articles/how-to-install-mongodb-on-os-x)


Neo4j
-----

Install [Neo4j](http://www.neo4j.org/install)
Use http://localhost:3000/node/static to init graph

Amazon EC2 / ec2-46-51-153-75.eu-west-1.compute.amazonaws.com
---------
Generate a ssh key and send .pub file to bguerout. 
Your public key will be added as an authorized key for EC2 mercenary user
```
ssh-keygen -t rsa -b 2048 -C "your email"
```
Connect to EC2 instance 
```
ssh -i your-key-file mercenary@ec2-46-51-153-75.eu-west-1.compute.amazonaws.com
```


