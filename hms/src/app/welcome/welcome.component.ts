import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  name:string=''

  // Dependency Injection for ActivatedRoute to accept the parameters in the routing name(url)
  constructor(private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {

    // to take the values in url
    this.name=this.route.snapshot.params['name'];
  }

}
