@echo off
setlocal
cd /d "%~dp0"
set "JAVAFX_LIB=C:\Users\Cesar\javafx-sdk-27\lib"
if not exist "%JAVAFX_LIB%" (
  echo Update JAVAFX_LIB in this script to your JavaFX SDK lib directory.
  pause
  exit /b 1
)
if not exist docs\api mkdir docs\api
javadoc -Xdoclint:none --module-path "%JAVAFX_LIB%" --add-modules javafx.controls,javafx.media -sourcepath src -d docs\api src\App.java src\ChessTester.java -subpackages includes.chessBoard:includes.chessPieces
if errorlevel 1 (
  echo Javadoc generation reported errors. Review the output above.
  pause
  exit /b 1
)
echo Javadoc generated in docs\api. Open docs\api\index.html.
pause
