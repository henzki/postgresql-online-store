package com.henzki.postgresql.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tilausrivi")
public class Tilausrivi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tilausrivi_id;

    @ManyToOne
    @JoinColumn(name = "tilaus_id", nullable = false)
    private Tilaus tilaus;

	@Column(nullable = false, insertable = false, updatable = false)
	private Long tilaus_id;

    @ManyToOne
    @JoinColumn(name = "tuote_id", nullable = false)
    private Tuote tuote;

	@Column(nullable = false, insertable = false, updatable = false)
	private Long tuote_id;

    @Column(nullable = false)
    private Integer maara;
    
    public Tilausrivi() {
		super();
	}

	public Tilausrivi(Tilaus tilaus, Tuote tuote, Integer maara) {
		super();
		this.tilaus = tilaus;
		this.tuote = tuote;
		this.maara = maara;
	}

	public Long getTilausrivi_id() {
		return tilausrivi_id;
	}

	public void setTilausrivi_id(Long tilausrivi_id) {
		this.tilausrivi_id = tilausrivi_id;
	}

	public Tilaus getTilaus() {
		return tilaus;
	}

	public void setTilaus(Tilaus tilaus) {
		this.tilaus = tilaus;
	}

	public Tuote getTuote() {
		return tuote;
	}

	public void setTuote(Tuote tuote) {
		this.tuote = tuote;
	}

	public Integer getMaara() {
		return maara;
	}

	public void setMaara(Integer maara) {
		this.maara = maara;
	}

	public Long getTilaus_id() {
		if (tilaus != null) {
			return tilaus.getTilaus_id();
		}
		return null;
	}

	public void setTilaus_id(Long tilaus_id) {
		this.tilaus_id = tilaus_id;
	}

	public Long getTuote_id() {
		if (tuote != null) {
			return tuote.getTuote_id();
		}
		return null;
	}

	public void setTuote_id(Long tuote_id) {
		this.tuote_id = tuote_id;
	}
    
}

