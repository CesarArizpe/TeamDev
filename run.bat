@echo off

javac --module-path "C:\Users\Cesar\javafx-sdk-27\lib" --add-modules javafx.controls,javafx.media -d out src\App.java

java --module-path "C:\Users\Cesar\javafx-sdk-27\lib" --add-modules javafx.controls,javafx.media --enable-native-access=javafx.graphics -Djava.library.path="C:\Users\Cesar\javafx-sdk-27\bin" -cp out App

pause