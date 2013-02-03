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

Resources
---------

On a dev machine, import a 100-songs json sample in mongo :

```
cd resources
unzip mercenary.zip
mongoimport  --db mercenary --collection song --file mercenary.json
```

Webapp
------

Start the server and open [localhost:3000](http://localhost:3000)

Launching UI tests :
```
cd webapp/tests
npm install
node search.js
```

Android App
-----------
See android readme


Mongo
-----

Install [Mongo on mac](http://shiftcommathree.com/articles/how-to-install-mongodb-on-os-x)


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


