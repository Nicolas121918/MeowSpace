import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class GatoService {
  private API_URL = 'http://localhost:8080/images';

  constructor(private http: HttpClient) { }

  // Carga inicial
  obtenerGatos(): Observable<any[]> {
    return this.http.get<any[]>(`${this.API_URL}/galeria`);
  }

  // Llenar el select
  obtenerTodasLasRazas(): Observable<any[]> {
    return this.http.get<any[]>(`${this.API_URL}/all-breeds`);
  }

  // Filtrar
  obtenerGatosPorRaza(idRaza: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.API_URL}/imagesbybreedid?breedId=${idRaza}`);
  }
}