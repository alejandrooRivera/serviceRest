package com.javarevolutions.rest.service;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.javarevolutions.rest.utils.Utils;
import com.javarevolutions.rest.vo.VOPersona;

@Path("/JavaRevolutions")
public class ServicePersonaJR {

	
	@POST  ///TIPO DE PETICION
	@Path("/ValidaPersona") ///NOMBRE DEL METODO PARA LLAMAR
	@Consumes({MediaType.APPLICATION_JSON}) //QUE TIPO DEBE RECIBIR
	@Produces({MediaType.APPLICATION_JSON}) //QUE TIPO VA A RETORNAR
	public VOPersona ValidaPersona(@HeaderParam("user") String user,@HeaderParam("pass")String pass,  VOPersona vopersona) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		System.out.println("User: "+user+"Pass: "+pass);
		String token= Utils.getSHA256(user+pass);
		System.out.println("Token Generado: "+token);
		
		
		
		 if (vopersona.getNombre().equals("humberto") && vopersona.getApellido().equals("uriel")){
			 
			 vopersona.setTelefono("valido");
		 }
		 return vopersona;
		
	}
}
