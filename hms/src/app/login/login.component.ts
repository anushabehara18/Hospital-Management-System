import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAutenticationService } from '../service/hardcoded-autentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string='anusha';
  password:string='dummy';
  errorMessage:string='Invalid Credentials';
  invalidLogin:boolean=false;

  
  // Dependency Injection
  constructor(private router:Router, private hardcodedAuthentication:HardcodedAutenticationService) { }

  ngOnInit(): void {
  }

  // on clicking login button

  login(){

    // checking for correct username and password (hard coding)

    // console.log(this.username);
    //if(this.username==="anusha" && this.password === 'dummy') {

    if(this.hardcodedAuthentication.authenticate(this.username, this.password))
     {
      //Redirect to Welcome Page
      this.router.navigate(['welcome', this.username])
      this.invalidLogin = false
      } 
      else
      {
      this.invalidLogin = true
      }
  }
}
