package com.c2code.realproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone_detail")
public class PhoneDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String screen;
	
	private String cpu;
	
	private String ram;
	
	private String rom;
	
	private String battery;
	
	private String bcamera;
	
	private String acamera;
	
	@OneToOne
	@JoinColumn(name = "phone_id")
	private Phone phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getBcamera() {
		return bcamera;
	}

	public void setBcamera(String bcamera) {
		this.bcamera = bcamera;
	}

	public String getAcamera() {
		return acamera;
	}

	public void setAcamera(String acamera) {
		this.acamera = acamera;
	}
	
	
}
