package com.user.controller;

import com.user.dto.PropertyUserDto;
import com.user.entity.PropertyUserEntity;
import com.user.service.PropertyUser;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController   //Rest ApI Class
@RequestMapping("/api/v1/propertyUser")
public class PropertyUserController {


    private PropertyUser pu;

    public PropertyUserController(PropertyUser pu) {
        this.pu = pu;
    }

    //http://localhost:8080/api/v1/propertyUser/addPropertyUser
    @PostMapping("/addPropertyUser")

    public ResponseEntity<?> addPropertyUser(@Valid @RequestBody PropertyUserDto dto,BindingResult result)
    {
        if(result.hasErrors())
        {

            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.OK);
        }

      PropertyUserDto propertyUserDto=pu.addPropertyUser(dto);

      return new ResponseEntity<>(propertyUserDto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/v1/propertyUser?propertyUserId=4

    @DeleteMapping
    public ResponseEntity<String> deletePropertyUser(@RequestParam long propertyUserId)
    {
        pu.deletePropertyUser(propertyUserId);

        return new ResponseEntity<>("record deleted", HttpStatus.OK);
    }

    ////http://localhost:8080/api/v1/propertyUser/1
    @PutMapping("/{propertyUserId}")
    public ResponseEntity<?> updatePropertyUser(@PathVariable long propertyUserId,
                                                                 @RequestBody PropertyUserDto dto
                                                                 )
    {

     PropertyUserEntity propertyUser= pu.updatePropertyUser(propertyUserId, dto);

     return new ResponseEntity<>(propertyUser,HttpStatus.OK);
    }


    //http://localhost:8080/api/v1/propertyUser?pageSize=3&pageNo=0&sortBy=emailId&sortDir=desc
    @GetMapping
    public ResponseEntity<List <PropertyUserDto>> getPropertyUsers(

            @RequestParam(name="pageSize",defaultValue = "5",required = false) int pageSize,
            @RequestParam(name="pageNo",defaultValue= "0",required = false) int pageNo,
            @RequestParam(name="sortBy",defaultValue= "id",required = false) String sortBy,
            @RequestParam(name="sortDir",defaultValue= "id",required = false) String sortDir
    )
    {


      List<PropertyUserDto> propertyUserEntities=  pu.getPropertyUsers(pageSize,pageNo,sortBy,sortDir);

      return new ResponseEntity<>(propertyUserEntities,HttpStatus.OK);
    }

    @GetMapping("/getUserById")
    public ResponseEntity<PropertyUserEntity> getPropertyUserById(@RequestParam long propertyUserId)
    {

        PropertyUserEntity propertyUserEntities=  pu.getPropertyUserById(propertyUserId);

        return new ResponseEntity<>(propertyUserEntities,HttpStatus.OK);
    }
}
