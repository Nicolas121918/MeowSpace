import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject, throwError } from 'rxjs';
import { User } from '../../core/models/user.model';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly URL_USER = 'http://localhost:8080/auth';
  private userSubject = new BehaviorSubject<User | null>(null);
  public user$ = this.userSubject.asObservable();

  constructor(private http: HttpClient) {}

  login(credentials: any): Observable<boolean> {
    try {
      return this.http.post<boolean>(`${this.URL_USER}/login`, credentials).pipe(
        tap(isOk => {
          if(isOk) this.userSubject.next({ username: credentials.username, email: '' });
        }),
        catchError(error => {
          console.error('Error en login:', error);
          return throwError(() => new Error(error.error?.message || 'Error al intentar iniciar sesión'));
        })
      );
    } catch (error) {
      console.error('Error en login:', error);
      return throwError(() => new Error('Error al procesar la solicitud'));
    }
  }

  register(user: User): Observable<User> {
    try {
      return this.http.post<User>(`${this.URL_USER}/register`, user).pipe(
        catchError(error => {
          console.error('Error en registro:', error);
          return throwError(() => new Error(error.error?.message || 'Error al registrar usuario'));
        })
      );
    } catch (error) {
      console.error('Error en registro:', error);
      return throwError(() => new Error('Error al procesar la solicitud'));
    }
  }
}