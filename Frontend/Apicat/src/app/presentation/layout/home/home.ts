import { Component } from "@angular/core";
import { Header } from "../header/header.component";
import { Dashboard } from "../dashboard/dashboard";
import { RouterOutlet } from "@angular/router";
import { Cards } from "../cards/cards";

@Component({
    selector : 'app-home',
    templateUrl : './home.html',
    styleUrl : './home.css',
    standalone : true,
    imports : [Header,Dashboard,RouterOutlet,Cards]
})
export class Home {
    constructor() {
        
    }
}