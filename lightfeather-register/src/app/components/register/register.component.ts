import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

 

export class RegisterComponent implements OnInit {
  // tslint:disable-next-line: max-line-length
  emailRegex = '(?:[a-z0-9!#$%&\'*+\/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&\'*+\/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])';

  public Registration: FormGroup;

  email: any;
  username: any;
  password: any;
  confirmation: any;

  constructor(private route: Router) { }

  ngOnInit() {
    this.Registration = new FormGroup({});
    this.email = new FormControl('', [Validators.required, Validators.pattern(this.emailRegex)]);
    this.username = new FormControl('', [Validators.required, Validators.maxLength(15)]);
    this.password = new FormControl('', [Validators.required, Validators.maxLength(15)])
    this.Registration.addControl('Password', this.password);
    this.confirmation = new FormControl(
      '', [Validators.compose(
        [Validators.required, Validators.maxLength(15), this.validateAreEqual.bind(this)]
      )]);
   
    this.Registration.addControl('Username', this.username);
    this.Registration.addControl('Email', new FormControl('', [Validators.required, Validators.maxLength(15)]));
    
    this.Registration.addControl('Confirmation', this.confirmation);
  }

  private validateAreEqual(fieldControl: FormControl) {
    return fieldControl.value === this.Registration.get('Password').value ? null : {
      NotEqual: true
    };
  }
  public clearPassword(){
    this.confirmation.reset();
  }

  onSubmit() {
    this.route.navigateByUrl('/top-secret-data');
}

}