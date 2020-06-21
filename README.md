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

Dans le plugin.yml de votre plugin, rajoutez les lignes :
```
load: STARTUP
depend : [pluginLG]
```

Depuis votre plugin Spigot, dans votre IDE préférée pour récuperer le premier objet de l'API

```
GetWereWolfAPI ww = (GetWereWolfAPI) Bukkit.getPluginManager().getPlugin("WereWolfPlugin");
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

créez une nouvelle classe, elle devra extends de RolesImpl (ou RoleVillage, RoleNeutral, RoleWereWolf ou RoleWithSelection... en fonction du camp de votre Rôle)
```
public class RoleExample extends RolesImpl {
```

## 2ème étape

dans le dossier ressource du plugin créer un fichier stuffMeetUp.yml et stuffRole.yml
 
Puis dans le onEnable
```
ww.getAddonsList().add(this);
```

Cela permet de gérer le Stuff du rôle

## 3ème étape

Vous pouvez maintenant travailler avec votre classe. Vous pouvez écouter tous les listeners spigot + ceux de l'api

Je vous conseille de lire la documentation pour découvrir tous les events disponibles.

# Rôle Exemple

<https://github.com/Ph1Lou/addRoleExample>



### Pour enregistrer vos rôles

## 1ère étape

Remarque : vos rôles ne pourront être enregistrés que lorsque le plugin s'initialise (dans le onEnabled)

```
ww = (GetWereWolfAPI) Bukkit.getPluginManager().getPlugin("pluginLG");

try {
    RoleRegister exampleRole = new RoleRegister(this,ww,"werewolf.role.role_example.display").registerRole(RoleExample.class);
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

## 3ème étape

Pour enregistrer du stuff
Dans vos .yml mettez :

```
"werewolf.role.protector.display":
  '0':
    ==: org.bukkit.inventory.ItemStack
    type: POTION
    damage: 16389
    amount: 3
 '1': etc...
```

le StuffRole sera chargé par défault et le MeetUp lors de l'appuie sur le bouton MeetUp dans le Menu


### Pour enregistrer une commande

## 1ère étape créer une classe Command qui implémente Commands 
```
public class Comman implements Commands 
```

## 2ème étape

l'enregistrer dans le onEnable
```
ww.getListCommands().put("macommande",new Command(ww));
```

## Authors

* **Ph1Lou* - *Initial work* - [PurpleBooth](https://github.com/Ph1Lou)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details



