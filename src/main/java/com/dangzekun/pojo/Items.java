package com.dangzekun.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Items implements Serializable {
    @Id
    //当前id是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增长的模式
    private Integer id;
    private String name;
    private Float price;
    private String detail;
    private String pic;
    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    private String createtime;

}
