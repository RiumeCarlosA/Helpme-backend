package br.com.riume.helpme.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.riume.helpme.enums.Perfil;
import br.com.riume.helpme.enums.Prioridade;
import br.com.riume.helpme.enums.Status;
import br.com.riume.helpme.model.Chamado;
import br.com.riume.helpme.model.Cliente;
import br.com.riume.helpme.model.Tecnico;
import br.com.riume.helpme.repository.ChamadoRepository;
import br.com.riume.helpme.repository.ClienteRepository;
import br.com.riume.helpme.repository.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Riume Carlos", "1234567892", "riumecarlos@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus troval", "9876543219", "troval@gmail.com", "123");
		cli1.addPerfil(Perfil.CLIENTE);
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}