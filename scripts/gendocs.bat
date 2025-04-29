@echo off
setlocal

cd ..

if exist "docs" (
    del docs
)

javadoc -d docs *.java