package edu.robertob.p1compi1.Lexer;

/*
* <PROYECTO nombre="proy-name">
	<ARCHIVO nombre=”nombre” ubicacion=”/home/.../…./.../miarchivo.csv”/>
	<CARPETA nombre=”CARPETA”>
	<ARCHIVO nombre=”nombre1” ubicacion=”/home/.../…./.../miarchivo1.csv”/>
	<ARCHIVO nombre=”nombre2” ubicacion=”/home/.../…./.../miarchivo2.csv”/>
	</CARPETA>
</PROYECTO>
*/
public enum Token {
    TAG_OPEN, // <
    TAG_CLOSE, // >
    TAG_CLOSE_REVERSE, // </
    TAG_SELF_CLOSE, // />
    TAG_NAME_PROJECT, // PROYECTO
    TAG_NAME_FILE, // ARCHIVO
    TAG_NAME_FOLDER, // CARPETA
    TAG_ATTRIBUTE_NAME, // nombre
    TAG_ATTRIBUTE_LOCATION, // ubicacion
    TAG_ATTRIBUTE_VALUE, // proy-name, /home/.../…./.../miarchivo.csv
    EQUALS, // =
    QUOTE, // "
    ILLEGAL, // caracteres no permitidos
    EOF, // fin de archivo

}
