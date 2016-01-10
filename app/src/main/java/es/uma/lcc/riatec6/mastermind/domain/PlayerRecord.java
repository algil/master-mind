package es.uma.lcc.riatec6.mastermind.domain;

import java.util.Date;

/**
 * Created by LENOVO on 04/01/2016.
 */
public class PlayerRecord {
    private Integer id;
    private String name;
    private Integer score;
    private Date registerDate;

    public PlayerRecord() {
        this.id = null;
        this.name = null;
        this.score = null;
        this.registerDate = null;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setRegisterDate(Date date) {
        this.registerDate = date;
    }

    public Date getRegisterDate() {
        return this.registerDate;
    }

}
