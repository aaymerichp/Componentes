package com.cenfotec.proyecto.domain;

import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@DynamoDBTable(tableName = "tcaso")
public class Caso {

		private String id;
	    private String paciente;
	    private String enfermedad;
	    private String clinica; 
	    private Date fecha;
	    private String sintomas;
	    private String estado;
	    
	    
	    @DynamoDBHashKey
	    @DynamoDBAutoGeneratedKey
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    @DynamoDBAttribute
	    public String getPaciente() {
	        return paciente;
	    }

	    public void setPaciente(String paciente) {
	        this.paciente = paciente;
	    }
	    
	   
	    @DynamoDBAttribute
	    public String getEnfermedad() {
	        return enfermedad;
	    }

	    public void setEnfermedad(String enfermedad) {
	        this.enfermedad = enfermedad;
	    }	 
	    
	    @DynamoDBAttribute
	    public String getClinica() {
	        return clinica;
	    }

	    public void setClinica(String clinica) {
	        this.clinica = clinica;
	    }
	    
	    @DynamoDBAttribute
	    public Date getFecha() {
	        return fecha;
	    }

	    public void setFecha(Date fecha) {
	        this.fecha = fecha;
	    }	   
	    
	    @DynamoDBAttribute
	    public String getSintomas() {
	        return sintomas;
	    }

	    public void setSintomas(String sintomas) {
	        this.sintomas = sintomas;
	    }
	    
	    @DynamoDBAttribute
	    public String getEstado() {
	        return estado;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }
	
}
	

	
