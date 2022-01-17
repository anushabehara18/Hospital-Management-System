import { Component, OnInit } from '@angular/core';
import { HardcodedAutenticationService } from '../service/hardcoded-autentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isUserLoggedIn:boolean=false;

  constructor(public hardcodedAutehnticationService:HardcodedAutenticationService) { }

  ngOnInit(): void {
    //this.isUserLoggedIn=this.hardcodedAutehnticationService.isUserLoggedIn();
  }

}
