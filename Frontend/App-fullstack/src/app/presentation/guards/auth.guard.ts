import { Injectable } from '@angular/core';
import { 
  CanActivate, 
  ActivatedRouteSnapshot, 
  RouterStateSnapshot, 
  UrlTree, 
  Router 
} from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router) {
    // El router nos permite redirigir al usuario si no tiene acceso
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
  
    // Por ahora, lo dejamos como 'true' para que puedas probar la navegación.
    const isAuthenticated = true; 

    if (isAuthenticated) {
      return true;
    } else {
      // Si no está autenticado, lo mandamos al Home (o al Login si tuvieras uno)
      this.router.navigate(['/']);
      return false;
    }
  }
}