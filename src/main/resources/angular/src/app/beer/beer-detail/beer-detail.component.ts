import { Component, Input, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Http, Response, Headers } from "@angular/http";
import { HttpParams } from "@angular/common/http";
import { Beer } from '../../beer';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-beer-detail',
  templateUrl: './beer-detail.component.html',
  styleUrls: ['./beer-detail.component.css']
})
export class BeerDetailComponent {
  @Input() selectedBeer: Beer;
  @Output() onSubmitted = new EventEmitter();

  constructor(private http:Http) {
  }

  submit() {
    this.http
        .post(environment.contextRoot + '/rest/beer', this.selectedBeer)
        .subscribe(
          result => this.onSubmitted.emit()
        );
  }
}
