package com.vivek.springjdbc;


import com.vivek.springjdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan(basePackages = {"com.vivek.springjdbc"})
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(App.class);
        JdbcTemplate jdbcTemplate = context.getBean("getJdbcTemplate", JdbcTemplate.class);
        Student student=new Student(112,"hyderabad","vivek");

        String query="insert into student_info(id,city,name) values(?,?,?)";
        int r = jdbcTemplate.update(query, student.getId(), student.getCity(), student.getName());
        System.out.println(" Row inserted "+r);

    }
}
