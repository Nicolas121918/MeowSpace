import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Importación de Componentes
import { HomeComponent } from './presentation/layouts/header/home/home';
import { SearchCatComponent } from './presentation/components/search-cat/search-cat.component';

// Importación del Guard
import { AuthGuard } from './presentation/guards/auth.guard';

const routes: Routes = [
  { 
    path: '', 
    component: HomeComponent 
  },
  { 
    path: 'search', 
    component: SearchCatComponent,
    canActivate: [AuthGuard] // Protección de la ruta
  },
  // Redirección por defecto si la ruta no existe
  { 
    path: '**', 
    redirectTo: '' 
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }