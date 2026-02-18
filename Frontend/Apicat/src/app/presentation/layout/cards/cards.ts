import { Component, OnInit, ChangeDetectionStrategy, ChangeDetectorRef } from "@angular/core";
import { GatoService } from "../../../infrastructure/services/catservices";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.html',
  styleUrl: './cards.css',
  standalone: true,
  imports: [CommonModule],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class Cards implements OnInit {
  listaGatos: any[] = [];
  listaRazas: any[] = [];
  listaGatosFiltrados: any[] = [];
  listaGatosOriginal: any[] = [];

  constructor(private gatoService: GatoService, private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
    // Cargar Gatos
    this.gatoService.obtenerGatos().subscribe(res => {
      this.listaGatosOriginal = res;
      this.listaGatosFiltrados = res;
      this.listaGatos = res;
      this.cdr.markForCheck();
    });

    // Cargar las opciones del Select 
    this.gatoService.obtenerTodasLasRazas().subscribe(res => {
      this.listaRazas = res;
      this.cdr.markForCheck();
    });
  }
  getTotalGatos(): number {
    return this.listaGatos.length;
  }

  filtrarGatos(event: any): void {
    const id = event.target.value;

    if (id) {
      this.gatoService.obtenerGatosPorRaza(id).subscribe(res => {
        this.listaGatos = res;
        this.cdr.markForCheck();
      });
    } else {
      // renderiza la carga normal 
      this.ngOnInit();
    }
  }

  buscarGato(event: any) {
    const texto = event.target.value.toLowerCase();

    this.listaGatosFiltrados = this.listaGatosOriginal.filter(gato => {
      // Buscamos el nombre dentro del array breeds del gato
      const nombreRaza = gato.breeds?.[0]?.name.toLowerCase() || '';
      return nombreRaza.includes(texto);
    });
    this.listaGatos = this.listaGatosFiltrados;

    this.cdr.markForCheck();
  }
}