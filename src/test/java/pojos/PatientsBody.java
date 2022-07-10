package pojos;

public class PatientsBody {
    /*
    {
        "createdBy": "anonymousUser",
        "createdDate": "2021-12-16T16:34:24.652207Z",
        "id": 2551,
        "firstName": "Doctor",
        "lastName": "Doctor",
        "birthDate": null,
        "phone": "222-333-2322",
        "gender": "MALE",
        "bloodGroup": "ABnegative",
        "adress": null,
        "email": "doctor@email.com",
        "description": null,
        "user": {
            "createdBy": "anonymousUser",
            "createdDate": "2021-12-14T10:38:26.705059Z",
            "id": 2001,
            "login": "doctor",
            "firstName": "Doctor",
            "lastName": "Doctor",
            "email": "doctore@email.com",
            "activated": true,
            "langKey": "en",
            "imageUrl": null,
            "resetDate": null,
            "ssn": "234-55-3432"
        },
        "appointments": null,
        "inPatients": null,
        "country": {
            "id": 1201,
            "name": "Türkye"
        },
        "cstate": {
            "id": 1262,
            "name": "Hawaii",
            "country": {
                "id": 1201,
                "name": "Türkye"
            }
        }
    },
     */
    private String createdBy;
    private String createdDate;
    private Integer id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phone;
    private String gender;
    private String bloodGroup;
    private String adress;
    private String email;
    private String description;
    private User user;
    private String appointments;
    private String inPatients;
    private Country country;
    private Cstate cstate;

    public PatientsBody(String createdBy, String createdDate, Integer id, String firstName, String lastName, String birthDate, String phone, String gender, String bloodGroup, String adress, String email, String description, User user, String appointments, String inPatients, Country country, Cstate cstate) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.adress = adress;
        this.email = email;
        this.description = description;
        this.user = user;
        this.appointments = appointments;
        this.inPatients = inPatients;
        this.country = country;
        this.cstate = cstate;
    }

    public PatientsBody() {
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAppointments() {
        return appointments;
    }

    public void setAppointments(String appointments) {
        this.appointments = appointments;
    }

    public String getInPatients() {
        return inPatients;
    }

    public void setInPatients(String inPatients) {
        this.inPatients = inPatients;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Cstate getCstate() {
        return cstate;
    }

    public void setCstate(Cstate cstate) {
        this.cstate = cstate;
    }

    @Override
    public String  toString() {
        return "PatientsBody{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", appointments='" + appointments + '\'' +
                ", inPatients='" + inPatients + '\'' +
                ", country=" + country +
                ", cstate=" + cstate +
                '}';
    }
}
