import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterLink, RouterOutlet} from "@angular/router";
import { NavbarComponent } from './core/components/navbar/navbar.component';
import { CrewMembersComponent } from './features/crew-members/crew-members.component';
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import { FlightsComponent } from './features/flights/flights.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CrewMembersComponent,
    FlightsComponent
  ],
  imports: [
    BrowserModule,
    RouterOutlet,
    RouterLink,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    CrewMembersComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
