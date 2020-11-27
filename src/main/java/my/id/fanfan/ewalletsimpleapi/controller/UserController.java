package my.id.fanfan.ewalletsimpleapi.controller;

import javassist.expr.NewArray;
import my.id.fanfan.ewalletsimpleapi.entity.User;
import my.id.fanfan.ewalletsimpleapi.model.Response;
import my.id.fanfan.ewalletsimpleapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    private ResponseEntity getUsers(){
        Response bodyResponse = new Response(HttpStatus.OK.value(), Response.MESSAGE_SUCCSESS, userService.getUsers());
        return ResponseEntity.ok(bodyResponse);
    }
    @GetMapping("/user/{id}")
    private ResponseEntity user(@PathVariable Long id){
        try {
            Response bodyResponse = new Response( (HttpStatus.OK.value()), Response.MESSAGE_SUCCSESS,userService.getUser(id));
            return ResponseEntity.ok(bodyResponse);
        }catch (NoSuchElementException e){
            Response bodyResponse = new Response(HttpStatus.NOT_FOUND.value(), "Data tidak ditemukan");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyResponse);
        }
    }
    @GetMapping("/addbalance/{id}/{balance}")
    private ResponseEntity user(@PathVariable Long id,@PathVariable Long balance){
        try {
            Response bodyResponse = new Response( (HttpStatus.OK.value()), Response.MESSAGE_SUCCSESS,userService.addBalance(id,balance));
            return ResponseEntity.ok(bodyResponse);
        }catch (NoSuchElementException e){
            Response bodyResponse = new Response(HttpStatus.NOT_FOUND.value(), "Data tidak ditemukan");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyResponse);
        }
    }
    @GetMapping("/transfer/{senderId}/{recipientId}/{value}")
    private ResponseEntity user(@PathVariable Long senderId,@PathVariable Long recipientId,@PathVariable Long value){
        try {
            Response bodyResponse = new Response( (HttpStatus.OK.value()), Response.MESSAGE_SUCCSESS,userService.transferBalance(senderId,recipientId,value));
            return ResponseEntity.ok(bodyResponse);
        }catch (NoSuchElementException e){
            Response bodyResponse = new Response(HttpStatus.NOT_FOUND.value(), "Data tidak ditemukan");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyResponse);
    }
    }

    @PostMapping(value = "/register",consumes = "application/json")
    private ResponseEntity createUser(@RequestBody User user){
        Response bodyResponse = new Response(HttpStatus.OK.value(), Response.MESSAGE_SUCCSESS, userService.createUser(user));
        return ResponseEntity.ok(bodyResponse);
    }
}
