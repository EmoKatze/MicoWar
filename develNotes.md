Developer's Notes
==================

Game specification
------------------

Turn:
- choose which unit to perform an action on with cursor
- choose between move, attack and defensive action
- you have 2 AP per Turn

Attacking:
- Attacks knock units back x tiles (!)
- this way, no stupid bashing back and forth could happen


Tile: <br />
- 16px * 16px <br />
- has Ground Type which limits movement <br />
- Units can stand on

Game Field: <br />
- 8 Tiles * 8 Tiles (128px * 128px Display is filled)

Unit: <br />
- consists of Arms, Legs and Chest

Arms: <br />
- Specify the attack and defensive moves the unit can use

Legs: <br />
- Specify the movement type (flying, water, tires, by foot) and movement length

Chest: <br />
- Specify the ability (x turns cooldown after usage) e.g. healing, explosion

Hardware für Gameboy
--------------------
Rapsberry Pi vs Microcontroller ? @emokatze


Possible RbPi Zero: <br />
- 10-20€ (Kabel usw) <br />
- 1Gb Ram <br />
- SD-Karten speicher <br />


Possible MC Processor: esp32,
Vorteile Microcontroller? (abgesehen davon dass wir es für die vorlesung eh machen müssen)