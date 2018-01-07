# Logisim Fork ITA
Logisim is a digital circuit simulator, [originally available here](http://www.cburch.com/logisim/).<br><br>
This is an italian fork based on the original Logisim version.<br>
<b>[DOWNLOAD BUTTON AND CHANGELOG](http://logisim.altervista.org)</b><br>
<b>[CONTACT US](http://logisim.altervista.org/contacts.html)</b><br>
<b>[PLUGINS](http://logisim.altervista.org/plugins.html)</b><br>
<b>[USER TUTORIALS](http://logisim.altervista.org/userstutorial.php)</b><br>
<b>[DEVS TUTORIALS](http://logisim.altervista.org/developerstutorial.php)</b><br>
## Changelog
* Italian translation!
* Possibility to use french translations already done (not very well)
* Autoupdates!
* Compiled with Java 9
* New components:
	* TTL gates (7400, 7402, 7404, 7408, 7432, 7447, 7485, 7486, 74165, 74283, 747266)
	* I/O->Digital Oscilloscope
	* I/O->Switch
	* I/O->Dip Switch
	* I/O->RGB LED
	* Memory->PLA ROM
	* Plexers->7-Segment Display Decoder
* New FF layout and attributes
* FF D, S-R: Latch option in trigger list
* Controlled Buffer / Inverter: Negate Control Input attribute
* Added Sel pin in Register component
* Added Sel Active Level attribute in components with Sel pin
* Press ESC or DEL to cancel "Add Tool" action, F1 opens Library Reference
* TTY and Keyboard components can use 16-bit values (UTF-16)
* Clock custom frequency
* Joystick facing attribute
* Added missing tooltips
* Zoom in and out using mouse wheel where you're pointing at
* Big fixes to Log menu and Log output file, added buttons to clear Log Table
* Added Label Color attribute for each component with Label attribute
* Increased output limit in Analyze Circuit to 32
* Analyze Circuit should calculate table/expression with any kind of component
* Fixed empty template bug introduced in Logisim 2.7.0
* Fixed input positions in wide gates with 4 inputs
* Changed some default value
* Anti Aliasing, Look and Feel and Fill Component's Background preference
* Graphical changes
* Includes some fix from original early version 2.7.2.255
## Bugs
* PLA ROM doesn't save configurations in .circ and its logic is not calculated in Analyze Circuit
* All the original Logisim's bugs we haven't fixed yet
## Features we want to add
* Solve propagation bugs not solved in the original Logisim
* Programmable Generator (95% done)
* Buzzer (75% done)
* Add a new type of library
* Draw also in circuits
* Suggest us everything at logisimit@gmail.com
## Retro-compatibility
Due to a bug in the original Logisim, wide gates with 4 inputs had a bad positioning of the ports.
I fixed this problem but if you open an old file containig gates with those attributes, its inputs will be disconnected and a warning message will appear
## EXE and JAR downloads + microprocessor project
All in our website [here](http://logisim.altervista.org)
## How to compile & use
Watch our tutorials on "TUTORIAL" section of our [website](http://logisim.altervista.org/developerstutorial.php)
## Translation
New strings are translated really bad (Google Translate) because i just know Italian and English.<br>You can help me translating other languages or adding a new one, if you want so, contact me at logisimit@gmail.com
