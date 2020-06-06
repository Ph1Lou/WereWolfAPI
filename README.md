# Plugin LG UHC API

Une API pour intéragir avec le plugin de LG UHC By Ph1Lou

## Getting Started

Cette API a pour but d'être intégré dans un plugin tournant dans la même jvm que le plugin lg uhc. Cette API permet d'intéragir avec le plugin.

### Prerequisites
Vous aurez besoin du plugin lg uhc en version snapshot 1.15 dernière version en cours. Cette version est disponible sur mon discord en demandant le rôle Snapshot viewer.



### Installing

# Installation via maven :

Dans votre Pom :

```
<repositories>
	<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
	</repository>
</repositories>
 
 
<dependency>
	<groupId>com.github.Ph1Lou</groupId>
	<artifactId>pluginlgapi</artifactId>
	<version>Tag</version>
</dependency>

```

# Numero de version ici :

<https://jitpack.io/#Ph1Lou/pluginlgapi>

### Premiers pas

Dans le plugin.yml de votre plugin, rajoutez la ligne :
```
depend : [pluginLG]
```

Depuis votre plugin Spigot, dans votre IDE préférée pour récuperer le premier objet de l'API

```
GetWereWolfAPI ww = (GetWereWolfAPI) Bukkit.getPluginManager().getPlugin("pluginLG");
```

### Pour enregistrer vos textes en Nested Json pour y accéder depuis le WereWolfAPI#translate

## 1ère étape

Dans le dossier ressource crée un fichier config.yml avec 
```
lang : fr 
```

## 2ème étape

Dans votre onEnable() :
```
ww.loadTranslation(this,"fr");
```
Ici mon fichier de langue s'appelle fr.json. Il doit être stocké dans le dossier ressource du projet

### Pour créer vos rôles

## 1ère étape 

créez une nouvelle classe, elle devra implémenter Roles, Cloneable et Listener
```
public class RoleExample implements Roles, Listener,Cloneable {
```

## 2ème étape

le constructeur devra obligatoirement être de la forme suivante :
 
```
public RoleExample(GetWereWolfAPI main, WereWolfAPI game, UUID uuid) 
```

## 3ème étape

Vous pouvez maintenant travailler avec votre classe. Vous pouvez écouter tous les listeners spigot + ceux de l'api

Je vous conseille de copier coller les fonctions de la classe du rôle exemple pour ne pas avoir à y refaire.

# Rôle Exemple

<https://github.com/Ph1Lou/addRoleExample>



### Pour enregistrer vos rôles

## 1ère étape

Remarque : vos rôles ne pourront être enregistrés que lorsque le plugin s'initialise (dans le onEnabled)

```
ww = (GetWereWolfAPI) Bukkit.getPluginManager().getPlugin("pluginLG");

try {
    RoleRegister exampleRole = new RoleRegister(ww,"werewolf.role.role_example.display").registerRole(RoleExample.class);
    exampleRole.setLore(Arrays.asList("§fRole Example","§fFait par §bPh1Lou")).addCategory(Category.ADDONS).create();
} catch (NoSuchMethodException e) {
    e.printStackTrace();  
}               
```
## 2ème étape

Votre clef doit correspondre à votre fichier de langue fr.json dans le dossier ressource , dans le cas ci dessus :
```
{
  "werewolf": {
              "role": {
                      "role_example" : {
                                      "display" : "Role Exemple"
                                        }
                      }
              }
}
```




## Authors

* **Ph1Lou* - *Initial work* - [PurpleBooth](https://github.com/Ph1Lou)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details



