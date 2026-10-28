@echo off
cd /d "%~dp0"

if not exist out mkdir out

dir /s /b src\*.java > sources.txt

javac --module-path "C:\Users\Cesar\javafx-sdk-27\lib" --add-modules javafx.controls,javafx.media -d out @sources.txt

if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

java --module-path "C:\Users\Cesar\javafx-sdk-27\lib" --add-modules javafx.controls,javafx.media --enable-native-access=javafx.graphics -Djava.library.path="C:\Users\Cesar\javafx-sdk-27\bin" -cp out ChessTester

pause