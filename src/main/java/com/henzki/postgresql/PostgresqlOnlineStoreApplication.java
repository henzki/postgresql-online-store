package com.henzki.postgresql;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.henzki.postgresql.model.Asiakas;
import com.henzki.postgresql.repo.AsiakasRepository;
import com.henzki.postgresql.model.Tilaus;
import com.henzki.postgresql.repo.TilausRepository;
import com.henzki.postgresql.model.Tilausrivi;
import com.henzki.postgresql.repo.TilausriviRepository;
import com.henzki.postgresql.model.Tuote;
import com.henzki.postgresql.repo.TuoteRepository;

@SpringBootApplication
public class PostgresqlOnlineStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresqlOnlineStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner postgre(AsiakasRepository asRepository, TilausRepository tiRepository, TilausriviRepository tiriRepository, TuoteRepository tuRepository) {
		return (args) -> {
			Asiakas asiakas1 = new Asiakas("Matti", "Meikäläinen", "matti.meikalainen@example.com", "salasana123", "Esimerkkikatu 123", "00100", "Helsinki", "Suomi");
			Asiakas asiakas2 = new Asiakas("Maija", "Mallikas", "maija.mallikas@example.com", "salasana456", "Mallitie 1", "00500", "Helsinki", "Suomi");
			
			asRepository.save(asiakas1);
		    asRepository.save(asiakas2);
		    
		    Tilaus tilaus1 = new Tilaus(asiakas1, LocalDate.now(), LocalDate.now().plusDays(3), "Toimituksessa");
		    Tilaus tilaus2 = new Tilaus(asiakas2, LocalDate.now(), LocalDate.now().plusDays(2), "Valmistellaan");
		    
		    tiRepository.save(tilaus1);
		    tiRepository.save(tilaus2);
		    
		    Tuote tuote1 = new Tuote("Kahvi", "Tummapaahtoinen kahvi", new BigDecimal("4.99"));
		    Tuote tuote2 = new Tuote("Tee", "Vihreä tee", new BigDecimal("2.99"));
		    
		    tuRepository.save(tuote1);
		    tuRepository.save(tuote2);
		    
		    Tilausrivi tilausrivi1 = new Tilausrivi(tilaus1, tuote1, 2);
		    Tilausrivi tilausrivi2 = new Tilausrivi(tilaus1, tuote2, 1);
		    Tilausrivi tilausrivi3 = new Tilausrivi(tilaus2, tuote1, 3);
		    
		    tiriRepository.save(tilausrivi1);
		    tiriRepository.save(tilausrivi2);
		    tiriRepository.save(tilausrivi3);
		};
	}

}
