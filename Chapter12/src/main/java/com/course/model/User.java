package com.course.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String age;
    private String sex;
    private String permission;
    private String idDelete;

    //重写toString，以使得满足格式要求
    @Override
    public String toString(){
        return(
                "{"+
                "id:"+id+","+
                "userName:"+userName+","+
                "age:"+age+","+
                "sex:"+sex+","+
                "permission:"+permission+","+
                "idDelete:"+idDelete+
                        "}"
                );

    }
}
