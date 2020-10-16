package Constantes;

public abstract class ConsultasSQL {

	
	protected final String TABLAUSUARIO = "create table  if not exists Alumno(\r\n"
    		+ "	NumMatricula varchar(15) unique NOT NULL primary key,\r\n"
    		+ "    Nombre varchar(30),\r\n"
    		+ "    FechaNacimiento date,\r\n"
    		+ "    Telefono varchar (15)\r\n"
    		+ ");";
	protected final String TABLAASIGNATURA = "create table  if not exists Asignatura(\r\n"
    		+ "	CodAsignatura varchar(10) primary key,\r\n"
    		+ "    Nombre varchar(15),\r\n"
    		+ "    IdProfesor varchar(15)\r\n"
    		+ ");";
	protected final String TABLAPROFESOR = "create table if not exists Profesor(\r\n"
    		+ "	IdProfesor varchar(10) primary key,\r\n"
    		+ "    NIF_P varchar(15),\r\n"
    		+ "    Nombre varchar(20),\r\n"
    		+ "    Especialidad varchar(20),\r\n"
    		+ "    Telefono varchar(15)\r\n"
    		+ ");";
	protected final String TABLARECIBE = "create table if not exists Recibe(\r\n"
    		+ "	NumMatricula varchar(20),\r\n"
    		+ "    CodAsignatura varchar(10),\r\n"
    		+ "    CursoEscolar varchar(10),\r\n"
    		+ "    primary key (NumMatricula,CodAsignatura)\r\n"
    		+ ");";
	protected final String FK_NMATRRICULA="alter table Recibe add foreign key (Nummatricula) references Alumno (NumMatricula);";
	protected final String FK_CODASING="alter table Recibe add foreign key (CodAsignatura) references Asignatura (CodAsignatura);";
	protected final String FK_IDPROF="alter table Asignatura add foreign key (IdProfesor) references Profesor (IdProfesor);";
	//contantes consultas parte 2 localidad provincia region
	protected final String TABLAEMPLEADO="create table if not exists Empleado(\r\n"
    		+ "	ID int primary key,\r\n"
    		+ "    DNI varchar(20),\r\n"
    		+ "    FechaNac date,\r\n"
    		+ "    Telefono varchar(20),\r\n"
    		+ "    Salario int,\r\n"
    		+ "    CodLocalidad varchar(20)\r\n"
    		+ ");";
	protected final String TABLALOCALIDAD="create table if not exists Localidad(\r\n"
    		+ "	CodLocalidad varchar(20) primary key,\r\n"
    		+ "    Nombre varchar(20),\r\n"
    		+ "    CodProvincia varchar(10)\r\n"
    		+ ");";
	protected final String TABLAPROVINCIA="create table if not exists Provincia(\r\n"
    		+ "	CodProvincia varchar(10) primary key,\r\n"
    		+ "    Nombre varchar(20),\r\n"
    		+ "    CodRegion varchar(10)\r\n"
    		+ ");";
	protected final String TABLAREGION="create table if not exists Region(\r\n"
    		+ "	CodRegion varchar(10) primary key,\r\n"
    		+ "    Nombre varchar(20)\r\n"
    		+ ");";
	protected final String FK_CODLOCALIDAD="alter table Empleado add foreign key (CodLocalidad) references Localidad (CodLocalidad);";
	protected final String FK_CODPROVINCIA="alter table Localidad add foreign key (CodProvincia) references Provincia (CodProvincia);";
	protected final String FK_CODREGION="alter table Provincia add foreign key (CodRegion) references Region (CodRegion);";
}
