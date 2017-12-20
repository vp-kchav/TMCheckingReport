package mum.edu.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import mum.edu.validator.DuplicatedStudentId;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull()
    @DuplicatedStudentId
    @NotEmpty(message= "NotEmpty.student.studentId")
    @Column(name = "studentId")
    private String studentId;
    @NotEmpty(message = "NotEmpty.student.firstName")
    @NotNull
    @Column(name = "firstName")
    private String firstName;
    @NotEmpty(message = "NotEmpty.student.lastName")
    @NotNull
    @Column(name = "lastName")
    private String lastName;
    @NotEmpty(message = "NotEmpty.student.email")
    @NotNull
    @Column(name = "email")
    private String email;
    @NotNull
    @Embedded
    private Address studentAddress;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy= "student")
    private List<TMCheckingReport> tmCheckings = new ArrayList<TMCheckingReport>();



    public Student(){
        
    }

    public List<TMCheckingReport> getTmCheckings() {
        return tmCheckings;
    }
    public void setTmCheckings(List<TMCheckingReport> tmCheckings) {
        this.tmCheckings = tmCheckings;
    }


    public Long getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public Address getStudentAddress() {
        return studentAddress;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void addChecking(TMCheckingReport checking) {
        tmCheckings.add(checking);
        checking.setStudent(this);
    }
    
    public void removeSeason(TMCheckingReport checking) {
        checking.setStudent(null);
        tmCheckings.remove(checking);
    }

    public int getNumberTmChecked() {
        int count=0;
        for(TMCheckingReport report : tmCheckings) {
            if(report.getStatus().equals(CheckingStatus.DONE)) {
                count++;
            }
        }
        return count;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", studentAddress=" + studentAddress +
                ", gender=" + gender +
                ", _TmCheckings=" + tmCheckings +
                '}';
    }
}
