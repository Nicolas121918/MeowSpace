import { Component, OnInit } from '@angular/core';
import { CatApiService } from '../../../infrastructure/services/cat-api.service';
import { Breed, CatImage } from '../../../core/models/breed.model';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.html',
  styleUrls: ['./dashboard.css'],
  imports: [FormsModule]
})
export class Dashboard {
  constructor(private router: Router) { }

  logout() {
    this.router.navigate(['/login'])
  }

}