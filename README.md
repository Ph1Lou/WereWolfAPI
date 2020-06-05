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
https://jitpack.io/#Ph1Lou/pluginlgapi
```

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

Votre clef doit correspondre à votre fichier de langue , dans le cas ci dessus :
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


# Rôle Exemple
```
https://github.com/Ph1Lou/addRoleExample
```

## Authors

* **Ph1Lou* - *Initial work* - [PurpleBooth](https://github.com/Ph1Lou)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details



