/*
 * Created on Dec 15, 2017
 */
package mum.edu.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class TMCheckingReport {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    
//    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime checkingDate;
    
    @Enumerated(EnumType.STRING)
    private CheckingStatus status;
    
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;
    
    

    public TMCheckingReport() {
    }

    public Long getId() {
        return id;
    }
    
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
    public Student getStudent() {
        return student;
    }
    
    
    public void setStudent(Student student) {
        this.student = student;
    }

    
    public LocalDateTime getCheckingDate() {
        return checkingDate;
    }

    
    public void setCheckingDate(LocalDateTime checkingDate) {
        this.checkingDate = checkingDate;
    }

    
    public CheckingStatus getStatus() {
        return status;
    }

    
    public void setStatus(CheckingStatus status) {
        this.status = status;
    }

    
    public TMCheckingReport(Long id, LocalDateTime checkingDate, CheckingStatus status) {
        super();
        this.id = id;
        this.checkingDate = checkingDate;
        this.status = status;
    }
        
}
