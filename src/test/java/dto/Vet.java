package dto;

public class Vet {
String firstName,lastName;
int id;
public String getFirstName() {
	return firstName;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Speciality[] getSpecialties() {
	return specialties;
}
public void setSpecialties(Speciality[] specialties) {
	this.specialties = specialties;
}
Speciality[] specialties;
}
