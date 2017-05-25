package com.he.maven.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "user")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotEmpty(message = "名字不为空")
    private String  name;
    private String  md5Password;
    private String  sha1Password;
    private String  salt;
    private Integer state;


}