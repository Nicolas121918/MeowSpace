import { Component } from '@angular/core';
import { AuthService } from '../../../../infrastructure/services/authservice';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-auth',
  standalone: true,
  templateUrl: './login.html',
  styleUrls: ['./login.css'],
  imports: [FormsModule, CommonModule]
})
export class Login {
  isLogin: boolean = true;
  isLoading: boolean = false;

  loginData = { username: '', password: '' };
  registerData = { username: '', email: '', password: '' };

  constructor(
    private authService: AuthService,
    private router: Router,
    private toastr: ToastrService
  ) { }


  toggleMode(mode: boolean): void {
    this.isLogin = mode;
  }


  Reset() {
    this.registerData.username = ''
    this.registerData.email = ''
    this.registerData.password = ''
  }


  private isValidEmail(email: string): boolean {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  }


  onLogin(): void {
    // Validar campos y aplicar trim
    const username = this.loginData.username.trim();
    const password = this.loginData.password.trim();

    if (!username || !password) {
      this.toastr.warning('Por favor completa todos los campos', 'Validación');
      return;
    }

    this.isLoading = true;
    this.authService.login({ username, password }).subscribe({
      next: (res) => {
        this.isLoading = false;
        if (res) {
          this.toastr.success('¡Bienvenido! Iniciando sesión...', 'Éxito');
          setTimeout(() => this.router.navigate(['/home']), 1500);
        } else {
          this.toastr.error('Credenciales incorrectas', 'Error');
        }
      },
      error: (err) => {
        this.isLoading = false;
        this.toastr.error(err.message || 'Error al conectar con el servidor', 'Error');
      }
    });
  }


  onRegister(): void {
    // Validar campos y aplicar trim
    const username = this.registerData.username.trim();
    const email = this.registerData.email.trim();
    const password = this.registerData.password.trim();

    if (!username || !email || !password) {
      this.toastr.warning('Por favor completa todos los campos', 'Validación');
      return;
    }

    // Validar email básico
    if (!this.isValidEmail(email)) {
      this.toastr.error('Por favor ingresa un email válido', 'Validación');
      return;
    }

    if (password.length < 6) {
      this.toastr.warning('La contraseña debe tener al menos 6 caracteres', 'Validación');
      return;
    }
    this.isLoading = true;
    this.authService.register({ username, email, password }).subscribe({
      next: () => {
        this.isLoading = false;
        this.toastr.success('¡Registro exitoso! Redireccionando....');

      },
      error: (err) => {
        this.isLoading = false;
        this.toastr.error(err.message || 'Error en el registro', 'Error');
      }
    });
    this.Reset()
    this.isLogin = true;
  }

}