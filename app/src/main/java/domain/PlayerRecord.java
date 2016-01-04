package domain;

import java.util.Date;

/**
 * Created by LENOVO on 04/01/2016.
 */
public class PlayerRecord {
    private Integer id;
    private String name;
    private Integer points;
    private Date registerDate;

    public PlayerRecord() {
        this.id = null;
        this.name = null;
        this.points = null;
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

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getPoints() {
        return this.points;
    }

    public void setRegisterDate(Date date) {
        this.registerDate = date;
    }

    public Date getRegisterDate() {
        return this.registerDate;
    }

}
