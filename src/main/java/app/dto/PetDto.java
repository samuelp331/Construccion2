package app.dto;

import app.models.Person;
import app.models.Pet;

public class PetDto {
	
	private int id;
	private String name;
	private int age;
	private long idNumber;
	private String species;
	private String race;
	private String characteristics;
	private double weight;
	private Person owner;
	
	public PetDto(String name, int age, long idNumber, String species, String race, String characteristics,double weight, Person owner) {
		this.name = name;
		this.age = age;
		this.idNumber = idNumber;
		this.species = species;
		this.race = race;
		this.characteristics = characteristics;
		this.weight = weight;
		this.owner = owner;
	}
	public PetDto(Pet pet) {
		this.name = pet.getName();
		this.age = pet.getAge();
		this.idNumber = pet.getIdNumber();
		this.species = pet.getSpecies();
		this.race = pet.getRace();
		this.characteristics = pet.getCharacteristics();
		this.weight = pet.getWeight();
		this.owner = pet.getOwner();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	
}
