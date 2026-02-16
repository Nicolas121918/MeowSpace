import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Breed } from '../../core/models/breed.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  // Usamos BehaviorSubject para el patrón Observable que explicaste en el examen
  private selectedBreedSubject = new BehaviorSubject<Breed | null>(null);
  
  constructor() { }

  // Método para actualizar la raza seleccionada
  setSelectedBreed(breed: Breed): void {
    this.selectedBreedSubject.next(breed);
  }

  // Método para obtener la raza como Observable 
  getSelectedBreed(): Observable<Breed | null> {
    return this.selectedBreedSubject.asObservable();
  }

  // Método para limpiar el estado
  clearData(): void {
    this.selectedBreedSubject.next(null);
  }
}