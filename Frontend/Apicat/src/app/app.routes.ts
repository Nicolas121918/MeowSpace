import { Routes } from '@angular/router';
import { Login } from './presentation/features/auth/login/login';
import { Dashboard } from './presentation/layout/dashboard/dashboard';
import { Home } from './presentation/layout/home/home';
import { Cards } from './presentation/layout/cards/cards';
export const routes: Routes = [
    {
        path: 'login',
        component: Login


    },
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    },
    {
        path : 'dashboard',
        component : Dashboard
    },
    {
        path: 'home',
        component : Home
    },
    {
        path: 'cards',
        component : Cards
    }
];
