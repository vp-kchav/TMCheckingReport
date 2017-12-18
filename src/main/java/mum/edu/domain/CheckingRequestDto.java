/*
 * Created on Dec 17, 2017
 */
package mum.edu.domain;

import java.time.LocalDateTime;

public class CheckingRequestDto {

    private String studentId;
    private String studentName;
    private LocalDateTime dateChecking;
    private CheckingStatus status;
    
    
    public CheckingRequestDto(String studentId, String studentName, LocalDateTime dateChecking, CheckingStatus status) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateChecking = dateChecking;
        this.status = status;
    }


    public String getStudentId() {
        return studentId;
    }

    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    
    public String getStudentName() {
        return studentName;
    }

    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    
    public LocalDateTime getDateChecking() {
        return dateChecking;
    }

    
    public void setDateChecking(LocalDateTime dateChecking) {
        this.dateChecking = dateChecking;
    }

    
    public CheckingStatus getStatus() {
        return status;
    }

    
    public void setStatus(CheckingStatus status) {
        this.status = status;
    }

    public CheckingRequestDto() {
        // TODO Auto-generated constructor stub
    }

}
