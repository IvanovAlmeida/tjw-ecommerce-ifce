package br.edu.ifce.model;

import br.edu.ifce.utils.StringUtils;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Item {
	@Id
	@GeneratedValue
	private int id;

	@Column(length = 50)
	private String name;

	@Column(length = 150)
	private String description;

	private String image;

	@Column(precision = 2)
	private Double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(@NotNull String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(@NotNull String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(@NotNull String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(@NotNull Double price) {
		this.price = price;
	}

	public String getFormatedPrice() {
		return StringUtils.FormatForMoney(price);
	}
}
