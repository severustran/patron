package vn.liemtt.library.repository.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String studentId;
    private String fullName;
    private String faculty;
    private String studentType;
    private Boolean isTakenLO;
    private Boolean isGraduated;
    private Boolean isViolated;
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Temporal(TemporalType.DATE)
    private Date dateEnd;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(final String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(final String faculty) {
        this.faculty = faculty;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(final String studentType) {
        this.studentType = studentType;
    }

    public Boolean getTakenLO() {
        return isTakenLO;
    }

    public void setTakenLO(final Boolean takenLO) {
        isTakenLO = takenLO;
    }

    public Boolean getGraduated() {
        return isGraduated;
    }

    public void setGraduated(final Boolean graduated) {
        isGraduated = graduated;
    }

    public Boolean getViolated() {
        return isViolated;
    }

    public void setViolated(final Boolean violated) {
        isViolated = violated;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(final Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(final Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
