/*
 * Created on Dec 15, 2017
 */
package mum.edu.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TMChecking {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date checkingDate;
    
    @Enumerated(EnumType.STRING)
    private CheckingStatus status;
        
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "advisor_id")
    private Advisor checkBy;

    public TMChecking() {
    }
    
    public Advisor getCheckBy() {
        return checkBy;
    }

    
    public void setCheckBy(Advisor checkBy) {
        this.checkBy = checkBy;
    }


    public TMChecking(Long id, Date checkingDate, CheckingStatus status) {
        super();
        this.id = id;
        this.checkingDate = checkingDate;
        this.status = status;
    }

}
