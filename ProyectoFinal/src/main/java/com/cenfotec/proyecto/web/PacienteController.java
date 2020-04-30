package com.cenfotec.proyecto.web;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.cenfotec.proyecto.domain.Caso;
import com.cenfotec.proyecto.domain.Clinica;
import com.cenfotec.proyecto.domain.Enfermedad;
import com.cenfotec.proyecto.domain.Paciente;
import com.cenfotec.proyecto.repository.CasoRepository;
import com.cenfotec.proyecto.repository.ClinicaRepository;
import com.cenfotec.proyecto.repository.EnfermedadRepository;
import com.cenfotec.proyecto.repository.PacienteRepository;
import com.cenfotec.proyecto.service.CasoServiceImpl;
import com.cenfotec.proyecto.service.ClinicaServiceImpl;
import com.cenfotec.proyecto.service.EnfermedadServiceImpl;
import com.cenfotec.proyecto.service.PacienteServiceImpl;
import com.google.gson.Gson;

@Controller
public class PacienteController {
	DynamoDBMapper dynamoDBMapper;

	@Autowired
	AmazonDynamoDB amazonDynamoDB;

	@Autowired
	PacienteRepository pacienteRepository;
	@Autowired
	CasoRepository casoRepository;
	@Autowired
	ClinicaRepository clinicaRepository;
	@Autowired
	EnfermedadRepository enfermedadRepository;
	
	@Autowired
	PacienteServiceImpl pacienteService;
	@Autowired
	CasoServiceImpl casoService;
	@Autowired
	EnfermedadServiceImpl enfermedadService;
	@Autowired
	ClinicaServiceImpl clinicaService;

	/*
	 * @RequestMapping("/") public String index(Model model) throws ParseException {
	 * 
	 * Paciente pacienteNuevo = new Paciente();
	 * 
	 * //ConectarTabla(pacienteNuevo);
	 * 
	 * 
	 * pacienteNuevo.setNombre("Arturo"); pacienteNuevo.setApellido("Aymerich");
	 * pacienteNuevo.setEstadoCivil("Soltero");
	 * pacienteNuevo.setGenero(Paciente.Genero.MASCULINO);
	 * pacienteNuevo.setDireccion("Escazu Sanjose");
	 * pacienteNuevo.setFechaNacimiento(new Date());
	 * pacienteNuevo.setOcupacion("Ingeniero");
	 * pacienteNuevo.setTelefono("87191177");
	 * pacienteNuevo.setTipoSangre(Paciente.TipoSangre.Op);
	 * 
	 * 
	 * //pacienteNuevo = pacienteService.savePaciente(pacienteNuevo);
	 * 
	 * 
	 * // // String awsServiceId = pacienteNuevo.getId(); // // // //
	 * Optional<Paciente> awsServiceQueried = pacienteService.getById(awsServiceId);
	 * // // if (awsServiceQueried.get() != null) { //
	 * System.out.print("Queried object: " + new
	 * Gson().toJson(awsServiceQueried.get())); // } // // Iterable<Paciente>
	 * awsServices = pacienteRepository.findAll(); // // for (Paciente
	 * awsServiceObject : awsServices) { // System.out.print("List object: " + new
	 * Gson().toJson(awsServiceObject)); // } return "index"; }
	 */
	
	/*
	 * @GetMapping("/paciente") public String mostrarFormularioPaciente(Model model)
	 * { model.addAttribute("paciente", new Paciente()); return "paciente"; }
	 */
	
	/*
	 * @GetMapping("/caso") public String mostrarFormularioCaso(Model model) {
	 * model.addAttribute("caso", new Caso()); model.addAttribute("clinica", new
	 * Clinica()); model.addAttribute("listaclinicas",
	 * clinicaService.getAllClinicas()); model.addAttribute("enfermedad", new
	 * Clinica()); model.addAttribute("listaenfermedades",
	 * enfermedadService.getAllEnfermedades()); return "caso"; }
	 * 
	 * @GetMapping("/enfermedad") public String mostrarFormularioEnfermedad(Model
	 * model) { model.addAttribute("enfermedad", new Enfermedad()); return
	 * "enfermedad"; }
	 * 
	 * @GetMapping("/clinica") public String mostrarFormularioClinica(Model model) {
	 * model.addAttribute("clinica", new Clinica()); return "clinica"; }
	 */
	
	@RequestMapping("/paciente")
	public Paciente guardarPaciente(@RequestBody Paciente nuevoPaciente) {
		return pacienteService.savePaciente(nuevoPaciente);
		 
	}
	@RequestMapping("/index")
	public Caso guardarCaso(@RequestBody Caso nuevoCaso) {
		return casoService.saveCaso(nuevoCaso);
		 
	}
	@RequestMapping("/nuevoProducto")
	public Enfermedad guardarEnfermedad(@RequestBody Enfermedad nuevaEnfermedad) {
		return enfermedadService.saveEnfermedad(nuevaEnfermedad);
		
	}
	@RequestMapping("/listaProductos")
	public Clinica guardarClinica(@RequestBody Clinica nuevaClinica) {
		return clinicaService.saveClinica(nuevaClinica);
		 
	}

	@RequestMapping(value="/paciente/all", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody List<Paciente> obtenerPacientes(Model model){		
		return pacienteService.getAllPacientes(); 	
	}
	
	@RequestMapping(value="/caso/all", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody List<Caso> obtenerCasos(Model model){		
		return casoService.getAllCasos(); 	
	}
	
	@RequestMapping(value="/enfermedad/all", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody List<Enfermedad> obtenerEnfermedades(Model model){		
		return enfermedadService.getAllEnfermedades(); 	
	}
	
	@RequestMapping(value="/clinica/all", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody List<Clinica> obtenerClinicas(Model model){		
		return clinicaService.getAllClinicas(); 	
	}
	
	@PutMapping(value = "/paciente/{id}")
	public ResponseEntity<Paciente> updatePaciente(@PathVariable("id") String id, @RequestBody Paciente paciente) {
		return pacienteService.getById(id).map(record -> {
			record.setEstadoCivil(paciente.getEstadoCivil());
			record.setOcupacion(paciente.getOcupacion());
			record.setDireccion(paciente.getDireccion());
			record.setTelefono(paciente.getTelefono());
			Paciente updated = pacienteService.savePaciente(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "/caso/{id}")
	public ResponseEntity<Caso> updateCaso(@PathVariable("id") String id, @RequestBody Caso caso) {
		return casoService.getById(id).map(record -> {
			record.setClinica(caso.getClinica());
			record.setSintomas(caso.getSintomas());
			record.setEstado(caso.getEstado());
			Caso updated = casoService.saveCaso(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "/enfermedad/{id}")
	public ResponseEntity<Enfermedad> updateEnfermedad(@PathVariable("id") String id, @RequestBody Enfermedad enfermedad) {
		return enfermedadService.getById(id).map(record -> {
			record.setTipo(enfermedad.getTipo());
			record.setMedicamento(enfermedad.getMedicamento());
			Enfermedad updated = enfermedadService.saveEnfermedad(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "/clinica/{id}")
	public ResponseEntity<Clinica> updateClinica(@PathVariable("id") String id, @RequestBody Clinica clinica) {
		return clinicaService.getById(id).map(record -> {
			record.setDireccion(clinica.getDireccion());
			Clinica updated = clinicaService.saveClinica(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/paciente/{id}" })
	public ResponseEntity<?> deletePaciente(@PathVariable("id") String id) {
		return pacienteService.getById(id).map(record -> {
			pacienteService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = { "/caso/{id}" })
	public ResponseEntity<?> deleteCaso(@PathVariable("id") String id) {
		return casoService.getById(id).map(record -> {
			casoService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = { "/enfermedad/{id}" })
	public ResponseEntity<?> deleteEnfermedad(@PathVariable("id") String id) {
		return enfermedadService.getById(id).map(record -> {
			enfermedadService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = { "/clinica/{id}" })
	public ResponseEntity<?> deleteClinica(@PathVariable("id") String id) {
		return clinicaService.getById(id).map(record -> {
			clinicaService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public void ConectarTabla(Object entidad) {


		dynamoDBMapper=new DynamoDBMapper(amazonDynamoDB);
		
		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(entidad.getClass());
	
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L,1L));
	
		TableUtils.createTableIfNotExists(amazonDynamoDB,tableRequest);
	}

}
