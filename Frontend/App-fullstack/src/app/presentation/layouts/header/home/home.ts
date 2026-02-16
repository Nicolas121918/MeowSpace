import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  // Variables que usábamos para la presentación en el HTML
  public welcomeTitle: string = 'CatAPI Manager';
  public welcomeMessage: string = 'Sistema de gestión y consulta de razas felinas.';

  constructor(private router: Router) { 
    // Inyectamos el Router para la navegación hacia el buscador
  }

  ngOnInit(): void {
    // Verificamos que el componente cargue correctamente
    console.log('HomeComponent cargado correctamente');
  }

  /**
   * Método para navegar a la sección de búsqueda de gatos
   * Se activa al hacer clic en el botón de la página de inicio
   */
  public startExploring(): void {
    this.router.navigate(['/search']);
  }

}