# gothic-damage-calculator

Gothic Damage Calculator is a java application with swing GUI used to compare damage output of weapons in Gothic 1, Gothic 2 and Gothic 2 Night of the Raven.

## About Gothic

Gothic is a role-playing video game (RPG) series.

Gothic Damage Calculator only works with the first two games in the series: Gothic 1 (2001) and Gothic 2 (2002) with its expansion pack Night of the Raven (2003), which were developed by Piranha Bytes.

## Using Gothic Damage Calculator

Using GUI elements of the application, user provides following information:
- Game
    - Gothic 1 or Gothic 2 (NotR does not change damage formulas)
- Nameless Hero
    - strength
    - dexterity
    - weapon skill (1H, 2H, bow, crossbow)
- Weapon
    - weapon type (1H/2H/bow/crossbow)
    - damage
    - bonus weapon skill
    - (OPTIONAL) Claw of Beliar lightning damage and hit chance
- Target
    - hitpoints
    - number of hits recieved
    - armor (melee and ranged)

It is only necessary to provide information in input fields with green background, because other information will not affect the results (apart from choosing the game of course).

After clicking on the RUN button, normal, critical and lightning number of hits and damage will be displayed, along with total damage output and target's hitpoints left.

## Screenshot
Screenshot taken right after starting the app. It shows default configuration of the app and GUI layout.

![screenshot](https://github.com/MiltenPlescott/gothic-damage-calculator/blob/master/menu/default_config.jpg)

## Damage formulas

The formulas I used to calculate damage were put together by WernerTWC from worldofplayers.de (World of Gothic) forum.
For more information follow the link to see WernerTWC's original post: [http://forum.worldofplayers.de/forum/threads/127320-Damage-System?p=2198181#post2198181](http://forum.worldofplayers.de/forum/threads/127320-Damage-System?p=2198181#post2198181)
