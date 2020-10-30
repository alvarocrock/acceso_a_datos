package main;

public class contantes {
	
	static String CONTROLADOR = "com.mysql.jdbc.Driver";
    static String URL = "jdbc:mysql://localhost:3306/practica_autocommit?allowPublicKeyRetrieval=true&useSSL=false";
    static String USUARIO = "usuario";
    static String CLAVE = "usuario";
    
    
    static String TABLAUSUARIO = "create table  if not exists Alumno(\r\n"
    		+ "	NumMatricula varchar(15) unique NOT NULL primary key,\r\n"
    		+ "    Nombre varchar(30),\r\n"
    		+ "    FechaNacimiento date,\r\n"
    		+ "    Telefono varchar (15)\r\n"
    		+ ");";
    static String TABLAASIGNATURA = "create table  if not exists Asignatura(\r\n"
    		+ "	CodAsignatura char(10) primary key,\r\n"
    		+ "    Nombre varchar(50),\r\n"
    		+ "    IdProfesor int\r\n"
    		+ ");";
    static String TABLAPROFESOR = "create table if not exists Profesor(\r\n"
    		+ "	IdProfesor int AUTO_INCREMENT primary key,\r\n"
    		+ "    NIF_P varchar(15),\r\n"
    		+ "    Nombre varchar(20),\r\n"
    		+ "    Especialidad varchar(20),\r\n"
    		+ "    Telefono varchar(15)\r\n"
    		+ ");";
    static String TABLARECIBE = "create table if not exists Recibe(\r\n"
    		+ "	NumMatricula varchar(20),\r\n"
    		+ "    CodAsignatura varchar(10),\r\n"
    		+ "    CursoEscolar varchar(10),\r\n"
    		+ "    primary key (NumMatricula,CodAsignatura)\r\n"
    		+ ");";
    static String FK_NMATRRICULA="alter table Recibe add foreign key (Nummatricula) references Alumno (NumMatricula);";
    static String FK_CODASING="alter table Recibe add foreign key (CodAsignatura) references Asignatura (CodAsignatura);";
    static String FK_IDPROF="alter table Asignatura add foreign key (IdProfesor) references Profesor (IdProfesor);";

}
