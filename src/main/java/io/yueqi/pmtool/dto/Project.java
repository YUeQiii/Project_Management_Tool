package io.yueqi.pmtool.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity  //在数据库中要对应/mapping出一张表 schema和class的fields对应
@Getter
@Setter
@NoArgsConstructor


public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotBlank(message = "Project Name is required")
    private String projectName;

    @NotBlank(message = "Project Identifier is required")
    @Size(min =4, max = 6, message = "Please use 4 to 6 characters")
    @Column(updatable = false, unique = true)
    private String projectId;

    @NotBlank(message = "Project description is required")
    private String descpription;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date endDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createAt;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updateAt;

    @PrePersist
    protected void onCreate(){
        this.createAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){this.updateAt = new Date();}

}
