package com.cenfotec.proyecto.domain;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;




@DynamoDBTable(tableName = "tpaciente")
public class Paciente {

		private String id;
		private String cedula;
	    private String nombre;
	    private String apellido;
	    private Date fechaNacimiento; 
	    
	    @DynamoDBTypeConvertedEnum
	    public enum TipoSangre
		{
			An,Ap,Bn,Bp,On,Op,ABn,ABp 
		}
	    
	    private TipoSangre tipoSangre;
	    
	    @DynamoDBTypeConvertedEnum
	    public enum Genero
		{
			MASCULINO,FEMENINO
		}

	    private Genero genero;
	    
	    private String estadoCivil;
	    private String ocupacion;
	    private String direccion;
	    private String telefono;


	    @DynamoDBHashKey
	    @DynamoDBAutoGeneratedKey
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }
	    
	    @DynamoDBAttribute
	    public String getCedula() {
	        return cedula;
	    }

	    public void setCedula(String cedula) {
	        this.cedula = cedula;
	    }
	    

	    @DynamoDBAttribute
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	    
	    @DynamoDBAttribute
	    public Date getFechaNacimiento() {
	        return fechaNacimiento;
	    }

	    public void setFechaNacimiento(Date fechaNacimiento) {
	        this.fechaNacimiento = fechaNacimiento;
	    }
	    
	    @DynamoDBAttribute
	    public TipoSangre getTipoSangre() {
	        return tipoSangre;
	    }

	    public void setTipoSangre(TipoSangre tipoSangre) {
	        this.tipoSangre = tipoSangre;
	    }
	    
	    @DynamoDBAttribute
	    public Genero getGenero() {
	        return genero;
	    }

	    public void setGenero(Genero genero) {
	        this.genero = genero;
	    }
	    
	    @DynamoDBAttribute
	    public String getEstadoCivil() {
	        return estadoCivil;
	    }

	    public void setEstadoCivil(String estadoCivil) {
	        this.estadoCivil = estadoCivil;
	    }
	    
	    @DynamoDBAttribute
	    public String getOcupacion() {
	        return ocupacion;
	    }

	    public void setOcupacion(String ocupacion) {
	        this.ocupacion = ocupacion;
	    }
	    
	    @DynamoDBAttribute
	    public String getDireccion() {
	        return direccion;
	    }

	    public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }
	    
	    @DynamoDBAttribute
	    public String getTelefono() {
	        return telefono;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }
	    
	    @DynamoDBAttribute
	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	
}
	

	
