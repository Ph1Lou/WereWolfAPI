# Plugin LG UHC API


[![](https://javadoc.jitpack.io/v/Ph1Lou/WereWolfAPI.svg)](https://javadoc.jitpack.io/#Ph1Lou/WereWolfAPI)

Une API pour intéragir avec le plugin de LG UHC By Ph1Lou

# Java-Doc
<https://javadoc.jitpack.io/com/github/Ph1Lou/WereWolfAPI/master-SNAPSHOT/javadoc/>

## Getting Started

Cette API a pour but d'être intégré dans un plugin tournant dans la même jvm que le plugin lg uhc. Cette API permet d'intéragir avec le plugin.

### Prerequisites
Vous aurez besoin du plugin lg uhc en version snapshot 1.5 dernière version en cours. Cette version est disponible sur mon discord en demandant le rôle Snapshot viewer.

**Vous devez connaitre le Java, l'api Spigot et Maven avant de commencer à faire un addon.**

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
	<artifactId>werewolfapi</artifactId>
	<version>master-SNAPSHOT</version>
</dependency>

```

# Numero de version ici :

<https://javadoc.jitpack.io/#Ph1Lou/WereWolfAPI>

### Premiers pas

Dans le plugin.yml de votre plugin, rajoutez les lignes :
```
load: STARTUP
depend : [WereWolfPlugin]
```
le plugin WereWolfPlugin démarre aussi AU STARTUP (càd avant la génération du World) il faut donc charger l'addon lors de cette phase aussi.
la 2èm ligne permet d'attendre que le plugin WereWolfPlugin se charge avant votre addon et éviter à l'addon de se charger si le plugin n'est pas présent.


Depuis votre plugin Spigot, dans votre IDE préférée pour récuperer le premier objet de l'API ( dans le onEnable )

```
GetWereWolfAPI ww = getServer().getServicesManager().load(GetWereWolfAPI.class);
```

### Pour enregistrer votre addons

```
RegisterManager registerManager = ww.getRegisterManager();
String addonKey = "werewolf.nom_de_votre_addon.un_nom_unique":

registerManager.registerAddon(new AddonRegister(addonKey,
                "fr",
                this));	
```

Ici mon fichier de langue par défault s'appelle fr.json. Il doit être stocké dans le dossier ressource du projet c'est le fichier qui est chargé par défault si la langue demandée n'existe pas. Il peut y avoir plusieurs .json, mais il suffit de faire qu'un seul loadTranslation avec la langue par défault

Votre addonKy doit correspondre à votre fichier de langue fr.json dans le dossier ressource , dans le cas ci dessus :
```
{
  "werewolf": {
              "nom_de_votre_addon": {
                      "un_nom_unique" : "Un nom unique"
                      }
              }
}

```
La valeur associée à l'addonKey sera le nom de l'Addon. L'addonKey doit être **unique**, deux addons ne doivent pas avoir la même.

### Pour créer vos rôles

## 1ère étape 

créez une nouvelle classe, elle devra extends de RoleVillage (ou RoleNeutral, RoleWereWolf ou RoleWithSelection... en fonction du camp de votre Rôle)
```
public class RoleExample extends RolesImpl {
```

## 2ème étape

Vous pouvez maintenant travailler avec votre classe. Vous pouvez écouter tous les listeners spigot + ceux de l'api

Je vous conseille de lire la documentation pour découvrir tous les events disponibles.

# Rôle Exemple

<https://github.com/Ph1Lou/addRoleExample>



### Pour enregistrer vos rôles

## 1ère étape

Remarque : vos rôles ne pourront être enregistrés que lorsque le plugin s'initialise (dans le onEnabled)

```
GetWereWolfAPI ww = getServer().getServicesManager().load(GetWereWolfAPI.class);
RegisterManager registerManager = ww.getRegisterManager();
String addonkey = "une.clef.unique":

try {
    registerManager
                    .registerRole(new RoleRegister(addonKey,
                            "werewolf.role.le_nom_de_votre_role.display",
                            VotreRole.class)
                            .addCategory(Category.ADDONS));
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
                      "le_nom_de_votre_role" : {
                                      "display" : "Role Exemple"
                                        }
                      }
              }
}
```

## 3ème étape

Pour enregistrer du stuff dans le dossier ressource du plugin créer un fichier stuffMeetUp.yml et stuffRole.yml
Dans vos .yml mettez (par exemple) :

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
registerManager.registerCommands(new CommandRegister(addonKey, "key_de_votre_role, new CommandDeVotreRole(ww));
```

## Authors

* **Ph1Lou* - *Initial work* - [PurpleBooth](https://github.com/Ph1Lou)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details



