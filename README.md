# TP JPA 
Travail avec l'IDE IntelliJ IDEA 13 - Serveur Wildfly

Serveur Wildfly configuré pour travailler sur la base MySql

## Implémentation du CRUD (Create Read Update Delete) sur les quatre entités, par le biais d'un Web Service REST :

### 1 - Médecin : 

###Création d'un médecin : 

Request : 

`POST : /tp_jpa/rest/medecin`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`

```json
{  
   "version":1,
   "titre":"Mr",
   "nom":"LEMAIRE",
   "prenom":"Francis"
}
```

##### Récupération de tous les médecins

Request : 

 `GET  : /tp_jpa/rest/medecin/allMedecins`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`


```json
[  
   {  
      "id":1,
      "version":1,
      "titre":"Mme",
      "nom":"PELISSIER",
      "prenom":"Marie"
   },
   {  
      "id":2,
      "version":1,
      "titre":"Mr",
      "nom":"BROMARD",
      "prenom":"Jacques"
   },
   {  
      "id":3,
      "version":1,
      "titre":"Mr",
      "nom":"JANDOT",
      "prenom":"Philippe"
   },
   {  
      "id":4,
      "version":1,
      "titre":"Melle",
      "nom":"JACQUEMOT",
      "prenom":"Justine"
   },
   {  
      "id":6,
      "version":1,
      "titre":"Mr",
      "nom":"LEMAIRE",
      "prenom":"Francis"
   }
]
```

##### Récupération d'un médecin

Request : 

 `GET  : /tp_jpa/rest/medecin/2`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`


```json
{  
   "id":2,
   "version":1,
   "titre":"Mr",
   "nom":"BROMARD",
   "prenom":"Jacques"
}
```


##### Modification d'un médecin

Request : 

 `PUT  : /tp_jpa/rest/medecin/6`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`


```json
{  
   "version":2,
   "titre":"Mr",
   "nom":"LEFRANCAIS",
   "prenom":"Francis"
}
```

##### Suppression d'un médecin

Request : 

 `DELETE  : /tp_jpa/rest/medecin/6`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`


### 2 - Client : 

###Création d'un client : 

Request : 

`POST : /tp_jpa/rest/client`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`

```json
{  
   "version":1,
   "titre":"Mme",
   "nom":"DAVIS",
   "prenom":"Julie"
}
```

##### Récupération de tous les clients

Request : 

 `GET  : /tp_jpa/rest/client/allClients`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`


```json
[  
   {  
      "id":1,
      "version":1,
      "titre":"Mr",
      "nom":"MARTIN",
      "prenom":"Jules"
   },
   {  
      "id":2,
      "version":1,
      "titre":"Mme",
      "nom":"GERMAN",
      "prenom":"Christine"
   },
   {  
      "id":3,
      "version":1,
      "titre":"Mr",
      "nom":"JACQUARD",
      "prenom":"Jules"
   },
   {  
      "id":4,
      "version":1,
      "titre":"Melle",
      "nom":"BISTROU",
      "prenom":"Brigitte"
   },
   {  
      "id":5,
      "version":1,
      "titre":"Mme",
      "nom":"DAVIS",
      "prenom":"Julie"
   }
]
```

##### Récupération d'un client

Request : 

 `GET  : /tp_jpa/rest/client/2`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`


```json
{  
   "id":2,
   "version":1,
   "titre":"Mme",
   "nom":"GERMAN",
   "prenom":"Christine"
}
```


##### Modification d'un client

Request : 

 `PUT  : /tp_jpa/rest/client/5`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`


```json
{  
   "version":2,
   "titre":"Mme",
   "nom":"GEORGES",
   "prenom":"Julie"
}
```

##### Suppression d'un client

Request : 

 `DELETE  : /tp_jpa/rest/client/5`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`



### 3 - Creneau : 

###Création d'un créneau : 

Request : Création d'un créneau par rapport à un médecin

`POST : /tp_jpa/rest/creneau/medecin/2`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`

```json
{  
   "version":1,
   "heuredeb":"9",
   "minutedeb":"0",
   "heurefin":"10",
   "minutefin":"05"
}
```

##### Récupération de tous les créneaux

Request : 

 `GET  : /tp_jpa/rest/creneau/allCreneaux`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`


```json
[  
   {  
      "id":1,
      "version":1,
      "heuredeb":8,
      "heurefin":8,
      "minutedeb":0,
      "minutefin":20,
      "medecin":{  
         "id":1,
         "version":1,
         "titre":"Mme",
         "nom":"PELISSIER",
         "prenom":"Marie"
      }
   },
   .....
{  
   "id":47,
   "version":1,
   "heuredeb":9,
   "heurefin":10,
   "minutedeb":0,
   "minutefin":5,
   "medecin":{  
      "id":2,
      "version":1,
      "titre":"Mr",
      "nom":"BROMARD",
      "prenom":"Jacques"
   }
}
]
```


##### Récupération d'un créneau

Request : 

 `GET  : /tp_jpa/rest/creneau/2`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`


```json
{  
   "id":2,
   "version":1,
   "heuredeb":8,
   "heurefin":8,
   "minutedeb":20,
   "minutefin":40,
   "medecin":{  
      "id":1,
      "version":1,
      "titre":"Mme",
      "nom":"PELISSIER",
      "prenom":"Marie"
   }
}
```

##### Modification d'un créneau

Request : 

 `PUT  : /tp_jpa/rest/creneau/47`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`


```json
{  
   "version":2,
   "heuredeb":"19",
   "minutedeb":"0",
   "heurefin":"20",
   "minutefin":"05"
}
```

##### Suppression d'un créneau

Request : 

 `DELETE  : /tp_jpa/rest/creneau/47`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`



### 4 - RV : 

###Création d'un rv : 

Request : Création d'un rv par rapport à un client et un créneau

`POST : /tp_jpa/rest/rv/client_creneau/2/1`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`

```json
{  
   "jour":"2015-04-04"
}
```

##### Récupération de tous les créneaux

Request : 

 `GET  : /tp_jpa/rest/rv/allRVs`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`


```json
[  
   {  
      "id":1,
      "jour":1156197600000,
      "client":{  
         "id":2,
         "version":1,
         "titre":"Mme",
         "nom":"GERMAN",
         "prenom":"Christine"
      },
      ...
         {  
      "id":7,
      "jour":1428098400000,
      "client":{  
         "id":2,
         "version":1,
         "titre":"Mme",
         "nom":"GERMAN",
         "prenom":"Christine"
      },
      "creneaux":{  
         "id":1,
         "version":1,
         "heuredeb":8,
         "heurefin":8,
         "minutedeb":0,
         "minutefin":20,
         "medecin":{  
            "id":1,
            "version":1,
            "titre":"Mme",
            "nom":"PELISSIER",
            "prenom":"Marie"
         }
      }
   }
]
```

##### Récupération d'un rv

Request : 

 `GET  : /tp_jpa/rest/rv/2`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`

```json
{  
   "id":2,
   "jour":1156284000000,
   "client":{  
      "id":2,
      "version":1,
      "titre":"Mme",
      "nom":"GERMAN",
      "prenom":"Christine"
   },
   "creneaux":{  
      "id":5,
      "version":1,
      "heuredeb":9,
      "heurefin":9,
      "minutedeb":20,
      "minutefin":40,
      "medecin":{  
         "id":1,
         "version":1,
         "titre":"Mme",
         "nom":"PELISSIER",
         "prenom":"Marie"
      }
   }
}
```
Date mis au format "TimeStamp"


##### Modification d'un rv

Request : 

 `PUT  : /tp_jpa/rest/rv/7`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`


```json
{  
   "jour":"2015-04-08"
}
```

##### Suppression d'un créneau

Request : 

 `DELETE  : /tp_jpa/rest/rv/7`

Response :

`HTTP/1.1 200 OK Content-Type: application/json`



Remarque : 

- Pour tester les @POST, @DELETE et @PUT, il faudra ce servir de l'extension chrome Advanced REST client.

#####Utilisation de JPA : 

@Entity :  Classe qui a une table correspondante en base de données.

@Table : Pour dire avec quelle table de ma base je vais lier cette classe

@Id : Id est la clé primaire

@GeneratedValue : Valeur ne dois jamais être défini par nous, c'est la base de données qui l'a génère. Dans notre cas, c'est l'ID

@Column : Pour dire que la colonne de la table se nomme ici, car dans mes attributs je l'ai nommée différemment

@ManyToOne : Pour dire qu'une clé étrangère sera remplacée par un objet du type de la table.

@JoinColumn : Pour dire dans quelle colonne se trouve la clé étrangère.

#####Utilisation de EJB 

@S	tateless : C'est une classe qui va être instanciée part le serveur d'application 

@EJB : La variable, c'est le serveur d'application qui l'instancie








