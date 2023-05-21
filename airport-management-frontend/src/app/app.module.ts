import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterLink, RouterOutlet} from "@angular/router";
import { NavbarComponent } from './core/components/navbar/navbar.component';
import { CrewMembersComponent } from './features/crew-members/crew-members.component';
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import { FlightsComponent } from './features/flights/flights.component';
import { CrewMemberComponent } from './features/crew-member/crew-member.component';
import { CrewMemberNewFormComponent } from './features/crew-member-new-form/crew-member-new-form.component';
import { FormsModule } from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CrewMembersComponent,
    FlightsComponent,
    CrewMemberComponent,
    CrewMemberNewFormComponent
  ],
  imports: [
    BrowserModule,
    RouterOutlet,
    RouterLink,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    CrewMembersComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
