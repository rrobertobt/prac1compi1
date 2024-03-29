#!/usr/bin/env bash
# shellcheck disable=SC2059

# Color variables
BOLD="\033[1m"
UNDERLINE="\033[4m"
RESET="\033[0m"

GREEN="\033[32m"
RED="\033[31m"
BLUE="\033[34m"
YELLOW="\033[33m"

printf "\n"
printf "${UNDERLINE}${BOLD}[SCRIPT] MOVING TO DIRECTORY...${RESET} \n"
printf "${BOLD}${GREEN}$ cd ~/NetBeansProjects/p1compi1/${RESET} \n"
cd ~/NetBeansProjects/p1compi1/
pwd

printf "\n${UNDERLINE}${BOLD}${BLUE}[FLEX] STARTING JFLEX COMPILING...${RESET} \n"
printf "${BOLD}${GREEN}$ jflex -d src/main/java/edu/robertob/p1compi1/InputFileHandle src/main/resources/edu/robertob/p1compi1/InputFileLexer.flex${RESET}\n\n"

jflex -d src/main/java/edu/robertob/p1compi1/InputFileHandle src/main/resources/edu/robertob/p1compi1/InputFileLexer.flex

printf "\n${UNDERLINE}${BOLD}${YELLOW}[CUP] STARTING CUP COMPILING...${RESET} \n"
printf "${BOLD}${GREEN}$ java -jar ~/.bin/java-cup-11b.jar -destdir "./src/main/java/edu/robertob/p1compi1/InputFileHandle" -parser InputFileParser ./src/main/resources/edu/robertob/p1compi1/InputFileParser.cup${RESET}\n\n"
#printf "${BOLD}${GREEN}$ java -jar ~/.bin/java-cup-11b.jar -parser InputFileParser src/main/resources/edu/robertob/p1compi1/InputFileParser.cup${RESET}\n\n"

#java -jar ~/.bin/java-cup-11b.jar -parser InputFileParser src/main/resources/edu/robertob/p1compi1/InputFileParser.cup
java -jar ~/.bin/java-cup-11b.jar -destdir "./src/main/java/edu/robertob/p1compi1/InputFileHandle" -parser InputFileParser ./src/main/resources/edu/robertob/p1compi1/InputFileParser.cup
printf "\n${UNDERLINE}${BOLD}${YELLOW}[CUP] MOVING GENERATED CUP FILES...${RESET} \n"





#echo "[FLEX] FINISHED JFLEX COMPILING, MOVING FILES TO JAVA DIRECTORY:"
#mv ~/NetBeansProjects/p1compi1/src/main/resources/edu/robertob/p1compi1/InputFileLexer.java ~/NetBeansProjects/p1compi1/src/main/java/edu/robertob/p1compi1/Lexer/InputFileLexer.java