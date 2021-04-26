# Android-Securii

Securii Password Manager

----

## !! WARNING !!

<img src="https://github.com/andybeardness/Android-Securii/blob/main/imgs/warning.png" height="150">

This app is not for using

I do not recommend using it!

The application was created as an educational

I want to go from idea to release

The author is not responsible for the data

----

## Description

Open source application for storing and generating passwords

With it, you can store and generate complex passwords and add your own

There is support for adding passwords to "Favorites" for quick access

The app does not collect data. Everything is stored only on the device

----

## Screenshots

| Start screen  | Passwords list | Create new password | Show existing password |
| :-------------: | :-------------: | :-------------: | :-------------: |
| ![Start screen](https://github.com/andybeardness/Android-Securii/blob/main/imgs/s1.png)  | ![Start screen](https://github.com/andybeardness/Android-Securii/blob/main/imgs/s4.png)  | ![Start screen](https://github.com/andybeardness/Android-Securii/blob/main/imgs/s3.png)  | ![Start screen](https://github.com/andybeardness/Android-Securii/blob/main/imgs/s2.png)  |

----

## Video preview

Click to play youtube video

⚠️ DANGER :

- _Link is opening at current tab_ 
- _Video contains music_

[![preview](https://img.youtube.com/vi/EzXtsDDeiFM/0.jpg)](https://www.youtube.com/watch?v=EzXtsDDeiFM "https://raw.githubusercontent.com/andybeardness/Android-Securii/main/imgs/MyCollages.png")

----

## Project structure

Packages :

- [Codez](https://github.com/andybeardness/Android-Securii/tree/main/app/src/main/java/com/beardness/securii/Codez) : _Package with help classes to simplify android code_
	- [Factories](https://github.com/andybeardness/Android-Securii/tree/main/app/src/main/java/com/beardness/securii/Codez/Factories) : _Package with differents Factories_
		- [AdapterFactory](https://github.com/andybeardness/Android-Securii/blob/main/app/src/main/java/com/beardness/securii/Codez/Factories/AdapterFactory.java) : _Returns adapters_
		- [ContentValuesFactory](https://github.com/andybeardness/Android-Securii/blob/main/app/src/main/java/com/beardness/securii/Codez/Factories/ContentValuesFactory.java) : _Returns ContentValue objects_
		- [CursorFactory](https://github.com/andybeardness/Android-Securii/blob/main/app/src/main/java/com/beardness/securii/Codez/Factories/CursorFactory.java) : _Returns cursors_
		- [ListenerFactory](https://github.com/andybeardness/Android-Securii/blob/main/app/src/main/java/com/beardness/securii/Codez/Factories/ListenerFactory.java) : _Returns listeners_
		- [ToastFactory](https://github.com/andybeardness/Android-Securii/blob/main/app/src/main/java/com/beardness/securii/Codez/Factories/ToastFactory.java) : _Generates and shows Toasts_
	- [Copier](https://github.com/andybeardness/Android-Securii/blob/main/app/src/main/java/com/beardness/securii/Codez/Copier.java) : _Makes copying to buffer simple_
	- [PassCypher](https://github.com/andybeardness/Android-Securii/blob/main/app/src/main/java/com/beardness/securii/Codez/PassCypher.java) : _Makes cypher password_
	- [RandomJoke](https://github.com/andybeardness/Android-Securii/blob/main/app/src/main/java/com/beardness/securii/Codez/RandomJoke.java) : _Generates jokes on start screen_
- [PasswordGenerator](https://github.com/andybeardness/Android-Securii/tree/main/app/src/main/java/com/beardness/securii/PasswordGenerator) : _Package with class for generating passwords_
	- [PG](https://github.com/andybeardness/Android-Securii/blob/main/app/src/main/java/com/beardness/securii/PasswordGenerator/PG.java) : _Passwords generator_
- [SQLiteTools](https://github.com/andybeardness/Android-Securii/tree/main/app/src/main/java/com/beardness/securii/SQLiteTools) : _Package with self-made class for SQLite_
	- [PasswordDatabase](https://github.com/andybeardness/Android-Securii/blob/main/app/src/main/java/com/beardness/securii/SQLiteTools/PasswordDatabase.java) : _Works with SQLite and have methods for simplify android code_
- [StaticValues](https://github.com/andybeardness/Android-Securii/tree/main/app/src/main/java/com/beardness/securii/StaticValues) : _Package for classes with only static values_
	- [Contacts](https://github.com/andybeardness/Android-Securii/blob/main/app/src/main/java/com/beardness/securii/StaticValues/Contacts.java) : _Static contact values_
