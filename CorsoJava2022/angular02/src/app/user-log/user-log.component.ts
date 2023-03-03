import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-user-log',
  templateUrl: './user-log.component.html',
  styleUrls: ['./user-log.component.css']
})
export class UserLogComponent implements OnInit, OnChanges {

  constructor() { }
  @Input()user : any;
  inputtedName:string ="";
  logDisabled : boolean=true;

  ngOnInit(): void {
    console.log(this.user);
  }

  onInput(e: Event){
    this.inputtedName=(<HTMLInputElement>e.target).value;
    if (this.inputtedName.length>1){
      this.logDisabled=false;
    }
    else this.logDisabled=true;
  }

  logIn() {
    if (this.inputtedName.length>0){
      this.user.username=this.inputtedName;
      this.user.loggedIn=true;
      this.user.img="https://t3.gstatic.com/licensed-image?q=tbn:ANd9GcS1d5rgaDSUub7Nfnss88mzDRLZ5ICVKbPrXDHaEaD02f_VbHoDm8onuSYZxNLgxAfCNmKGxbYbODq1WkY"
      console.log(this.user);
    }
  }

  logOut() {
    this.user.username="";
    this.user.loggedIn=false;
    this.user.img="https://t3.ftcdn.net/jpg/03/35/13/14/360_F_335131435_DrHIQjlOKlu3GCXtpFkIG1v0cGgM9vJC.jpg"
    this.logDisabled=true;
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(this.user);

  }







}
