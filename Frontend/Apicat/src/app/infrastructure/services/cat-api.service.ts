import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Breed, CatImage } from '../../core/models/breed.model';

@Injectable({
  providedIn: 'root'
})
export class CatApiService {
  private readonly URL_BASE = 'http://localhost:8081'; 

  constructor(private http: HttpClient) {}

  // GET All Breeds
  getBreeds(): Observable<Breed[]> {
    return this.http.get<Breed[]>(`${this.URL_BASE}/cats/breeds`);
  }

  // GET ById
  getBreedById(id: string): Observable<Breed> {
    return this.http.get<Breed>(`${this.URL_BASE}/cats/breeds/${id}`);
  }

  // GET ByBreed
  getImagesByBreed(breedId: string): Observable<CatImage[]> {
    return this.http.get<CatImage[]>(`${this.URL_BASE}/images/imagesbybreedid?id=${breedId}`);
  }
}