import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Breed } from '../../core/models/breed.model';
import { GetBreedByIdUseCase } from '../../core/models/usecases/get-breed-by-id.usecase';

@Injectable({
  providedIn: 'root'
})
export class CatApiService implements GetBreedByIdUseCase {
  private readonly URL = 'http://localhost:8081/cats/search';

  constructor(private http: HttpClient) {}

  execute(id: string): Observable<Breed> {
    return this.http.get<Breed>(`${this.URL}?id=${id}`);
  }
}