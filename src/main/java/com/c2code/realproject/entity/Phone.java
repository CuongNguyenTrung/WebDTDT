package com.c2code.realproject.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.c2code.realproject.utils.MoneyUtils;

@Entity
@Table(name = "phone")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String image;

	private BigInteger newprice;
	
	private BigInteger oldprice;
	
	
	@OneToOne(mappedBy = "phone", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private PhoneDetail phoneDetail;

	@ManyToOne
	@JoinColumn(name = "phonetype_id")
	private PhoneType type;

	@OneToMany(mappedBy = "phone", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<PhoneImage> phoneImages = new ArrayList<>();

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public PhoneDetail getPhoneDetail() {
		return phoneDetail;
	}

	public void setPhoneDetail(PhoneDetail phoneDetail) {
		this.phoneDetail = phoneDetail;
	}

	public List<PhoneImage> getPhoneImages() {
		return phoneImages;
	}

	public void setPhoneImages(List<PhoneImage> phoneImages) {
		this.phoneImages = phoneImages;
	}

	public void addPhoneImage(PhoneImage phoneImage) {
		phoneImage.setPhone(this);
		phoneImages.add(phoneImage);
	}
	
	public void addPhoneImages(List<PhoneImage> phoneImages) {
		for (PhoneImage phoneImage : phoneImages) {
			addPhoneImage(phoneImage);
		}
	}
	
	public void addPhoneDetail(PhoneDetail phoneDetail) {
		this.phoneDetail = phoneDetail;
		phoneDetail.setPhone(this);
	}

	public BigInteger getNewprice() {
		return newprice;
	}

	public void setNewprice(BigInteger newprice) {
		this.newprice = newprice;
	}

	public BigInteger getOldprice() {
		return oldprice;
	}

	public void setOldprice(BigInteger oldprice) {
		this.oldprice = oldprice;
	}

	public String getOldpricestring() {
		return MoneyUtils.money(oldprice);
	}
	
	public String getNewpricestring() {
		return MoneyUtils.money(newprice);
	}
	
	public String getPhonelink() {
		String link = name;
		link = link.replaceAll(" ", "-").toLowerCase();
		return link;
	}
	
	public BigInteger save() {
		if(oldprice != null) {
			return oldprice.subtract(newprice);
		}
		return null;
	}
	
	public String getSaving() {
		if(oldprice != null) {
			return MoneyUtils.money(oldprice.subtract(newprice));
		}
		return null;
	}
}	
