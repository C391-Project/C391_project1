## Radiology App - Radiology Information System
---
###The Application

This application is a simple Radiology Information System (RIS) that provides a computer information system that stores and processes the information for a radiology lab, including all the data regarding patients, and all medical images generated by various diagnostic and therapeutic equipments. The system is complemented with a Picture Archiving and Communication System (PACS) and provides a 3 tier system which is separated by the database server, the web server, and clients are running on different computer systems that are connected via the Internet.

---
###Installation Guide

1. git clone this repo or unpackage the "project.tgz" file
2. In your terminal execute "cd RadiologyApp"
3. In your terminal execute "make"
4. In your terminal execute "make install" (assumes your catalina folder is saved in your home directory).
5. In your terminal exectue "starttomcat" (on a lab machine) or simply start your tomcat server and navigate to [your-server]/RadiologyApp

---
###Licence 
  

    Radiology App has been programmed by James Devito, Cheng Chen,and Brett Commandeur
    Copyright (C) 2015 James Devito, Cheng Chen, Brett Commandeur  

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
