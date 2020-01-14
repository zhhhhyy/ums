package com.example.demo.controller;

import com.example.demo.bean.Car;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/car")
@Validated
public class CarController {

    @RequestMapping("/valid2")
    public String param(@NotBlank(message = "group不能为空")
                            @RequestParam("group") String group,

                        @NotBlank(message = "email不能为空")
                            @Email(message="不符合邮箱规格")
                            @RequestParam("email") String email){
        return group +":" +email;
    }

    @RequestMapping("/valid/{group:[a-zA-Z0-9_]+}/{userid}")
    public String valid1(@PathVariable("group") String group,
                         @PathVariable("userid") String userid){
        return group+":"+userid;
    }

    @RequestMapping("/getcar4")
    public Car getCarById2(Car car) {
        return car;
    }
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    @RequestMapping("/getcar3")
    public Car getCarById(@RequestBody Car car) {
        return car;
    }

    @RequestMapping("/getParam/{name}")
    public Car getParam(@RequestParam int id, @PathVariable String name){
        Car car = new Car();
        car.setId(id);
        car.setName(name);
        car.setPrice(100000.99F);
        car.setCreatedate(new Date());
        return car;
    }

    @RequestMapping("/findone")
    public Car findOneCar(){
        Car car = new Car(1, "toyo", 1999.99F,new Date(),"","");
        return car;
    }

    @RequestMapping("/getall")
    public List<Car> getAll(){
        List<Car> list=new ArrayList<>();
        Car car1 = new Car(1, "toyo", 1999.99F,new Date(),"","");
        Car car2= new Car(2, "dazhong", 2999.99F,new Date(),"","");
        Car car3 = new Car(3, "fengtian", 3999.99F,new Date(),"","");
        Car car4 = new Car(4, "benchi", 4999.99F,new Date(),"","");

        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);

        return list;

    }
}
