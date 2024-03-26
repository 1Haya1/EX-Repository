package org.example.exr.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.exr.Api.ApiResponse;
import org.example.exr.Model.User;
import org.example.exr.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.updateUser(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }

    @GetMapping("/find-name-password/{username}/{password}")
    public ResponseEntity findByUsernameAndPassword(@PathVariable String username , @PathVariable String password){
        return ResponseEntity.status(200).body(userService.findByUsernameAndPassword(username , password));
    }

    @GetMapping("/get-email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email) {
            return ResponseEntity.status(200).body(userService.getUserByEmail(email));

    }

    @GetMapping("/get-role/{role}")
    public ResponseEntity getUsersByRole(@PathVariable String role) {
        return ResponseEntity.status(200).body(userService.getUsersByRole(role));
    }

    @GetMapping("/get-age/{age}")
    public ResponseEntity getUsersWithAgeOrAbove(@PathVariable Integer age) {
        return ResponseEntity.status(200).body(userService.getUsersWithAgeOrAbove(age));
    }
}




