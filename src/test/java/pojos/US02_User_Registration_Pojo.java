package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)

public class US02_User_Registration_Pojo {
    /*
         {
        "activated": true,
            "authorities": [
                "string"
               ],
            "createdBy": "string",
            "createdDate": "2022-07-04T17:51:27.327Z",
            "email": "string",
            "firstName": "string",
            "id": 0,
            "imageUrl": "string",
            "langKey": "string",
            "lastModifiedBy": "string",
            "lastModifiedDate": "2022-07-04T17:51:27.327Z",
            "lastName": "string",
            "login": "string",
            "password": "string",
            "ssn": "string"
    }
     */
    private boolean activated;
    private String[] authorities;
    private String createdBy;
    private String createdDate;
    private String email;
    private String firstName;
    private int id;
    private String imageUrl;
    private String langKey;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private String lastName;
    private String login;
    private String password;
    private String ssn;

    public US02_User_Registration_Pojo(boolean activated, String[] authorities, String createdBy, String createdDate, String email, String firstName, int id, String imageUrl, String langKey, String lastModifiedBy, String lastModifiedDate, String lastName, String login, String ssn) {
        this.activated = activated;
        this.authorities = authorities;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.imageUrl = imageUrl;
        this.langKey = langKey;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.lastName = lastName;
        this.login = login;
        this.ssn = ssn;
    }

    public US02_User_Registration_Pojo(String email, String firstName, String lastName, String login, String password, String ssn) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.ssn = ssn;
    }

    public US02_User_Registration_Pojo() {
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "US02_User_Registration_Pojo{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", langKey='" + langKey + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}

