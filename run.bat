@echo off cd /d "%~dp0" if not exist out mkdir out

javac --module-path "C:\Users\Cesar\javafx-sdk-27\lib" --add-modules javafx.controls,javafx.media -d out src\App.java src\ChessTester.java src\includes\chessBoard\ChessBoard.java src\includes\chessBoard\GridSpace.java src\includes\chessPieces\Piece.java

if errorlevel 1 goto error

java --module-path "C:\Users\Cesar\javafx-sdk-27\lib" --add-modules javafx.controls,javafx.media --enable-native-access=javafx.graphics -Djava.library.path="C:\Users\Cesar\javafx-sdk-27\bin" -cp out App

pause exit /b

:error echo Compilation failed. pause