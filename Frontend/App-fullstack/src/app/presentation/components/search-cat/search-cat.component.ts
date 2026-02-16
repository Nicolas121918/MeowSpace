import { Component } from '@angular/core';
import { GetBreedByIdUseCase } from '../../../core/models/usecases/get-breed-by-id.usecase';
import { Breed } from '../../../core/models/breed.model';

@Component({
  selector: 'app-search-cat',
  templateUrl: './search-cat.component.html',
  styleUrls: ['./search-cat.component.css']
})
export class SearchCatComponent {
  searchId: string = '';
  breed: Breed | null = null;
  error: string = '';

  constructor(private getBreedByIdUseCase: GetBreedByIdUseCase) {}

  search() {
    this.error = '';
    this.getBreedByIdUseCase.execute(this.searchId).subscribe({
      next: (data) => this.breed = data,
      error: () => {
        this.error = 'No se encontró la raza.';
        this.breed = null;
      }
    });
  }
}